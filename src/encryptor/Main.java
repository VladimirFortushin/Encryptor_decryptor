package encryptor;



import files.FileCreator;

import java.io.IOException;
import java.nio.file.Path;

public class Main {


    public static void main(String[] args) throws IOException {
        Language latin = new Latin();
        Language cyrillic = new Cyrillic();


        String operation = args[0];
        String filePath = args[1];
        int key = Integer.parseInt(args[2]);

        Reader.setFilePath(filePath);

        if(operation.equals("encrypt")){
            String textToEncrypt = Reader.readTextFromFile();
            String encryptedText = latin.encode(textToEncrypt, key, operation);
            Path encryptedFilePath = FileCreator.createNewFile(Path.of(filePath.replace(".txt", "(encrypted).txt")) + "");
            Writer.writeNewTextToNewFile(encryptedText, encryptedFilePath);

        }else if(operation.equals("decrypt")){
            String textToDecrypt = Reader.readTextFromFile();
            String decryptedText = latin.encode(textToDecrypt, key, operation);
            Path decryptedFilePath = FileCreator.createNewFile(Path.of(filePath.replace("encrypted", "decrypted"))+"");
            Writer.writeNewTextToNewFile(decryptedText, decryptedFilePath);

        }else if(operation.equals("bruteForce")){

        }






    }

}
