package b314.S2TextEditor.ui.utils;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ResourceLoader;

import javax.swing.*;
import java.io.IOException;

@AllArgsConstructor
public class TEClasspathIconLoader {

    private final ResourceLoader resourceLoader;

    public ImageIcon loadImageIconByNameFromClasspath(String name) throws IOException {
        return new ImageIcon(resourceLoader.getResource("classpath:assets/" + name)
                                           .getInputStream()
                                           .readAllBytes());
    }

}
