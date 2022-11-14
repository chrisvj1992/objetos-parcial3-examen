package objetos.parcial3.examen;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String mensaje){
        super(mensaje);
    }

}
