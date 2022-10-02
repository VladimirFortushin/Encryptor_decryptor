package exceptions;

import java.io.IOException;

public class TextException extends IOException {
    public TextException(String message){
        super(message);
    }

}
