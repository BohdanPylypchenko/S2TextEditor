package b314.S2TextEditor.ui.spane;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
public class TESpaneConfiguration {

    @Bean
    public JScrollPane spane(JTextArea textArea) {
        var spane = new JScrollPane(textArea);
        spane.setName("ScrollPane");
        spane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        spane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        return spane;
    }

}
