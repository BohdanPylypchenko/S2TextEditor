package b314.S2TextEditor.action;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@AllArgsConstructor
public class FileActionsBounder {

    private final FileActions fileActions;

    public void saveFileActionBound(JFileChooser fileChooser,
                                    JTextArea textArea) {
        if (fileActions.getFile() == null) {
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                fileActions.saveFileAs(fileChooser.getSelectedFile(), textArea.getText());
            }
        } else {
            fileActions.saveFile(textArea.getText());
        }
    }

    public void saveFileAsActionBound(JFileChooser fileChooser,
                                      JTextArea textArea) {
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            fileActions.saveFileAs(fileChooser.getSelectedFile(), textArea.getText());
        }
    }

    public void openFileActionBound(JFileChooser fileChooser,
                                    JTextArea textArea) {
        // Getting file to open
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            textArea.setText(fileActions.openFile(fileChooser.getSelectedFile()));
        }
    }

}
