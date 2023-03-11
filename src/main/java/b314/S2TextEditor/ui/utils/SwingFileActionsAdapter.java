package b314.S2TextEditor.ui.utils;

import b314.S2TextEditor.action.FileActions;
import lombok.AllArgsConstructor;

import javax.swing.*;
import java.io.IOException;

/**
 * Adapter to bound Swing UI components with file actions
 */
@AllArgsConstructor
public class SwingFileActionsAdapter {

    // FileActions instance to take actions from
    private final FileActions fileActions;

    /**
     * Bounds save action to ui components
     * @param fileChooser file chooser to use when choosing save location (if needed)
     * @param textArea text area to take content from
     */
    public void saveFileActionBound(JFileChooser fileChooser,
                                    JTextArea textArea) {
        if (fileActions.getFile() == null) {
            // No current file, need to choose
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                // Running saveAs action
                fileActions.saveFileAs(fileChooser.getSelectedFile(), textArea.getText());
            }
        } else {
            // Saving to current
            fileActions.saveFile(textArea.getText());
        }
    }

    /**
     * Bounds save as action to ui components
     * @param fileChooser file chooser to use when choosing save location
     * @param textArea text area to take content from
     */
    public void saveFileAsActionBound(JFileChooser fileChooser,
                                      JTextArea textArea) {
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            fileActions.saveFileAs(fileChooser.getSelectedFile(), textArea.getText());
        }
    }

    /**
     * Bounds open action to ui components
     * @param fileChooser file chooser to choose file to open
     * @param textArea text area to display content with
     */
    public void openFileActionBound(JFileChooser fileChooser,
                                    JTextArea textArea) {
        // Getting file to open
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                textArea.setText(fileActions.openFile(fileChooser.getSelectedFile()));
            } catch (IOException e) {
                textArea.setText("Oops! Something went wrong, can't open file");
            }
        }
    }

}
