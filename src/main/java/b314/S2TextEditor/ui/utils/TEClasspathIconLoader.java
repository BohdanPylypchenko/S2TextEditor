package b314.S2TextEditor.ui.utils;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ResourceLoader;

import javax.swing.*;
import java.io.IOException;

/**
 * Util class to load icons from jar
 */
@AllArgsConstructor
public class TEClasspathIconLoader {

    // Spring's resource loader instance
    private final ResourceLoader resourceLoader;

    /**
     * Loads image icon from classpath (jar)
     * @param name icon name
     * @return ImageIcon instance
     * @throws IOException if can't load
     */
    public ImageIcon loadImageIconByNameFromClasspath(String name) throws IOException {
        return new ImageIcon(resourceLoader.getResource("classpath:assets/" + name)
                                           .getInputStream()
                                           .readAllBytes());
    }

}
