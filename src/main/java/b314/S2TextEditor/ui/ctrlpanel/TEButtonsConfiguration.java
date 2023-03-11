package b314.S2TextEditor.ui.ctrlpanel;

import b314.S2TextEditor.ui.utils.SwingFileActionsAdapter;
import b314.S2TextEditor.ui.utils.SwingSearchActionsAdapter;
import b314.S2TextEditor.ui.utils.TEClasspathIconLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.io.IOException;

/**
 * Control panel buttons configuration
 */
@Configuration
public class TEButtonsConfiguration {

    /**
     * save button bean
     * @param fileChooser JFileChooser bean to use for save location choice (if saving 1st time)
     * @param textArea JTextArea bean to take content from
     * @param iconLoader bean to add icon on button
     * @param sfaa adapter bean to bound button to action
     * @return save button bean
     */
    @Bean
    public JButton saveButton(JFileChooser fileChooser, JTextArea textArea,
                              TEClasspathIconLoader iconLoader,
                              SwingFileActionsAdapter sfaa) {
        // Creating button with base config
        var saveButton = initializeButtonIconOrText(iconLoader, "SaveFileIcon.png", "save");

        // Name and action
        saveButton.setName("SaveButton");
        saveButton.addActionListener(e -> sfaa.saveFileActionBound(fileChooser, textArea));

        // Returning
        return saveButton;
    }

    /**
     * save as button bean
     * @param fileChooser JFileChooser bean to use for save as location choice
     * @param textArea JTextArea bean to take content from
     * @param iconLoader bean to add icon on button
     * @param sfaa adapter bean to bound button to action
     * @return save as button bean
     */
    @Bean
    public JButton saveAsButton(JFileChooser fileChooser, JTextArea textArea,
                                TEClasspathIconLoader iconLoader,
                                SwingFileActionsAdapter sfaa) {
        // Creating button with base config
        var saveAsButton = initializeButtonIconOrText(iconLoader, "SaveFileAsIcon.png", "save as");

        // Name and action
        saveAsButton.setName("SaveAsButton");
        saveAsButton.addActionListener(e -> sfaa.saveFileAsActionBound(fileChooser, textArea));

        // Returning
        return saveAsButton;
    }

    /**
     * open button bean
     * @param fileChooser JFileChooser bean to use for open location choice
     * @param textArea JTextArea bean to display content in
     * @param iconLoader bean to add icon on button
     * @param sfaa adapter bean to bound button to action
     * @return open button bean
     */
    @Bean
    public JButton openButton(JFileChooser fileChooser, JTextArea textArea,
                              TEClasspathIconLoader iconLoader,
                              SwingFileActionsAdapter sfaa) {
        // Creating button with base config
        var openButton = initializeButtonIconOrText(iconLoader, "OpenFileIcon.png", "open");

        // Name and action
        openButton.setName("OpenButton");
        openButton.addActionListener(e -> sfaa.openFileActionBound(fileChooser, textArea));

        // Returning
        return openButton;
    }

    /**
     * search button bean
     * @param textArea JTextArea bean to take content from
     * @param textField JTextField bean to take target from
     * @param iconLoader bean to add icon on button
     * @param ssaa adapter bean to bound button to action
     * @return search button bean
     */
    @Bean
    public JButton searchButton(JTextArea textArea, JTextField textField,
                                TEClasspathIconLoader iconLoader,
                                SwingSearchActionsAdapter ssaa) {
        // Creating button with base config
        var searchButton = initializeButtonIconOrText(iconLoader, "SearchInFileIcon.png", "search");

        // Name and action
        searchButton.setName("StartSearchButton");
        searchButton.addActionListener(e -> ssaa.searchActionBound(textArea, textField));

        // Returning
        return searchButton;
    }

    /**
     * previous match button bean
     * @param textArea JTextArea bean to highlight match in
     * @param iconLoader bean to add icon on button
     * @param ssaa adapter bean to bound button to action
     * @return previous match button bean
     */
    @Bean
    public JButton previousMatchButton(JTextArea textArea,
                                       TEClasspathIconLoader iconLoader,
                                       SwingSearchActionsAdapter ssaa) {
        // Creating button with base config
        var previousMatchButton = initializeButtonIconOrText(iconLoader, "PreviousMatchIcon.png", "previous match");

        // Name and action
        previousMatchButton.setName("PreviousMatchButton");
        previousMatchButton.addActionListener(e -> ssaa.previousMatchActionBound(textArea));

        // Returning
        return previousMatchButton;
    }

    /**
     * next match button bean
     * @param textArea JTextArea bean to highlight match in
     * @param iconLoader bean to add icon on button
     * @param ssaa adapter bean to bound button to action
     * @return next match button bean
     */
    @Bean
    public JButton nextMatchButton(JTextArea textArea,
                                   TEClasspathIconLoader iconLoader,
                                   SwingSearchActionsAdapter ssaa) {
        // Create button with base config
        var nextMatchButton = initializeButtonIconOrText(iconLoader, "NextMatchIcon.png", "next match");

        // Name and action
        nextMatchButton.setName("NextMatchButton");
        nextMatchButton.addActionListener(e -> ssaa.nextMatchActionBound(textArea));

        // Returning
        return nextMatchButton;
    }

    /**
     * Creates JButton instance with icon or text (if icon could not be loaded)
     * @param iconLoader utility to load icon from jar file
     * @param iconName String to identify icon by
     * @param text String to use as button caption if could not load the icon
     */
    private JButton initializeButtonIconOrText(TEClasspathIconLoader iconLoader,
                                               String iconName, String text) {
        try {
            // Try create button with icon
            ImageIcon imageIcon = iconLoader.loadImageIconByNameFromClasspath(iconName);
            imageIcon.setImage(imageIcon.getImage().getScaledInstance(60, 60, 1));
            return new JButton(imageIcon);
        } catch (IOException e) {
            // Create icon with text caption
            System.out.printf("Could not load icon for %s button", text);
            return new JButton(text);
        }
    }

}
