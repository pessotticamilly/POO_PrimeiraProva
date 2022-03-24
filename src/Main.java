import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Lanche> listaLanches = new ArrayList<Lanche>();
    static ArrayList<Bebida> listaBebidas = new ArrayList<Bebida>();
    static ArrayList<Outro> listaOutros = new ArrayList<Outro>();

    public static void main(String[] args) {
        Lanche lanche1 = new Lanche();
        lanche1.setCodigo(1);
        lanche1.setDescricao("X-Salada");
        lanche1.setPreco(12.0);
        lanche1.setPeso(0.8);
        listaLanches.add(lanche1);

        Lanche lanche2 = new Lanche();
        lanche2.setCodigo(2);
        lanche2.setDescricao("X-Tudo");
        lanche2.setPreco(18.0);
        lanche2.setPeso(1.2);
        listaLanches.add(lanche2);

        Lanche lanche3 = new Lanche();
        lanche3.setCodigo(3);
        lanche3.setDescricao("X-Burguer");
        lanche3.setPreco(10.0);
        lanche3.setPeso(0.6);
        listaLanches.add(lanche3);

        Lanche lanche4 = new Lanche();
        lanche4.setCodigo(4);
        lanche4.setDescricao("X-Bacon");
        lanche4.setPreco(15.0);
        lanche4.setPeso(1.0);
        listaLanches.add(lanche4);

        Bebida bebida1 = new Bebida();
        bebida1.setCodigo(1);
        bebida1.setDescricao("Refrigerante");
        bebida1.setPreco(5.0);
        bebida1.setVolume(0.35);
        listaBebidas.add(bebida1);

        Bebida bebida2 = new Bebida();
        bebida2.setCodigo(2);
        bebida2.setDescricao("Refrigerante");
        bebida2.setPreco(10.0);
        bebida2.setVolume(0.6);
        listaBebidas.add(bebida2);

        Bebida bebida3 = new Bebida();
        bebida3.setCodigo(3);
        bebida3.setDescricao("Suco");
        bebida3.setPreco(6.0);
        bebida3.setVolume(0.35);
        listaBebidas.add(bebida3);

        Bebida bebida4 = new Bebida();
        bebida4.setCodigo(4);
        bebida4.setDescricao("Suco");
        bebida4.setPreco(12.0);
        bebida4.setVolume(0.6);
        listaBebidas.add(bebida4);

        Outro outro1 = new Outro();
        outro1.setCodigo(1);
        outro1.setDescricao("Batata");
        outro1.setPreco(5.0);
        outro1.setTamanho("Pequena");
        listaOutros.add(outro1);

        Outro outro2 = new Outro();
        outro2.setCodigo(2);
        outro2.setDescricao("Batata");
        outro2.setPreco(12.5);
        outro2.setTamanho("Média");
        listaOutros.add(outro2);

        Outro outro3 = new Outro();
        outro3.setCodigo(3);
        outro3.setDescricao("Batata");
        outro3.setPreco(20.0);
        outro3.setTamanho("Grande");
        listaOutros.add(outro3);

        Outro outro4 = new Outro();
        outro3.setCodigo(4);
        outro3.setDescricao("Salada");
        outro3.setPreco(8.0);
        outro3.setTamanho("Média");
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
            int certeza;

            switch (selecionaTipo) {
                case 1:
                    Lanche lanche = coletaDadosLanche(pedido);
                    System.out.print("\nVocê tem certeza que desejas cadastrar?" +
                                     "\n1 - Sim" +
                                     "\n2 - Não" +
                                     "\nR: ");
                    certeza = sc.nextInt();

                    switch (certeza){
                        case 1:
                            listaLanches.add(lanche);
                            break;

                        case 2:
                            menu();
                            break;
                    }
                    break;

                case 2:
                    Bebida bebida = coletaDadosBebida(pedido);
                    System.out.print("\nVocê tem certeza que desejas cadastrar?" +
                            "\n1 - Sim" +
                            "\n2 - Não" +
                            "\nR: ");
                    certeza = sc.nextInt();

                    switch (certeza){
                        case 1:
                            listaBebidas.add(bebida);
                            break;

                        case 2:
                            menu();
                            break;
                    }
                    break;

                case 3:
                    Outro outro = coletaDadosOutro(pedido);
                    System.out.print("\nVocê tem certeza que desejas cadastrar?" +
                            "\n1 - Sim" +
                            "\n2 - Não" +
                            "\nR: ");
                    certeza = sc.nextInt();

                    switch (certeza){
                        case 1:
                            listaOutros.add(outro);
                            break;
                        case 2:
                            menu();
                            break;
                    }
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
