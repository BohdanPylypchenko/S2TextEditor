package b314.S2TextEditor.app;

import b314.S2TextEditor.ui.frame.TEFrame;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Text editor frame entry point configuration
 */
@Configuration
public class TERunnerConfiguration {

    /**
     * ApplicationRunner child bean
     * @param teFrame TEFrame bean to use as editor's frame
     * @return ApplicationRunner child instance to run editor frame from
     */
    @Bean
    public ApplicationRunner teRunner(TEFrame teFrame) {
        /*
         * Anonymous child of ApplicationRunner
         */
        return new ApplicationRunner() {
            /**
             * Text editor frame entry point method
             * @param args incoming application arguments
             */
            @Override
            public void run(ApplicationArguments args) {
                teFrame.run();
            }
        };
    }

}
