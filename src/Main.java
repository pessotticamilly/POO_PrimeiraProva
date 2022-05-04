import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Pedido.produtosEstaticos();

        menu();
    }

    private static void menu() {
        System.out.print("\n---- MENU ----" +
                "\n1 - Cadastrar" +
                "\n2 - Editar" +
                "\n3 - Listar" +
                "\n4 - Remover" +
                "\n5 - Encerrar" +
                "\nR: ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                cadastrar();
                break;

            case 2:
                editar();
                break;

            case 3:
                for (int i = 0; i < Pedido.listaPedidos.size(); i++) {
                    System.out.print("\n" + Pedido.listar(i));
                }

                menu();
                break;

            case 4:
                remover();
                break;

            case 5:
                System.out.print("\nEncerrando...");
                System.exit(0);
                break;
        }
    }

    private static int tipoPedido() {
        System.out.print("\n1 - Lanche" +
                "\n2 - Bebida" +
                "\n3 - Outro" +
                "\nR: ");
        return sc.nextInt();
    }

    public static Pedido coletaDados(int codigo) {
        int tipoPedido = tipoPedido();

        System.out.print("Descrição: ");
        String descricao = sc.next();

        System.out.print("Preço: ");
        double preco = sc.nextDouble();

        if (tipoPedido == 1) {
            System.out.print("Peso: ");
            double peso = sc.nextDouble();

            return new Lanche(codigo, descricao, preco, peso);

        } else if (tipoPedido == 2) {
            System.out.print("Volume: ");
            double volume = sc.nextDouble();

            return new Bebida(codigo, descricao, preco, volume);

        } else if (tipoPedido == 3) {
            System.out.print("Tamanho: ");
            String tamanho = sc.next();

            return new Outro(codigo, descricao, preco, tamanho);
        }

        return null;
    }

    private static int valida() {
        boolean valida = false;
        int codigo, indice = -1;

        System.out.print("\nQual o código?" +
                "\nR: ");
        codigo = sc.nextInt();

        for (int i = 0; i < Pedido.listaPedidos.size(); i++) {
            if (codigo == Pedido.listaPedidos.get(i).getCodigo()) {
                valida = true;
                indice = i;
            }
        }

        if (valida) {
            return indice;
        } else {
            return -1;
        }
    }

    private static void cadastrar() {
        System.out.print("\nCódigo: ");
        int codigo = sc.nextInt();

        boolean valida = false;

        for (int i = 0; i < Pedido.listaPedidos.size(); i++) {
            if (codigo != Pedido.listaPedidos.get(i).getCodigo()) {
                valida = true;
            } else {
                System.out.print("\nCódigo já cadastrado! Tente outra vez:\n");
                cadastrar();
            }
        }

        if (valida) {
            Pedido.cadastrar(codigo);
        }
    }

    private static void editar() {
        System.out.print("\nO que desejas editar?");

        int indice = valida();

        if (indice >= 0) {
            System.out.print("\nNovo preço: ");
            double preco = sc.nextDouble();

            Pedido.editar(indice, preco);

            System.out.println("\nEditado com sucesso!");
            menu();

        } else {
            System.out.print("Código não encontrado! Tente novamente:\n");
            editar();
        }
    }

    private static void remover() {
        int indice = valida();

        if (indice >= 0) {
            System.out.print("\nVocê tem certeza que desejas remover?" +
                    "\n1 - Sim" +
                    "\n2 - Não" +
                    "\nR: ");
            int confirmacao = sc.nextInt();

            switch (confirmacao) {
                case 1:
                    Pedido.remover(indice);
                    break;

                case 2:
                    menu();
                    break;
            }

            System.out.println("\nRemovido com sucesso!");

        } else {
            System.out.print("Código não encontrado! Tente novamente:\n");
            remover();
        }
    }
}