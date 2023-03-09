package b314.S2TextEditor.ui.textarea;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
public class TETextAreaConfiguration {

    @Bean
    public JTextArea textArea() {
        var textArea = new JTextArea();
        textArea.setName("TextArea");

        return textArea;
    }

}
