import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Pedido.produtosEstaticos();

        menu();
    }

    private static void menu() {
        System.out.print("""
                ---- MENU ----
                1 - Cadastrar
                2 - Editar
                3 - Listar
                4 - Remover
                5 - Encerrar
                R:\s""");
        int opcao = sc.nextInt();

        try {
            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> editar();
                case 3 -> {
                    for (int i = 0; i < Pedido.listaPedidos.size(); i++) {
                        System.out.print("\n" + Pedido.listar(i));
                    }
                    System.out.print("\n\n");
                }
                case 4 -> remover();
                case 5 -> {
                    System.out.print("\nEncerrando...");
                    System.exit(0);
                }
                default -> throw new OpcaoInvalidaException();
            }
        } catch (OpcaoInvalidaException | CodigoExistenteException | CodigoInvalidoException | PrecoInvalidoException exception) {
            System.out.print("\n" + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n\n");
        } finally {
            menu();
        }
    }

    private static void cadastrar() throws CodigoExistenteException {
        System.out.print("\nCódigo: ");
        int codigo = sc.nextInt();

        boolean valida = false;

        for (int i = 0; i < Pedido.listaPedidos.size(); i++) {
            if (codigo != Pedido.listaPedidos.get(i).getCodigo()) {
                valida = true;
            } else {
                throw new CodigoExistenteException();
            }
        }

        if (valida) {
            Pedido.cadastrar(codigo);
        }
    }

    public static Pedido coletaDados(int codigo) {
        try{
            int tipoPedido = tipoPedido();

            System.out.print("Descrição: ");
            String descricao = sc.next();

            System.out.print("Preço: ");
            double preco = sc.nextDouble();

            if(preco <= 0){
                throw new PrecoInvalidoException();
            }

            if (tipoPedido == 1) {
                System.out.print("Peso: ");
                double peso = sc.nextDouble();

                if(peso <= 0){
                    throw new PesoInvalidoException();
                }

                System.out.print("\nLanche cadastrado com sucesso!");
                return new Lanche(codigo, descricao, preco, peso);

            } else if (tipoPedido == 2) {
                System.out.print("Volume: ");
                double volume = sc.nextDouble();

                if(volume <= 0){
                    throw new VolumeInvalidoException();
                }

                System.out.print("\nBebida cadastrado com sucesso!");
                return new Bebida(codigo, descricao, preco, volume);

            } else if (tipoPedido == 3) {
                System.out.print("Tamanho: ");
                String tamanho = sc.next();

                if(!tamanho.equals("Pequena") || !tamanho.equals("Média") || !tamanho.equals("Grande")){
                    throw new TamanhoInvalidoException();
                }

                System.out.print("\nOutro cadastrado com sucesso!");
                return new Outro(codigo, descricao, preco, tamanho);
            }
        } catch(PrecoInvalidoException | PesoInvalidoException | VolumeInvalidoException | TamanhoInvalidoException exception){
            System.out.print("\n" + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n\n");
            cadastrar();
        }

        return null;
    }

    private static void editar() throws CodigoInvalidoException, PrecoInvalidoException {
        System.out.print("\nO que desejas editar?");

        int indice = valida();

        if (indice >= 0) {
            System.out.print("\nNovo preço: ");
            double preco = sc.nextDouble();

            if(preco <= 0){
                throw new PrecoInvalidoException();
            }

            Pedido.editar(indice, preco);

            System.out.println("\nEditado com sucesso!");
        }
    }

    private static void remover() throws OpcaoInvalidaException {
        int indice = valida();

        if (indice >= 0) {
            System.out.print("""

                    Você tem certeza que desejas remover?
                    1 - Sim
                    2 - Não
                    R:\s""");
            int confirmacao = sc.nextInt();

            switch (confirmacao) {
                case 1 -> {
                    Pedido.remover(indice);
                    System.out.println("\nRemovido com sucesso!");
                }
                case 2 -> menu();
                default -> throw new OpcaoInvalidaException();
            }
        }
    }

    private static int valida() throws CodigoInvalidoException {
        boolean valida = false;
        int codigo, indice = -1;

        System.out.print("""

                Qual o código?
                R:\s""");
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
            throw new CodigoInvalidoException();
        }
    }

    private static int tipoPedido() {
        System.out.print("""

                1 - Lanche
                2 - Bebida
                3 - Outro
                R:\s""");
        return sc.nextInt();
    }
}