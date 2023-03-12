package b314.S2TextEditor.ui.ctrlpanel;

import b314.S2TextEditor.ui.utils.SwingSearchActionsAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

/**
 * Search functionality components configuration class
 */
@Configuration
public class TESearchConfiguration {

    /**
     * search request field bean
     * @return JTextField bean to get search target from
     */
    @Bean
    public JTextField searchRequestField() {
        // Creating field
        var searchRequest = new JTextField();

        // Configuring
        searchRequest.setName("SearchField");
        Dimension dim = new Dimension(100, 30);
        searchRequest.setMinimumSize(dim);
        searchRequest.setPreferredSize(dim);
        searchRequest.setMaximumSize(dim);

        // Returning
        return searchRequest;
    }

    /**
     * use regex check box bean
     * @param ssaa swing search action adapter to bound check box with action
     * @return JCheckBox bean to switch use regex flag
     */
    @Bean
    public JCheckBox useRegexCheckBox(SwingSearchActionsAdapter ssaa) {
        // Creating
        var useRegexCheckBox = new JCheckBox("Use regex");

        // Configuring
        useRegexCheckBox.setName("UseRegExCheckbox");
        useRegexCheckBox.addItemListener(e -> ssaa.switchUseRegexFlagActionBound());

        // Returning
        return useRegexCheckBox;
    }

}
