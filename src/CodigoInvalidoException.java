public class CodigoInvalidoException extends RuntimeException {
    public CodigoInvalidoException(){
        super("Desculpe, mas não encontramos este código no nosso banco...");
    }
}
