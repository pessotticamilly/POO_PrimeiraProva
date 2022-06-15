public class CodigoExistenteException extends RuntimeException {
    public CodigoExistenteException(){
        super("Este código já está em uso, você não pode usá-lo!");
    }
}
