package language;

import encryptor.LettersPack;


public class Rus extends Language {

    @Override
    public LettersPack getLettersPack() {
        return new LettersPack("RUS");
    }

}
