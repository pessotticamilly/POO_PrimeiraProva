public class Outro extends Pedido {
    private String tamanho;

    public Outro(){

    }

    public Outro(int codigo, String descricao, double preco, String tamanho) {
        super(codigo, descricao, preco);
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTamanho: " + tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
