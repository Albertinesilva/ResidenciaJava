package semana4.estudo.produto;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    crudProduto(sc);

    sc.close();
  }

  public static void crudProduto(Scanner scan) {

    int opcao = 0;
    Produto produto = new Produto();
    produto.carregarDeArquivo("produtos.txt");

    do {

      opcao = Utils.menu(scan);

      switch (opcao) {
        case 1:
          produto.cadastrar(scan);
          produto.salvarEmArquivo("produtos.txt");
          break;

        case 2:
          produto.listar();
          Utils.pausar(scan);
          break;

        case 3:
          // editar(scan);
          break;

        case 4:
          // excluir(scan);
          break;

        case 5:
          // pesquisarProduto(scan);
          break;

        case 0:
          System.out.println("\n\tSaindo...");
          System.out.println("\tObrigado por usar o sistema!");
          System.exit(opcao);
          break;
      }

    } while (opcao != 0);

  }
}
