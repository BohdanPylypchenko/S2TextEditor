package b314.S2TextEditor.ui.spane;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

/**
 * Scroll pane configuration class
 */
@Configuration
public class TEScrollPaneConfiguration {

    /**
     * scroll pane bean
     * @param textArea JTextArea bean to bound pane to
     * @return JScrollPane instance bean
     */
    @Bean
    public JScrollPane spane(JTextArea textArea) {
        // Creating scroll pane
        var spane = new JScrollPane(textArea);

        // Configuring
        spane.setName("ScrollPane");
        spane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        spane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Returning
        return spane;
    }

}
