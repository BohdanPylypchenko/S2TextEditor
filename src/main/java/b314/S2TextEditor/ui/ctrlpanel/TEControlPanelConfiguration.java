package b314.S2TextEditor.ui.ctrlpanel;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

/**
 * Control panel configuration class
 */
@Configuration
public class TEControlPanelConfiguration {

    /**
     * control panel bean
     * @param saveButton save button bean
     * @param saveAsButton save as button bean
     * @param openButton open button bean
     * @param searchButton search button bean
     * @param previousMatchButton previous match button bean
     * @param nextMatchButton next match button bean
     * @param useRegexCheckBox use regex check box bean
     * @param searchRequestField search request field bean
     * @return control panel bean
     */
    @Bean
    public JPanel controlPanel(@Qualifier("saveButton") JButton saveButton,
                               @Qualifier("saveAsButton") JButton saveAsButton,
                               @Qualifier("openButton") JButton openButton,
                               @Qualifier("searchButton") JButton searchButton,
                               @Qualifier("previousMatchButton") JButton previousMatchButton,
                               @Qualifier("nextMatchButton") JButton nextMatchButton,
                               @Qualifier("useRegexCheckBox") JCheckBox useRegexCheckBox,
                               @Qualifier("searchRequestField") JTextField searchRequestField) {
        // Creating panel
        var ctrlPanel = new JPanel();

        // Background
        ctrlPanel.setBackground(Color.lightGray);

        // Adding components
        ctrlPanel.add(openButton);
        ctrlPanel.add(saveButton);
        ctrlPanel.add(saveAsButton);
        ctrlPanel.add(searchRequestField);
        ctrlPanel.add(useRegexCheckBox);
        ctrlPanel.add(searchButton);
        ctrlPanel.add(previousMatchButton);
        ctrlPanel.add(nextMatchButton);

        // Returning
        return ctrlPanel;
    }

}
