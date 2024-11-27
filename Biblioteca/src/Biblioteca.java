import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Livro> livros = new ArrayList<>();

        boolean loopFlow = true;
        while (loopFlow) {
            System.out.println("========================\n");
            System.out.println("Você pode executar as seguintes ações: ");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Remover livro");
            System.out.println("3. Listar livros");
            System.out.println("4. Buscar Livro Pelo Titulo");
            System.out.println("5. Emprestar livro");
            System.out.println("6. Devolver livro");
            System.out.println("7. Adicionar usuário");
            System.out.println("8. Listar usuários");
            System.out.println("9. Sair");
            System.out.print("Digite o número da ação desejada: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    adicionarLivro(livros, scanner);
                    break;
                case 2:
                    break;
                case 3:
                    listarLivros(livros);
                    break;
                case 4:
                    buscarLivroPorNome(livros, scanner);
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    loopFlow = false;
                    break;
            }
        }
        scanner.close();
    }


    private static void adicionarLivro(List<Livro> livros, Scanner scanner){
        System.out.println("\n==========");
        System.out.print("Digite o nome do livro: ");
        String nomeLivro = scanner.nextLine();

        System.out.print("Digite o nome do autor do livro: ");
        String nomeAutor = scanner.nextLine();

        System.out.print("Digite o ano de publicação ");
        String anoPublicacao = scanner.nextLine();

        Livro livro = new Livro();

        livro.titulo = nomeLivro;
        livro.autor = nomeAutor;
        livro.anoPublicacao = anoPublicacao;

        livros.add(livro);
    }

    public static void listarLivros (List<Livro> livros){
        for (Livro livro : livros){
            System.out.println(livro.toString());
            System.out.println(
                    "Titulo: " + livro.titulo
                    + ", Autor: "
                    + livro.autor + "Ano Publicação: " + livro.anoPublicacao);
        }
    }

    public static void buscarLivroPorNome(List<Livro> livros, Scanner scanner){
        System.out.println("\n===================");

        System.out.print("Digite o titulo do livro que deseja buscar: ");
        String tituloLivro = scanner.nextLine();

        for (Livro livro : livros){
            if (livro.titulo.equalsIgnoreCase(tituloLivro)){
                System.out.println(
                        "Titulo: " + livro.titulo
                                + ", Autor: "
                                + livro.autor + "Ano Publicação: " + livro.anoPublicacao);
                return;
            }
        }

        System.out.println("Livro não encontrado");
    }

}

class Livro{
    String titulo;
    String autor;
    String anoPublicacao;
    boolean disponibilidade = true;
    Usuario usuario;
}

class Usuario{
    int id;
    String nomeUsuario;

    String[] livrosEmprestados;
}

