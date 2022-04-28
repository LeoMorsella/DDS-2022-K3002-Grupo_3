package UserExceptions;

public class ArchivoNotFoundException extends  RuntimeException {
    public ArchivoNotFoundException(String mensajeDeError) {
        System.out.println(mensajeDeError);
    }
}
