package GerenciamentoLivros;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Criando autores
        Autor autor1 = new Autor(1, "Machado de Assis", LocalDate.of(1839, 6, 21));
        Autor autor2 = new Autor(2, "Clarice Lispector", LocalDate.of(1920, 12, 10));

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        // Criando livros
        Livro livro1 = new Livro(1, "Dom Casmurro", autor1);
        Livro livro2 = new Livro(2, "A Hora da Estrela", autor2);
        Livro livro3 = new Livro(3, "Memórias Póstumas", autor1);

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Deseja ver os livros disponíveis? (sim/não)");
            String resposta = scanner.nextLine().trim().toLowerCase();

            if (resposta.equals("sim")) {
                List<Livro> disponiveis = biblioteca.listarLivrosDisponiveis();

                if (disponiveis.isEmpty()) {
                    System.out.println("Não há livros disponíveis no momento.");
                } else {
                    System.out.println("Livros disponíveis:");
                    for (Livro livro : disponiveis) {
                        System.out.println("ID: " + livro.getId() + " - " + livro.getTitulo() + " (Autor: " + livro.getAutor().getNome() + ")");
                    }

                    System.out.println("Digite o ID do livro que deseja emprestar:");
                    int idLivro = Integer.parseInt(scanner.nextLine());

                    Livro livroSelecionado = biblioteca.buscarLivroPorId(idLivro);

                    if (livroSelecionado != null) {
                        System.out.println("Digite seu nome:");
                        String nomeUsuario = scanner.nextLine();

                        biblioteca.emprestarLivro(livroSelecionado, nomeUsuario);

                        System.out.println("Livro \"" + livroSelecionado.getTitulo() + "\" emprestado com sucesso para " + nomeUsuario + ".");
                    } else {
                        System.out.println("Livro não encontrado ou já emprestado.");
                    }
                }

            } else if (resposta.equals("não")) {
                System.out.println("Sistema encerrado. Obrigado por utilizar a biblioteca!");
                continuar = false;
            } else {
                System.out.println("Resposta inválida. Digite 'sim' ou 'não'.");
            }
        }

        scanner.close();
    }
}
