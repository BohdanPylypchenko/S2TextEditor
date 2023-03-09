package b314.S2TextEditor.action;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
@Getter
public class FileActions {

    private File file;

    void saveFileAs(File destination, String content) {
        this.file = destination;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            writer.write(content);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    void saveFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    String openFile(File file) {
        // Updating file
        this.file = file;

        // Reading
        try (FileInputStream fis = new FileInputStream(this.file)) {
            return new String(fis.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            return "";
        }
    }

}
