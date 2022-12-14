package encryptor;

import exceptions.FilePathException;
import exceptions.TextException;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;




public class Reader {

    private static Path filePath;

    public static void setFilePath(String path) throws FilePathException {
        if(!Files.exists(Path.of(path))){
            throw new FilePathException("File " + Path.of(path).getFileName() + " doesn't exist");
        }else{
            Reader.filePath = Path.of(path);
        }
    }


    public static String readTextFromFile() throws Exception {

        String s = Files.readString(filePath, StandardCharsets.UTF_8);

        if(s.isBlank()){throw new TextException("The text is blank");}

        return s;
    }









}
