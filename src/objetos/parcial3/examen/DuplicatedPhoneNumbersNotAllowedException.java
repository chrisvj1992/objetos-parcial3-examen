package objetos.parcial3.examen;

public class DuplicatedPhoneNumbersNotAllowedException extends RuntimeException{
    public DuplicatedPhoneNumbersNotAllowedException(String mensaje){
        super(mensaje);
    }
}
