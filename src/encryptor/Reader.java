package encryptor;

import exceptions.FilePathException;
import exceptions.TextException;

import java.io.*;
import java.util.Scanner;



public class Reader {

    private static String filePath;
    private static File file;



    public static String readTextFromFile() throws IOException {
        Scanner sc = new Scanner(System.in);

        if((filePath = sc.nextLine()).isBlank()){
            throw new FilePathException("File path is blank");
        } else if (!(file = new File(filePath)).exists()) {
            throw new FilePathException("File doesn't exist");
        }


        String s = "";
        String a = "";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

            if (br.ready()){
                while ((a = br.readLine()) != null){
                    s += a + "\n";
                }
            }

        }

        if(s.isBlank()){throw new TextException("The file is blank");}

        return s;
    }









}
