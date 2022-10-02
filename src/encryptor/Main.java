package encryptor;

/*
C:\Users\Vladimir\IdeaProjects\Encryptor_decryptor\src\files\file1
C:\Users\Vladimir\IdeaProjects\Encryptor_decryptor\src\files\file2
 */



import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the source file path:");

        String textToEncrypt = Reader.readTextFromFile();
        System.out.println(textToEncrypt);

        String encryptedText = Encryptor.encrypt(textToEncrypt);



    }
}
