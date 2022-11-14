package objetos.parcial3.examen;

public class EmailRequiredException extends  RuntimeException{
    public EmailRequiredException(String mensaje){
        super(mensaje);
    }
}
