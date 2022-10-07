package encryptor;

public class LettersPack {


    public LettersPack(String packName){
        if(packName.equals("CYR")){

            setFirstLetter('à');
            setLastLetter('ÿ');
            setFirstLetterCapital('À');
            setLastLetterCapital('ß');

        }else if(packName.equals("LAT")){

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



}
