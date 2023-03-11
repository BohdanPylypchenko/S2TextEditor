package b314.S2TextEditor.action;

import b314.S2TextEditor.model.SearchResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@AllArgsConstructor
public class SearchActionsBounder {

    private final SearchActions searchActions;

    public void switchUseRegexFlagActionBound(JCheckBox useRegexCheckBox) {
        useRegexCheckBox.setSelected(searchActions.switchRegexFlag());
    }

    public void searchActionBound(JTextArea content, JTextField target) {
        SearchResult current = searchActions.search(content.getText(),
                                                    target.getText());
        showMatchInTextArea(content, current);
    }

    public void previousMatchActionBound(JTextArea content) {
        SearchResult current = searchActions.previousMatch();
        showMatchInTextArea(content, current);
    }

    public void nextMatchActionBound(JTextArea content) {
        SearchResult current = searchActions.nextMatch();
        showMatchInTextArea(content, current);
    }

    private void showMatchInTextArea(JTextArea content, SearchResult current) {
        if (current == null) {
            return;
        }
        content.setCaretPosition(current.getPos() + current.getResult().length());
        content.select(current.getPos(), current.getPos() + current.getResult().length());
        content.grabFocus();
    }

}
