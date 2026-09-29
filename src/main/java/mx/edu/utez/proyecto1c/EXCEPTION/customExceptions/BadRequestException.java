package mx.edu.utez.proyecto1c.EXCEPTION.customExceptions;

public class BadRequestException extends RuntimeException{
    ///constructor para recivir mensaje para devolver con nuestro constructor
    public BadRequestException(String message){
        super(message);
    }
}

