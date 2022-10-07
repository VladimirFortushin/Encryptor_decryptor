package encryptor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class Writer {
    public static void writeNewTextToNewFile(String text, Path fileName) throws IOException {
        byte[] data = text.getBytes();
        Files.write(fileName, text.getBytes(StandardCharsets.UTF_8));
    }
}
