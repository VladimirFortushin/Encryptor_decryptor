package encryptor;

public interface EncryptorDecryptor {


    LettersPack getLettersPack();


    default String encode(String text, int key, String operation){

        int finalKey = getFinalKey(key, operation);

        char firstLetter = getLettersPack().getFirstLetter();
        char lastLetter = getLettersPack().getLastLetter();
        char firstLetterCapital = getLettersPack().getFirstLetterCapital();
        char lastLetterCapital = getLettersPack().getLastLetterCapital();


        String s = "";
        char c;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);

            if(c >= firstLetterCapital && c <= lastLetterCapital){

                if((c + finalKey) > lastLetterCapital){
                    c = (char) (firstLetterCapital + (c + finalKey - lastLetterCapital) - 1);
                    s += c;
                }else{
                    c = (char) (c + finalKey);
                    s += c;
                }
            }else if(c >= firstLetter && c <= lastLetter){
                if((c + finalKey) > lastLetter){
                    c = (char) (firstLetter + (c + finalKey - lastLetter) - 1);
                    s += c;
                }else{
                    c = (char) (c + finalKey);
                    s += c;
                }

            }else{
                s += c;
            }

        }

        return s;
    }

    default int getFinalKey(int key, String operation){
        int finalKey = 0;

        if(operation.equals("encrypt")){
            if(key > 0){
                finalKey = key % 26;
            }else if(key < 0){
                finalKey =  26 + key % 26;
            }
        }else if(operation.equals("decrypt")){
            key *= -1;
            if(key > 0){
                finalKey = key % 26;
            }else if(key < 0){
                finalKey =  26 + key % 26;
            }
        }

        return finalKey;

    }


}
