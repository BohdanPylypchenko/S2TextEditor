package b314.S2TextEditor.ui.textarea;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

/**
 * Text area configuration class
 */
@Configuration
public class TETextAreaConfiguration {

    /**
     * text area bean
     * only 1 text area is present in text editor
     * @return JTextArea bean
     */
    @Bean
    public JTextArea textArea() {
        // Creating
        var textArea = new JTextArea();
        textArea.setName("TextArea");

        // Returning
        return textArea;
    }

}
