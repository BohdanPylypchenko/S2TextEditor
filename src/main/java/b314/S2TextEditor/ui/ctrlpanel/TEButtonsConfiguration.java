package b314.S2TextEditor.ui.ctrlpanel;

import b314.S2TextEditor.action.FileActionsBounder;
import b314.S2TextEditor.action.SearchActionsBounder;
import b314.S2TextEditor.ui.utils.TEClasspathIconLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.io.IOException;

@Configuration
public class TEButtonsConfiguration {

   @Bean
   public JButton saveButton(JFileChooser fileChooser, JTextArea textArea,
                             TEClasspathIconLoader iconLoader,
                             FileActionsBounder fab) {
       var saveButton = initializeButtonIconOrText(iconLoader, "SaveFileIcon.png", "save");

       saveButton.setName("SaveButton");
       saveButton.addActionListener(e -> fab.saveFileActionBound(fileChooser, textArea));

       return saveButton;
   }

   @Bean
   public JButton saveAsButton(JFileChooser fileChooser, JTextArea textArea,
                               TEClasspathIconLoader iconLoader,
                               FileActionsBounder fab) {
       var saveAsButton = initializeButtonIconOrText(iconLoader, "SaveFileAsIcon.png", "save as");

       saveAsButton.setName("SaveAsButton");
       saveAsButton.addActionListener(e -> fab.saveFileAsActionBound(fileChooser, textArea));

       return saveAsButton;
   }

   @Bean
   public JButton openButton(JFileChooser fileChooser, JTextArea textArea,
                             TEClasspathIconLoader iconLoader,
                             FileActionsBounder fab) {
       var openButton = initializeButtonIconOrText(iconLoader, "OpenFileIcon.png", "open");

       openButton.setName("OpenButton");
       openButton.addActionListener(e -> fab.openFileActionBound(fileChooser, textArea));

       return openButton;
   }

   @Bean
   public JButton searchButton(JTextArea textArea, JTextField textField,
                               TEClasspathIconLoader iconLoader,
                               SearchActionsBounder sab) {
       var searchButton = initializeButtonIconOrText(iconLoader, "SearchInFileIcon.png", "search");

       searchButton.setName("StartSearchButton");
       searchButton.addActionListener(e -> sab.searchActionBound(textArea, textField));

       return searchButton;
   }

   @Bean
   public JButton previousMatchButton(JTextArea textArea,
                                      TEClasspathIconLoader iconLoader,
                                      SearchActionsBounder sab) {
       var previousMatchButton = initializeButtonIconOrText(iconLoader, "PreviousMatchIcon.png", "previous match");

       previousMatchButton.setName("PreviousMatchButton");
       previousMatchButton.addActionListener(e -> sab.previousMatchActionBound(textArea));

       return previousMatchButton;
   }

   @Bean
   public JButton nextMatchButton(JTextArea textArea,
                                  TEClasspathIconLoader iconLoader,
                                  SearchActionsBounder sab) {
       var nextMatchButton = initializeButtonIconOrText(iconLoader, "NextMatchIcon.png", "next match");

       nextMatchButton.setName("NextMatchButton");
       nextMatchButton.addActionListener(e -> sab.nextMatchActionBound(textArea));

       return nextMatchButton;
   }

   private JButton initializeButtonIconOrText(TEClasspathIconLoader iconLoader,
                                              String iconName, String text) {
       try {
           ImageIcon imageIcon = iconLoader.loadImageIconByNameFromClasspath(iconName);
           imageIcon.setImage(imageIcon.getImage().getScaledInstance(60, 60, 1));
           return new JButton(imageIcon);
       } catch (IOException e) {
           System.out.printf("Could not load icon for %s button", text);
           return new JButton(text);
       }
   }

}
