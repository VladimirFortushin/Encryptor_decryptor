package encryptor;

public abstract class Language implements EncryptorDecryptor {

    @Override
    public LettersPack getLettersPack() {
        return null;
    }

    @Override
    public String encode(String text, int key, String operation) {
        return EncryptorDecryptor.super.encode(text, key, operation);
    }
}
