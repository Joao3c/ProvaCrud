import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;

class Produto {

    String nome;
    int codigo;  
    double preco;
    int qtdDisponivel;
    int qtdReserva;

    public Produto(String nome, int codigo, double preco, int qtdDisponivel, int qtdReserva) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.qtdDisponivel = qtdDisponivel;
        this.qtdReserva = qtdReserva;
    }
}

public class Mein {

    public static void main(String[] args) {
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n Menu de produtos da loja Jójoias");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Excluir Produto");
            System.out.println("3 - Comprar Produto");
            System.out.println("4 - Reservar Produto");
            System.out.println("5 - Consultar Produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProduto(listaProdutos, scanner);
                    break;
                case 2:
                    excluirProduto(listaProdutos, scanner);
                    break;
                case 3:
                    comprarProduto(listaProdutos, scanner);
                    break;
                case 4:
                    reservarProduto(listaProdutos, scanner);
                    break;
                case 5:
                    consultarProdutos(listaProdutos);
                    break;
                case 0:
                    System.out.println("Muito obigado, volte sempra a loja Jójoias!");
                    break;
                default:
                    System.out.println("Opção invalida, Fake nery");
            }
            
        } while (opcao != 0);

        scanner.close();
    }

    private static void adicionarProduto(ArrayList<Produto> listProdutos, Scanner scanner) {
        System.out.println("Digite o nome do produto");
        String nome = scanner.nextLine();
        System.out.print("Digite o codigo do produto ");
        int codigo = scanner.nextInt();
        System.out.print("Digite o preço do produto ");
        double preco = scanner.nextDouble();
        System.out.print("Digite a quantidade disponível do produto ");
        int qtdDisponivel = scanner.nextInt();
        System.out.print("Digite a quantidade a ser reserva do produto ");
        int qtdReserva = scanner.nextInt();
        scanner.nextLine();

        Produto novoProduto = new Produto(nome,codigo, preco, qtdDisponivel, qtdReserva);
        listProdutos.add(novoProduto);
        System.out.println("Produto adicionado com sucesso!");

    }

    private static void excluirProduto(ArrayList<Produto> listProdutos, Scanner scanner) {
        System.out.print("Digite o indici do produto a ser excluído: ");
        int indici = scanner.nextInt();
        scanner.nextLine();

        if (indici >= 0 && indici < listProdutos.size()) {
            Produto produtoRemovido = listProdutos.remove(indici);
            System.out.println("Produto"  + produtoRemovido.nome + produtoRemovido.codigo + " Foi removido, OUD !");
        } else {
            System.out.println("inválido. Nenhum produto foi removido.");
        }
    }

    private static void comprarProduto(ArrayList<Produto> listProdutos, Scanner scanner) {
        System.out.print("Digite o indici do produto a ser comprado ");
        int indici = scanner.nextInt();
        System.out.print("Digite a quantidade desejada: ");
        int qtdCompra = scanner.nextInt();
        scanner.nextLine();

        if (indici >= 0 && indici < listProdutos.size()) {
            Produto produto = listProdutos.get(indici);
            if (produto.qtdDisponivel >= qtdCompra) {
                produto.qtdDisponivel -= qtdCompra;
                produto.qtdReserva += qtdCompra;
                System.out.println("Produto"  + produto.nome + produto.codigo + " Foi comprado, OUD !");
            } else {
                System.out.println("Quantidade insuficiente. Não foi possível comprar");
            }
        } else {
            System.out.println("Numero inválido. Nenhum produto foi comprado");
        }

    }

    private static void reservarProduto(ArrayList<Produto> listProdutos, Scanner scanner) {
        System.out.print("Digite o indici do produto a ser reservado: ");
        int indici = scanner.nextInt();
        System.out.print("Digite a quantidade desejada: ");
        int qtdReserva = scanner.nextInt();
        scanner.nextLine();

        if (indici >= 0 && indici < listProdutos.size()) {
            Produto produto = listProdutos.get(indici);
            if (produto.qtdDisponivel >= qtdReserva) {
                produto.qtdDisponivel -= qtdReserva;
                produto.qtdReserva += qtdReserva;
                System.out.println("Produto " + produto.nome + "/" +  produto.codigo + " Foi reservado!");
            } else {
                System.out.println("Quantidade insuficiente. Não foi possível reservar.");
            }
        } else {
            System.out.println("Numero inválido. Nenhum produto foi reservado.");
        }

    }

    private static void consultarProdutos(ArrayList<Produto> listProdutos) {
        System.out.println("\nLista de Produtos:");
        for (int i = 0; i < listProdutos.size(); i++) {
            Produto produto = listProdutos.get(i);
            System.out.println(i + " - " + produto.nome + produto.codigo + " (R$" + produto.preco + ") - Quantidade disponível: " + produto.qtdDisponivel + " - Quantidade em reserva: " + produto.qtdReserva);
        }
        if (listProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        }

    }

}
