package b314.S2TextEditor.ui.menu;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

/**
 * Menu bar configuration class
 */
@Configuration
public class TEMenuBarConfiguration {

    /**
     * menu bar bean
     * @param fileMenu JMenu instance bean, contains file-related actions
     * @param searchMenu JMenu instance bean, contains search-related actions
     * @return JMenuBar instance bean
     */
    @Bean
    public JMenuBar menuBar(@Qualifier("fileMenu") JMenu fileMenu,
                            @Qualifier("searchMenu") JMenu searchMenu) {
        // Creating new menu bar
        var menuBar = new JMenuBar();

        // Adding menus
        menuBar.add(fileMenu);
        menuBar.add(searchMenu);

        // Returning
        return menuBar;
    }

}
