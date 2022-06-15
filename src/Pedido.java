import java.util.ArrayList;

public abstract class Pedido {
    static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private int codigo;
    private String descricao;
    private double preco;

    public Pedido(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public static void produtosEstaticos() {
        listaPedidos.add(new Lanche(1, "X-Salada", 12.0, 0.8));
        listaPedidos.add(new Lanche(2, "X-Tudo", 18.0, 1.2));
        listaPedidos.add(new Lanche(3, "X-Burguer", 10.0, 0.6));
        listaPedidos.add(new Lanche(4, "X-Bacon", 15.0, 1.0));

        listaPedidos.add(new Bebida(1, "Refrigerante", 5.0, 0.35));
        listaPedidos.add(new Bebida(2, "Refrigerante", 10, 0.6));
        listaPedidos.add(new Bebida(3, "Suco", 6.0, 0.35));
        listaPedidos.add(new Bebida(4, "Suco", 12.0, 0.6));

        listaPedidos.add(new Outro(1, "Batata", 5.0, "Pequena"));
        listaPedidos.add(new Outro(2, "Batata", 12.5, "Média"));
        listaPedidos.add(new Outro(3, "Batata", 20.0, "Grande"));
        listaPedidos.add(new Outro(4, "Salada", 8.0, "Média"));
    }

    public static void cadastrar(int codigo) {
        Pedido.listaPedidos.add(Main.coletaDados(codigo));
    }

    public static void editar(int indice, double preco) {
        listaPedidos.get(indice).setPreco(preco);
    }

    public static String listar(int i) {
        return listaPedidos.get(i).toString();
    }

    public static void remover(int indice) {
        listaPedidos.remove(indice);
    }

    @Override
    public String toString() {
        return "\nCódigo: " + codigo +
                "\nDescrição: " + descricao +
                "\nPreço: " + preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}