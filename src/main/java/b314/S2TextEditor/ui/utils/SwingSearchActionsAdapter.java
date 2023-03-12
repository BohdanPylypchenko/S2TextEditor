package b314.S2TextEditor.ui.utils;

import b314.S2TextEditor.action.SearchActions;
import b314.S2TextEditor.model.SearchResult;
import lombok.AllArgsConstructor;

import javax.swing.*;

/**
 * Adapter to bound Swing ui components with search actions
 */
@AllArgsConstructor
public class SwingSearchActionsAdapter {

    // SearchActions instance to take actions from
    private final SearchActions searchActions;

    /**
     * Switches regex flag
     * true -> false
     * false -> true
     */
    public void switchUseRegexFlagActionBound() {
        searchActions.switchRegexFlag();
    }

    /**
     * Bounds search action to ui components
     * @param content text area to search in
     * @param target target to search for
     */
    public void searchActionBound(JTextArea content, JTextField target) {
        SearchResult current;
        try {
            current = searchActions.search(content.getText(),
                                           target.getText());
            showMatchInTextArea(content, current);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No match found");
        }
    }

    /**
     * Bounds previous match action to ui component
     * @param content text area to highlight previous match in
     */
    public void previousMatchActionBound(JTextArea content) {
        SearchResult current;
        try {
            current = searchActions.previousMatch();
            showMatchInTextArea(content, current);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No match found");
        }
    }

    /**
     * Bounds next match action to ui component
     * @param content text area to highlight next match in
     */
    public void nextMatchActionBound(JTextArea content) {
        SearchResult current;
        try {
            current = searchActions.nextMatch();
            showMatchInTextArea(content, current);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No match found");
        }
    }

    /**
     * Highlights search result in text area
     * @param content text area to highlight in
     * @param current search result to highlight
     */
    private void showMatchInTextArea(JTextArea content, SearchResult current) {
        content.setCaretPosition(current.getPos() + current.getResult().length());
        content.select(current.getPos(), current.getPos() + current.getResult().length());
        content.grabFocus();
    }

}
