package encryptor;

public class Cyrillic extends Language {
    @Override
    public LettersPack getLettersPack() {
        return new LettersPack("CYR");
    }

    @Override
    public int getFinalKey(int key, String operation) {
        int finalKey = 0;

        if(operation.equals("encrypt")){
            if(key > 0){
                finalKey = key % 32;
            }else if(key < 0){
                finalKey =  32 + key % 32;
            }
        }else if(operation.equals("decrypt")){
            key *= -1;
            if(key > 0){
                finalKey = key % 32;
            }else if(key < 0){
                finalKey =  32 + key % 32;
            }
        }

        return finalKey;


    }
}
