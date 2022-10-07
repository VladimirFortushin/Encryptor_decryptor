package encryptor;

public class Latin extends Language {


    @Override
    public LettersPack getLettersPack() {
        return new LettersPack("LAT");
    }

    @Override
    public int getFinalKey(int key, String operation) {
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
