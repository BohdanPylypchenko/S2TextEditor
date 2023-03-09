package b314.S2TextEditor.ui.ctrlpanel;

import b314.S2TextEditor.action.SearchActionsBounder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

@Configuration
public class TESearchConfiguration {

    @Bean
    public JTextField searchRequestField() {
        var searchRequest = new JTextField();
        searchRequest.setName("SearchField");
        Dimension dim = new Dimension(100, 30);
        searchRequest.setMinimumSize(dim);
        searchRequest.setPreferredSize(dim);
        searchRequest.setMaximumSize(dim);

        return searchRequest;
    }

    @Bean
    public JCheckBox useRegexCheckBox(SearchActionsBounder sab) {
        var useRegexCheckBox = new JCheckBox("Use regex");
        useRegexCheckBox.setName("UseRegExCheckbox");
        useRegexCheckBox.addItemListener(e -> sab.switchUseRegexFlagActionBound(useRegexCheckBox));

        return useRegexCheckBox;
    }

}
