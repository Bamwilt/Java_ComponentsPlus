package ComponentCustoms;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class JavaTextCompleter {

    private final JTextComponent textComponent;
    private final List<String> suggestions;
    private final boolean popupMode;

    public JavaTextCompleter(JTextComponent tc, boolean popupMode, List<String> suggestions) {
        this.textComponent = tc;
        this.suggestions = new ArrayList<>(suggestions);
        this.popupMode = popupMode;
        setupListeners();
    }

    public JavaTextCompleter(JTextComponent tc, boolean popupMode, String suggestions) {
        this(tc, popupMode, Arrays.asList(suggestions.split("\\s*,\\s*")));
    }

    private void setupListeners() {
        if (popupMode) {
            PopupSuggester popupSuggester = new PopupSuggester(textComponent, suggestions);
        } else {
            textComponent.addKeyListener(new AutoCompleteKeyAdapter());
        }
    }

    private class AutoCompleteKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_TAB) {
                textComponent.setCaretPosition(textComponent.getSelectionEnd());
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            handleAutoComplete(e);
        }

        private void handleAutoComplete(KeyEvent e) {
            if (isInvalidKey(e)) {
                return;
            }

            String word = getCurrentWord(textComponent);
            if (word.isEmpty()) {
                return;
            }

            findSuggestion(word).ifPresent(suggestion
                    -> insertSuggestion(word, suggestion)
            );
        }

        private boolean isInvalidKey(KeyEvent e) {
            return e.getKeyCode() == KeyEvent.VK_BACK_SPACE
                    || e.getKeyCode() == KeyEvent.VK_DELETE
                    || textComponent.getSelectionStart() != textComponent.getSelectionEnd();
        }

        private Optional<String> findSuggestion(String word) {
            return suggestions.stream()
                    .filter(s -> s.startsWith(word))
                    .findFirst();
        }

        private void insertSuggestion(String word, String suggestion) {
            if (suggestion.length() <= word.length()) {
                return;
            }

            String completion = suggestion.substring(word.length());
            int pos = textComponent.getCaretPosition();
            textComponent.replaceSelection(completion);
            textComponent.select(pos, pos + completion.length());
        }
    }

    private static class PopupSuggester {

        private final JWindow popup = new JWindow();
        private final JList<String> list = new JList<>();
        private final JTextComponent textComponent;
        private final List<String> suggestions;

        public PopupSuggester(JTextComponent tc, List<String> suggestions) {
            this.textComponent = tc;
            this.suggestions = suggestions;

            configurePopup();
            setupListeners();
        }

        private void configurePopup() {
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setBackground(textComponent.getBackground());
            list.setForeground(textComponent.getForeground());
            popup.add(new JScrollPane(list));
            popup.setSize(200, 120);
        }

        private void setupListeners() {
            textComponent.addKeyListener(new PopupKeyListener());
            textComponent.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    popup.setVisible(false);
                }
            });
        }

        private class PopupKeyListener extends KeyAdapter {

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN ->
                        moveSelection(1);
                    case KeyEvent.VK_UP ->
                        moveSelection(-1);
                    case KeyEvent.VK_ENTER, KeyEvent.VK_TAB -> {
                        selectSuggestion();
                        e.consume();
                    }
                    default ->
                        updateSuggestions();
                }
            }

            private void moveSelection(int dir) {
                int newIndex = Math.max(0, Math.min(list.getModel().getSize() - 1, list.getSelectedIndex() + dir));
                if (newIndex >= 0) {
                    list.setSelectedIndex(newIndex);
                    list.ensureIndexIsVisible(newIndex);
                }
            }

            private void selectSuggestion() {
                String selected = list.getSelectedValue();
                if (selected != null) {
                    String word = getCurrentWord(textComponent);
                    if (selected.length() > word.length()) {
                        String completion = selected.substring(word.length());
                        textComponent.replaceSelection(completion);
                    }
                    popup.setVisible(false);
                }
            }

            private void updateSuggestions() {
                String word = getCurrentWord(textComponent);

                if (word.isEmpty()) {
                    list.setListData(new String[0]);
                    popup.setVisible(false);
                    return;
                }

                List<String> matches = suggestions.stream()
                        .filter(s -> s.startsWith(word))
                        .toList();

                list.setListData(matches.toArray(new String[0]));

                if (!matches.isEmpty()) {
                    list.setSelectedIndex(0);
                    positionPopup();
                    popup.setVisible(true);
                } else {
                    popup.setVisible(false);
                }
            }

            private void positionPopup() {
                try {
                    int caretPos = textComponent.getCaretPosition();
                    if (caretPos > textComponent.getDocument().getLength()) {
                        return;
                    }

                    Rectangle rect = textComponent.modelToView(caretPos);
                    Point screenPos = new Point(rect.x, rect.y + rect.height);
                    SwingUtilities.convertPointToScreen(screenPos, textComponent);
                    popup.setLocation(screenPos);
                } catch (BadLocationException ignored) {
                }
            }
        }
    }

    private static String getCurrentWord(JTextComponent tc) {
        int pos = tc.getCaretPosition();
        String text = tc.getText();

        int start = pos;
        while (start > 0 && isValidChar(text.charAt(start - 1))) {
            start--;
        }

        int end = pos;
        while (end < text.length() && isValidChar(text.charAt(end))) {
            end++;
        }

        return text.substring(start, Math.min(end, text.length()));
    }

    private static boolean isValidChar(char c) {
        return Character.isLetterOrDigit(c) || c == '_';
    }
}
