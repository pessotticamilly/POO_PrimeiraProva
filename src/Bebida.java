public class Bebida extends Pedido {
    private double volume;

    public Bebida(){

    }

    public Bebida(int codigo, String descricao, double preco, double volume) {
        super(codigo, descricao, preco);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nVolume: " + volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
