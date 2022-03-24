import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Lanche> listaLanches = new ArrayList<Lanche>();
    static ArrayList<Bebida> listaBebidas = new ArrayList<Bebida>();
    static ArrayList<Outro> listaOutros = new ArrayList<Outro>();

    public static void main(String[] args) {
        Lanche lanche1 = new Lanche(1, "X-Salada", 12.0, 0.8);
        listaLanches.add(lanche1);

        Lanche lanche2 = new Lanche(2, "X-Tudo", 18.0, 1.2);
        listaLanches.add(lanche2);

        Lanche lanche3 = new Lanche(3, "X-Burguer", 10.0, 0.6);
        listaLanches.add(lanche3);

        Lanche lanche4 = new Lanche(4, "X-Bacon", 15.0, 1.0);
        listaLanches.add(lanche4);

        Bebida bebida1 = new Bebida(1, "Refrigerante", 5.0, 0.35);
        listaBebidas.add(bebida1);

        Bebida bebida2 = new Bebida(2, "Refrigerante", 10.0, 0.6);
        listaBebidas.add(bebida2);

        Bebida bebida3 = new Bebida(3, "Suco", 6.0, 0.35);
        listaBebidas.add(bebida3);

        Bebida bebida4 = new Bebida(4, "Suco", 12.0, 0.6);
        listaBebidas.add(bebida4);

        Outro outro1 = new Outro(1, "Batata", 5.0, "Pequena");
        listaOutros.add(outro1);

        Outro outro2 = new Outro(2, "Batata", 12.5, "Pequena");
        listaOutros.add(outro2);

        Outro outro3 = new Outro(3, "Batata", 20.0, "Pequena");
        listaOutros.add(outro3);

        Outro outro4 = new Outro(4, "Salada", 8.0, "Pequena");
        listaOutros.add(outro4);

        menu();
    }

    private static void menu(){
        System.out.print("\n---- MENU ----"  +
                         "\n1 - Cadastrar" +
                         "\n2 - Editar"    +
                         "\n3 - Listar"    +
                         "\n4 - Remover"   +
                         "\n5 - Encerrar"  +
                         "\nR: ");
        int opcao = sc.nextInt();

        switch(opcao){
            case 1:
                cadastrar();
                break;

            case 2:
                editar();
                break;

            case 3:
                listar();
                break;

            case 4:
                remover();
                break;

            case 5:
                System.out.print("\nEncerrando...");
                System.exit(0);
                break;

            default:
                System.out.print("\nOpção inválida! Tente outra vez:\n");
                menu();
                break;
        }
    }

    private static int selecionaTipo(){
        System.out.print("\n1 - Lanche" +
                         "\n2 - Bebida" +
                         "\n3 - Outro"  +
                         "\nR: ");
        return sc.nextInt();
    }

    private static Pedido coletaDadosPedido(int codigoValida){
        int codigo = codigoValida;

        System.out.print("Descrição: ");
        String descricao = sc.next();

        System.out.print("Preço: ");
        double preco = sc.nextDouble();

        return new Pedido(codigo, descricao, preco);
    }

    private static Lanche coletaDadosLanche(Pedido pedido){
        System.out.print("Peso(kg): ");
        double peso = sc.nextDouble();

        return new Lanche(pedido.getCodigo(), pedido.getDescricao(), pedido.getPreco(), peso);
    }

    private static Bebida coletaDadosBebida(Pedido pedido){
        System.out.print("Volume(l): ");
        double volume = sc.nextDouble();

        return new Bebida(pedido.getCodigo(), pedido.getDescricao(), pedido.getPreco(), volume);
    }

    private static Outro coletaDadosOutro(Pedido pedido){
        System.out.print("Tamanho: ");
        String tamanho = sc.next();

        return new Outro(pedido.getCodigo(), pedido.getDescricao(), pedido.getPreco(), tamanho);
    }

    private static int valida(int selecionaTipo){
        boolean valida = false;
        int codigo, indice = -1;

        System.out.print("\nQual o código?" +
                           "\nR: ");
        codigo = sc.nextInt();

        switch(selecionaTipo){
            case 1:
                for(int i = 0; i < listaLanches.size(); i++){
                    if(codigo == listaLanches.get(i).getCodigo()){
                        valida = true;
                        indice = i;
                    }
                }
                break;

            case 2:
                for(int i = 0; i < listaBebidas.size(); i++){
                    if(codigo == listaBebidas.get(i).getCodigo()){
                        valida = true;
                        indice = i;
                    }
                }
                break;

            case 3:
                for(int i = 0; i < listaOutros.size(); i++){
                    if(codigo == listaOutros.get(i).getCodigo()){
                        valida = true;
                        indice = i;
                    }
                }
                break;
        }

        if(valida){
            return indice;
        } else{
            return -1;
        }
    }

    private static int opcaoFinal(){
        System.out.print("\n\nDesejas fazer isto novamente?" +
                "\n1 - Sim" +
                "\n2 - Não" +
                "\nR: ");

        return sc.nextInt();
    }

    private static void cadastrar(){
        System.out.println("\nO que desejas cadastrar?");
        int selecionaTipo = selecionaTipo();

        System.out.print("\nCódigo: ");
        int codigo = sc.nextInt();

        boolean valida = false;

        switch (selecionaTipo){
            case 1:
                for(int i = 0; i < listaLanches.size(); i++){
                    if(codigo != listaLanches.get(i).getCodigo()){
                      valida = true;
                    } else{
                        System.out.print("\nCódigo já cadastrado! Tente outra vez:\n");
                        cadastrar();
                    }
                }
                break;

            case 2:
                for(int i = 0; i < listaBebidas.size(); i++){
                    if(codigo != listaBebidas.get(i).getCodigo()){
                       valida = true;
                    } else{
                        System.out.print("\nCódigo já cadastrado! Tente outra vez:\n");
                        cadastrar();
                    }
                }
                break;

            case 3:
                for(int i = 0; i < listaOutros.size(); i++){
                    if(codigo != listaOutros.get(i).getCodigo()){
                        valida = true;
                    } else{
                        System.out.print("\nCódigo já cadastrado! Tente outra vez:\n");
                        cadastrar();
                    }
                }
                break;
        }

        if(valida) {
            Pedido pedido = coletaDadosPedido(codigo);

            switch (selecionaTipo) {
                case 1:
                    Lanche lanche = coletaDadosLanche(pedido);
                    listaLanches.add(lanche);
                    break;

                case 2:
                    Bebida bebida = coletaDadosBebida(pedido);
                    listaBebidas.add(bebida);
                    break;

                case 3:
                    Outro outro = coletaDadosOutro(pedido);
                    listaOutros.add(outro);
                    break;

                default:
                    System.out.print("\nOpção inválida! Tente outra vez:\n");
                    cadastrar();
                    break;
            }

            System.out.print("\nCadastrado com sucesso!");

            int opcaoFinal = opcaoFinal();

            switch (opcaoFinal) {
                case 1:
                    cadastrar();
                    break;

                case 2:
                    menu();
                    break;
            }
        }
    }

    private static void editar(){
        System.out.print("\nO que desejas editar?");
        int selecionaTipo = selecionaTipo();

        int indice = valida(selecionaTipo);

        if(indice >= 0){
            System.out.print("\nNovo preço: ");
            double preco = sc.nextDouble();

            switch (selecionaTipo) {
                case 1:
                    listaLanches.get(indice).setPreco(preco);
                    break;

                case 2:
                    listaBebidas.get(indice).setPreco(preco);
                    break;

                case 3:
                    listaOutros.get(indice).setPreco(preco);
                    break;

                default:
                    System.out.print("\nOpção inválida! Tente outra vez:\n");
                    editar();
                    break;
            }

            System.out.println("\nEditado com sucesso!");
            menu();

            int opcaoFinal = opcaoFinal();

            switch (opcaoFinal){
                case 1:
                    editar();
                    break;

                case 2:
                    menu();
                    break;
            }
        } else{
            System.out.print("Código não encontrado! Tente novamente:\n");
            editar();
        }
    }

    private static void listar(){
        System.out.print("\nO que desejas listar?");
        int selecionaTipo = selecionaTipo();

        switch(selecionaTipo){
            case 1:
                for(int i = 0; i < listaLanches.size(); i++){
                    System.out.print(listaLanches.get(i).toString() + "\n\n- - - - - - - - - - - - - - -\n");
                }
                break;

            case 2:
                for(int i = 0; i < listaBebidas.size(); i++){
                    System.out.print(listaBebidas.get(i).toString() + "\n\n- - - - - - - - - - - - - - -\n");
                }
                break;

            case 3:
                for(int i = 0; i < listaOutros.size(); i++){
                    System.out.print(listaOutros.get(i).toString() + "\n\n- - - - - - - - - - - - - - -\n");
                }
                break;

            default:
                System.out.print("\nOpção inválida! Tente outra vez:\n");
                listar();
                break;
        }

        int opcaoFinal = opcaoFinal();

        switch (opcaoFinal) {
            case 1:
                listar();
                break;

            case 2:
                menu();
                break;
        }
    }

    private static void remover(){
        System.out.print("\nO que desejas remover?");
        int selecionaTipo = selecionaTipo();

        int indice = valida(selecionaTipo);

        if(indice >= 0){
            switch (selecionaTipo) {
                case 1:
                    listaLanches.remove(indice);
                    break;

                case 2:
                    listaBebidas.remove(indice);
                    break;

                case 3:
                    listaOutros.remove(indice);
                    break;

                default:
                    System.out.print("\nOpção inválida! Tente outra vez:\n");
                    remover();
                    break;
            }

            System.out.println("\nRemovido com sucesso!");

            int opcaoFinal = opcaoFinal();

            switch (opcaoFinal){
                case 1:
                    remover();
                    break;

                case 2:
                    menu();
                    break;
            }
        } else{
            System.out.print("Código não encontrado! Tente novamente:\n");
            remover();
        }
    }
}
