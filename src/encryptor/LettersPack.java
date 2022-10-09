package encryptor;

public class LettersPack {


    public LettersPack(String packName){
        if(packName.equals("RUS")){

            setLettersAmount(32);
            setFirstLetter('\u0430');
            setLastLetter('\u044F');
            setFirstLetterCapital('\u0410');
            setLastLetterCapital('\u042F');

        }else if(packName.equals("ENG")){

            setLettersAmount(26);
            setFirstLetter((char)97);
            setLastLetter((char)122);
            setFirstLetterCapital((char) 65);
            setLastLetterCapital((char) 90);
        }
    }


    private char firstLetter;
    private char lastLetter;
    private char firstLetterCapital;
    private char lastLetterCapital;

    private int lettersAmount;



    private void setLettersAmount(int lettersAmount) {
        this.lettersAmount = lettersAmount;
    }

    private void setFirstLetter(char firstLetter) {
        this.firstLetter = firstLetter;
    }

    private void setLastLetter(char lastLetter) {
        this.lastLetter = lastLetter;
    }

    private void setFirstLetterCapital(char firstLetterCapital) {
        this.firstLetterCapital = firstLetterCapital;
    }

    private void setLastLetterCapital(char lastLetterCapital) {
        this.lastLetterCapital = lastLetterCapital;
    }

    public char getFirstLetter() {

        return firstLetter;
    }

    public char getLastLetter() {
        return lastLetter;
    }

    public char getFirstLetterCapital() {
        return firstLetterCapital;
    }

    public char getLastLetterCapital() {
        return lastLetterCapital;
    }
    public int getLettersAmount() {
        return lettersAmount;
    }




}
