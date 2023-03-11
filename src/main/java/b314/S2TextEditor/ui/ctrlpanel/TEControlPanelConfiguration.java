package b314.S2TextEditor.ui.ctrlpanel;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

@Configuration
public class TEControlPanelConfiguration {

    @Bean
    public JPanel controlPanel(@Qualifier("saveButton") JButton saveButton,
                               @Qualifier("saveAsButton") JButton saveAsButton,
                               @Qualifier("openButton") JButton openButton,
                               @Qualifier("searchButton") JButton searchButton,
                               @Qualifier("previousMatchButton") JButton previousMatchButton,
                               @Qualifier("nextMatchButton") JButton nextMatchButton,
                               @Qualifier("useRegexCheckBox") JCheckBox useRegexCheckBox,
                               @Qualifier("searchRequestField") JTextField searchRequestField) {
        var ctrlPanel = new JPanel();
        ctrlPanel.setBackground(Color.lightGray);

        ctrlPanel.add(openButton);
        ctrlPanel.add(saveButton);
        ctrlPanel.add(saveAsButton);
        ctrlPanel.add(searchRequestField);
        ctrlPanel.add(useRegexCheckBox);
        ctrlPanel.add(searchButton);
        ctrlPanel.add(previousMatchButton);
        ctrlPanel.add(nextMatchButton);

        return ctrlPanel;
    }

}
