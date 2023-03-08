package b314.S2TextEditor.app;

import b314.S2TextEditor.ui.TextEditorFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Acts as an entry point to TextEditor functionality
 */
@Component
public class TextEditorRunner implements ApplicationRunner {

    // Editor's frame
    private final TextEditorFrame mainFrame;

    @Autowired
    public TextEditorRunner(TextEditorFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * ApplicationRunner run method implementation
     * @param args incoming application arguments
     */
    @Override
    public void run(ApplicationArguments args) {
        mainFrame.run();
    }

}
