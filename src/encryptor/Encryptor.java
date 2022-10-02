package encryptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 || c == ' ' || c == '!' || c == '.' || c == ',' || c == '"' || c == '-' || c == ':'|| c == '?'
 */

public class Encryptor {


    private static final Pattern punctuationPattern = Pattern.compile("[-.,!? :\" à-ÿ¸À-ß¨]");
    private static Matcher m;
    static String q = "[-.,!? :\" à-ÿ¸À-ß¨]";





    public static String encrypt(String text){
        m = punctuationPattern.matcher(text);



        char[] arr = new char[text.length()];
        int k = 3;
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < text.length(); i++) {
            if(Character.UnicodeBlock.of(arr[i]) == Character.UnicodeBlock.CYRILLIC){
                arr[i] = (char)((int)(text.charAt(i)) + k);

                sb.append(arr[i]);
            }else{sb.append(arr[i]);}

        }


        System.out.println(sb);
        return String.valueOf(sb);
    }

    public static String dencrypt(String text){
        StringBuilder sb = new StringBuilder("");
        char[] arr = text.toCharArray();

        for(char c : arr){
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC) {
                c -= 3;
                sb.append(c);
            }

        }



        return String.valueOf(sb);
    }






}
