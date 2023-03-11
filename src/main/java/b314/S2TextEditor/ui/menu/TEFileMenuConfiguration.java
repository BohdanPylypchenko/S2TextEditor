package b314.S2TextEditor.ui.menu;

import b314.S2TextEditor.action.FileActionsBounder;
import b314.S2TextEditor.action.SearchActionsBounder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
public class TEFileMenuConfiguration {

    @Bean
    public JMenu fileMenu(JTextArea textArea, JFileChooser fileChooser,
                          FileActionsBounder fab) {
        var fileMenu = new JMenu("File");
        fileMenu.setName("MenuFile");

        JMenuItem loadMenuItem = new JMenuItem();
        loadMenuItem.setName("MenuOpen");
        loadMenuItem.setText("Open");
        loadMenuItem.addActionListener(e -> fab.openFileActionBound(fileChooser,
                                                                    textArea));
        fileMenu.add(loadMenuItem);

        JMenuItem saveMenuItem = new JMenuItem();
        saveMenuItem.setName("MenuSave");
        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(e -> fab.saveFileActionBound(fileChooser, textArea));
        fileMenu.add(saveMenuItem);

        JMenuItem saveAsMenuItem = new JMenuItem();
        saveAsMenuItem.setName("MenuSaveAs");
        saveAsMenuItem.setText("Save as");
        saveAsMenuItem.addActionListener(e -> fab.saveFileAsActionBound(fileChooser, textArea));
        fileMenu.add(saveAsMenuItem);

        fileMenu.addSeparator();

        JMenuItem exitMenuItem = new JMenuItem();
        exitMenuItem.setName("MenuExit");
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(e -> SwingUtilities.getWindowAncestor(textArea).dispose());
        fileMenu.add(exitMenuItem);

        return fileMenu;
    }

    @Bean
    public JMenu searchMenu(JTextArea textArea,
                            JTextField textField,
                            JCheckBox useRegexCheckBox,
                            SearchActionsBounder sab) {
        var searchMenu = new JMenu("Search");
        searchMenu.setName("MenuSearch");

        JMenuItem startSearchItem = new JMenuItem();
        startSearchItem.setName("MenuStartSearch");
        startSearchItem.setText("Search");
        startSearchItem.addActionListener(e -> sab.searchActionBound(textArea, textField));
        searchMenu.add(startSearchItem);

        JMenuItem previousMatchItem = new JMenuItem();
        previousMatchItem.setName("MenuPreviousMatch");
        previousMatchItem.setText("Previous match");
        previousMatchItem.addActionListener(e -> sab.previousMatchActionBound(textArea));
        searchMenu.add(previousMatchItem);

        JMenuItem nextMatchItem = new JMenuItem();
        nextMatchItem.setName("MenuNextMatch");
        nextMatchItem.setText("Next match");
        nextMatchItem.addActionListener(e -> sab.nextMatchActionBound(textArea));
        searchMenu.add(nextMatchItem);

        JMenuItem useRegularExpressionItem = new JMenuItem();
        useRegularExpressionItem.setName("MenuUseRegExp");
        useRegularExpressionItem.setText("Use regular expression");
        useRegularExpressionItem.addActionListener(e -> sab.switchUseRegexFlagActionBound(useRegexCheckBox));
        searchMenu.add(useRegularExpressionItem);

        return searchMenu;
    }

}
