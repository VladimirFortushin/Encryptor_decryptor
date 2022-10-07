package files;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;



public class FileCreator {
    public static Path createNewFile(String path) throws IOException {
        Path newFilePath = Path.of(path);
        return Files.createFile(newFilePath);
    }

}
