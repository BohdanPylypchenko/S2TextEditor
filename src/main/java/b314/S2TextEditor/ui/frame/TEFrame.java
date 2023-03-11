package b314.S2TextEditor.ui.frame;

import javax.swing.*;

/**
 * Frame of text editor
 * Couples all ui together
 */
public class TEFrame extends JFrame {

    /**
     * Sets some initial properties
     * to make frame pretty and visible
     */
    public void run() {
        // Make location absolute
        setLocationRelativeTo(null);

        // Exit app when frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting visual properties
        setSize(820, 300);
        setTitle("Text Editor");

        // Making frame visible
        setVisible(true);
    }

}
