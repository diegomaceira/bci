package cl.bci.exception;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException (String message){
        super(message);
    }
}
