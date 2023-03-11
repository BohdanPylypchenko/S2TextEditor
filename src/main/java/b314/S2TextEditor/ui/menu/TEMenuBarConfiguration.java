package b314.S2TextEditor.ui.menu;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
public class TEMenuBarConfiguration {

    @Bean
    public JMenuBar menuBar(@Qualifier("fileMenu") JMenu fileMenu,
                            @Qualifier("searchMenu") JMenu searchMenu) {
        var menuBar = new JMenuBar();

        menuBar.add(fileMenu);
        menuBar.add(searchMenu);

        return menuBar;
    }

}
