package encryptor;



import exceptions.ConfigurationEmptyException;
import language.Eng;
import language.Language;
import language.Rus;


import java.nio.file.Path;

import static encryptor.Reader.readTextFromFile;
import static encryptor.Writer.writeNewTextToNewFile;
import static files.FileCreator.createNewFile;
import static language.Language.getLanguage;
import static language.Language.setLanguage;

public class Main {

    static String operation;
    static String filePath;
    static String filePathInstance;
    static Integer key;
    static final Language eng = new Eng();
    static final Language rus = new Rus();


    public static void main(String[] args) throws Exception {
        setLanguage(eng);

        if(args.length == 0){throw new ConfigurationEmptyException("args[...] is empty");}

        operation = args[0];
        filePath = args[1];

        if(operation.equals("bruteForce")){filePathInstance = args[2];}else {key = Integer.parseInt(args[2]);}

        Reader.setFilePath(filePath);

        if(operation.equals("encrypt")){
            String textToEncrypt = readTextFromFile();
            String encryptedText = getLanguage().encode(textToEncrypt, key, operation);
            Path encryptedFilePath = createNewFile(Path.of(filePath.replace(".txt", "(encrypted).txt")) + "");
            writeNewTextToNewFile(encryptedText, encryptedFilePath);

        }else if(operation.equals("decrypt")){
            String textToDecrypt = readTextFromFile();
            String decryptedText = getLanguage().encode(textToDecrypt, key, operation);
            Path decryptedFilePath = createNewFile(Path.of(filePath.replace("encrypted", "decrypted"))+"");
            writeNewTextToNewFile(decryptedText, decryptedFilePath);

        }else if(operation.equals("bruteForce")){
            String textToDecrypt = readTextFromFile();
            Reader.setFilePath(filePathInstance);
            String instanceForAnalysis = readTextFromFile();
            key = getLanguage().getKey(textToDecrypt, instanceForAnalysis);
            operation = "decrypt";
            String decryptedText = getLanguage().encode(textToDecrypt, key, operation);
            Path decryptedFilePath = createNewFile(Path.of(filePath.replace(".txt", "(decrypted key-"+ key +").txt")) + "");
            writeNewTextToNewFile(decryptedText, decryptedFilePath);

        }else {throw new ConfigurationEmptyException("What's ur operation?");}

    }


}
