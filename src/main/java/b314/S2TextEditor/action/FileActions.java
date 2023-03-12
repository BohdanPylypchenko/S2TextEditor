package b314.S2TextEditor.action;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Implements file-related actions, like
 * save file, open file, save as etc.
 */
@Service
@Getter
public class FileActions {

    // Current file
    private File file;

    /**
     * Sets given file as current, saves given content in given file
     * @param destination file to save in
     * @param content content to save
     */
    public void saveFileAs(File destination, String content) {
        // Setting given as current
        file = destination;

        // Writing
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Saves content in current file
     * @param content content to save
     */
    public void saveFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Sets given file as current, reads file content
     * @param file file to set as current and read from
     * @return content of file
     * @throws IOException if can't read from file
     */
    public String openFile(File file) throws IOException {
        // Updating file
        this.file = file;

        // Reading
        return new String((new FileInputStream(this.file)).readAllBytes(),
                          StandardCharsets.UTF_8);
    }

}
