package View;

import control.FilmeController;
import model.Filme;
import java.util.Scanner;

/*
 * Aqui aplicamos:
 *
 * GRASP – Controller
 *   A view NÃO acessa diretamente os dados e NÃO cria regras de negócio.
 *   Ela chama o FilmeController sempre que precisa executar uma ação.
 *
 *Low Coupling (Baixo Acoplamento)
 *   A view conhece apenas o Controller e usa seus métodos públicos.
 *   A view NÃO sabe como os filmes são armazenados.
 *
 * High Cohesion (Alta Coesão)
 *   A view faz apenas uma coisa: interação com o usuário.
 *   Nenhuma lógica de CRUD ou cálculos aqui.
 */

public class ViewFilmes {

    public static void main(String[] args) {

        // A VIEW usa apenas o Controller → segue o padrão Controller do GRASP
        FilmeController controller = new FilmeController();
        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        do {
            System.out.println("\n===== MENU FILMES =====");
            System.out.println("1 - Adicionar filme");
            System.out.println("2 - Editar filme");
            System.out.println("3 - Remover filme");
            System.out.println("4 - Listar filmes");
            System.out.println("5 - Buscar filme");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {

                case 1:
                    
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Gênero: ");
                    String genero = sc.nextLine();

                    System.out.print("Ano: ");
                    int ano = sc.nextInt();

                    System.out.print("Duração (minutos): ");
                    int duracao = sc.nextInt();

                    // Controller aplica o padrão Creator ao criar o filme
                    controller.adicionarFilme(id, titulo, genero, ano, duracao);

                    System.out.println("Filme adicionado!");
                    break;

                case 2:
                    System.out.print("ID do filme para editar: ");
                    int idEdit = sc.nextInt(); sc.nextLine();

                    System.out.print("Novo título: ");
                    String novoTitulo = sc.nextLine();

                    System.out.print("Novo gênero: ");
                    String novoGenero = sc.nextLine();

                    System.out.print("Novo ano: ");
                    int novoAno = sc.nextInt();

                    System.out.print("Nova duração: ");
                    int novaDuracao = sc.nextInt();

                    
                    boolean editado = controller.editarFilme(idEdit, novoTitulo, novoGenero, novoAno, novaDuracao);

                    System.out.println(editado ? "Filme editado!" : "Filme não encontrado.");
                    break;

                case 3:
                    System.out.print("ID para remover: ");
                    int idRemover = sc.nextInt();

                    boolean removido = controller.removerFilme(idRemover);

                    System.out.println(removido ? "Filme removido!" : "Filme não encontrado.");
                    break;

                case 4:
                    System.out.println("\n===== FILMES =====");
                    /*
                     * A VIEW apenas exibe o que o controller retorna.
                     * Alta coesão: só mostra dados.
                     * Baixo acoplamento: não sabe como os filmes são guardados.
                     */
                    for (Filme f : controller.listarFilmes()) {
                        System.out.println(f);
                    }
                    break;

                case 5:
                    System.out.print("ID para buscar: ");
                    int idBuscar = sc.nextInt();

                    Filme encontrado = controller.buscarFilme(idBuscar);

                    System.out.println(encontrado != null ? encontrado : "Filme não encontrado.");
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}

