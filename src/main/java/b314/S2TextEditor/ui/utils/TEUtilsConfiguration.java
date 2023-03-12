package b314.S2TextEditor.ui.utils;

import b314.S2TextEditor.action.FileActions;
import b314.S2TextEditor.action.SearchActions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

/**
 * Utils configuration class
 */
@Configuration
public class TEUtilsConfiguration {

    /**
     * icon loader bean
     * @param resourceLoader Spring's ResourceLoader bean to use in icon loader
     * @return TEClasspathIconLoader bean
     */
    @Bean
    public TEClasspathIconLoader iconLoader(ResourceLoader resourceLoader) {
        return new TEClasspathIconLoader(resourceLoader);
    }

    /**
     * swing file actions adapter bean
     * @param fileActions file actions bean to take actions from
     * @return SwingFileActionsAdapter bean
     */
    @Bean
    public SwingFileActionsAdapter fileActionsBounder(FileActions fileActions) {
        return new SwingFileActionsAdapter(fileActions);
    }

    /**
     * swing search actions adapter bean
     * @param searchActions search actions bean to take actions from
     * @return SwingSearchActionsAdapter bean
     */
    @Bean
    public SwingSearchActionsAdapter searchActionsBounder(SearchActions searchActions) {
        return new SwingSearchActionsAdapter(searchActions);
    }

}
