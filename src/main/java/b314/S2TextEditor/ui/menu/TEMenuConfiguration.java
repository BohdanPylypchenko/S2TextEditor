package b314.S2TextEditor.ui.menu;

import b314.S2TextEditor.ui.utils.SwingFileActionsAdapter;
import b314.S2TextEditor.ui.utils.SwingSearchActionsAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

/**
 * File menu and search menu configuration class
 */
@Configuration
public class TEMenuConfiguration {

    /**
     * file menu bean
     * @param textArea JTextArea bean to use in menu items - actions bounds
     * @param fileChooser JFileChooser bean to use in menu items - actions bounds
     * @param sfaa bean to bound ui components to actions
     * @return JMenu instance bean
     */
    @Bean
    public JMenu fileMenu(JTextArea textArea, JFileChooser fileChooser,
                          SwingFileActionsAdapter sfaa) {
        // Creating menu and setting name
        var fileMenu = new JMenu("File");
        fileMenu.setName("MenuFile");

        // Open menu item
        JMenuItem loadMenuItem = new JMenuItem();
        loadMenuItem.setName("MenuOpen");
        loadMenuItem.setText("Open");
        loadMenuItem.addActionListener(e -> sfaa.openFileActionBound(fileChooser, textArea));
        fileMenu.add(loadMenuItem);

        // Save menu item
        JMenuItem saveMenuItem = new JMenuItem();
        saveMenuItem.setName("MenuSave");
        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(e -> sfaa.saveFileActionBound(fileChooser, textArea));
        fileMenu.add(saveMenuItem);

        // Save as menu item
        JMenuItem saveAsMenuItem = new JMenuItem();
        saveAsMenuItem.setName("MenuSaveAs");
        saveAsMenuItem.setText("Save as");
        saveAsMenuItem.addActionListener(e -> sfaa.saveFileAsActionBound(fileChooser, textArea));
        fileMenu.add(saveAsMenuItem);

        // Separate file actions and exit
        fileMenu.addSeparator();

        // Exit menu item
        JMenuItem exitMenuItem = new JMenuItem();
        exitMenuItem.setName("MenuExit");
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(e -> SwingUtilities.getWindowAncestor(textArea).dispose());
        fileMenu.add(exitMenuItem);

        // Returning
        return fileMenu;
    }

    /**
     * search menu bean
     * @param textArea JTextArea bean to use in menu items - actions bounds
     * @param textField JTextField bean to use in menu items - actions bounds
     * @param useRegexCheckBox JCheckBox bean to use in menu items - actions bounds
     * @param ssaa bean to bound ui components to actions
     * @return JMenu instance bean
     */
    @Bean
    public JMenu searchMenu(JTextArea textArea,
                            JTextField textField,
                            JCheckBox useRegexCheckBox,
                            SwingSearchActionsAdapter ssaa) {
        // Creating menu
        var searchMenu = new JMenu("Search");
        searchMenu.setName("MenuSearch");

        // Search item
        JMenuItem startSearchItem = new JMenuItem();
        startSearchItem.setName("MenuStartSearch");
        startSearchItem.setText("Search");
        startSearchItem.addActionListener(e -> ssaa.searchActionBound(textArea, textField));
        searchMenu.add(startSearchItem);

        // Previous match item
        JMenuItem previousMatchItem = new JMenuItem();
        previousMatchItem.setName("MenuPreviousMatch");
        previousMatchItem.setText("Previous match");
        previousMatchItem.addActionListener(e -> ssaa.previousMatchActionBound(textArea));
        searchMenu.add(previousMatchItem);

        // Next match item
        JMenuItem nextMatchItem = new JMenuItem();
        nextMatchItem.setName("MenuNextMatch");
        nextMatchItem.setText("Next match");
        nextMatchItem.addActionListener(e -> ssaa.nextMatchActionBound(textArea));
        searchMenu.add(nextMatchItem);

        // Use regex item
        JMenuItem useRegularExpressionItem = new JMenuItem();
        useRegularExpressionItem.setName("MenuUseRegExp");
        useRegularExpressionItem.setText("Use regular expression");
        useRegularExpressionItem.addActionListener(e -> useRegexCheckBox.doClick());
        searchMenu.add(useRegularExpressionItem);

        // Returning
        return searchMenu;
    }

}
