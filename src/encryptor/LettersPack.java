package encryptor;

public class LettersPack {


    public LettersPack(String packName){
        if(packName.equals("CYR")){

            setLettersAmount(32);
            setFirstLetter('à');
            setLastLetter('ÿ');
            setFirstLetterCapital('À');
            setLastLetterCapital('ß');

        }else if(packName.equals("LAT")){

            setLettersAmount(26);
            setFirstLetter('a');
            setLastLetter('z');
            setFirstLetterCapital('A');
            setLastLetterCapital('Z');
        }
    }


    private char firstLetter;
    private char lastLetter;
    private char firstLetterCapital;
    private char lastLetterCapital;

    private int lettersAmount;



    public void setLettersAmount(int lettersAmount) {
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
