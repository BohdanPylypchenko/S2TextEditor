package b314.S2TextEditor.ui.filechooser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

/**
 * File chooser configuration class
 */
@Configuration
public class TEFileChooserConfiguration {

    /**
     * file chooser bean
     * @return JFileChooser instance bean
     */
    @Bean
    public JFileChooser fileChooser() {
        // Creating
        var jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setName("FileChooser");

        // Returning
        return jfc;
    }

}
