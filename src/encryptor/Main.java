package encryptor;



import exceptions.ConfigurationEmptyException;
import files.FileCreator;
import language.Eng;
import language.Language;
import language.Rus;


import java.nio.file.Path;

public class Main {

    static String operation;
    static String filePath;
    static String filePathInstance;
    static Integer key;


    public static void main(String[] args) throws Exception {
        if(args.length == 0){throw new ConfigurationEmptyException("args[...] is empty");}

        Language eng = new Eng();
        Language rus = new Rus();

        operation = args[0];
        filePath = args[1];

        if(operation.equals("bruteForce")){filePathInstance = args[2];}else {key = Integer.parseInt(args[2]);}

        Reader.setFilePath(filePath);

        if(operation.equals("encrypt")){
            String textToEncrypt = Reader.readTextFromFile();
            String encryptedText = eng.encode(textToEncrypt, key, operation);
            Path encryptedFilePath = FileCreator.createNewFile(Path.of(filePath.replace(".txt", "(encrypted).txt")) + "");
            Writer.writeNewTextToNewFile(encryptedText, encryptedFilePath);

        }else if(operation.equals("decrypt")){
            String textToDecrypt = Reader.readTextFromFile();
            String decryptedText = eng.encode(textToDecrypt, key, operation);
            Path decryptedFilePath = FileCreator.createNewFile(Path.of(filePath.replace("encrypted", "decrypted"))+"");
            Writer.writeNewTextToNewFile(decryptedText, decryptedFilePath);

        }else if(operation.equals("bruteForce")){
            String textToDecrypt = Reader.readTextFromFile();
            Reader.setFilePath(filePathInstance);
            String instanceForAnalysis = Reader.readTextFromFile();
            key = eng.getKey(textToDecrypt, instanceForAnalysis);
            operation = "decrypt";
            String decryptedText = eng.encode(textToDecrypt, key, operation);
            Path decryptedFilePath = FileCreator.createNewFile(Path.of(filePath.replace(".txt", "(decrypted key-"+ key +").txt")) + "");
            Writer.writeNewTextToNewFile(decryptedText, decryptedFilePath);
        }







    }

}
