package b314.S2TextEditor.ui.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

@Configuration
public class TEUtilsConfiguration {

    @Bean
    public JFileChooser fileChooser() {
        var jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setName("FileChooser");

        return jfc;
    }

    @Bean
    public TEClasspathIconLoader iconLoader(ResourceLoader resourceLoader) {
        return new TEClasspathIconLoader(resourceLoader);
    }

}
