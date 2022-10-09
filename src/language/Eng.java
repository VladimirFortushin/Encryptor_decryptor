package language;

import encryptor.LettersPack;


public class Eng extends Language {

    @Override
    public LettersPack getLettersPack() {
        return new LettersPack("ENG");
    }

}
