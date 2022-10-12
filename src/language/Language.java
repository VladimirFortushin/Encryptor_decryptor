package language;

import encryptor.Analyzer;
import encryptor.EncryptorDecryptor;

public abstract class Language implements EncryptorDecryptor, Analyzer {
    private static Language language;

    public static Language getLanguage() {
        return language;
    }

    public static void setLanguage(Language language) {
        Language.language = language;
    }

}
