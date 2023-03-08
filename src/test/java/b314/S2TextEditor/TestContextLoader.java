package b314.S2TextEditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootContextLoader;

/**
 * Custom implementation of ContextLoader to use in tests.
 * Main purpose is to set headless to false for tests to be able to test with Swing library.
 */
class TestContextLoader extends SpringBootContextLoader {

    /**
     * Custom implementation of getSpringApplication
     * @return Spring application with headless = false
     */
    @Override
    protected SpringApplication getSpringApplication() {
        // Getting template from super
        SpringApplication application = super.getSpringApplication();

        // Setting headless to false
        application.setHeadless(false);

        // Returning
        return application;
    }

}
