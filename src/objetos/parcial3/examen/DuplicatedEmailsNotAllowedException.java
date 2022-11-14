package objetos.parcial3.examen;

public class DuplicatedEmailsNotAllowedException  extends RuntimeException{

    public DuplicatedEmailsNotAllowedException(String mensaje){
        super(mensaje);
    }
}
