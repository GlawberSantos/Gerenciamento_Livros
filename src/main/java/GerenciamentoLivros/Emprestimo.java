package GerenciamentoLivros;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private String nomeUsuario;
    private LocalDate dataEmprestimo;

    public Emprestimo(Livro livro, String nomeUsuario) {
        this.livro = livro;
        this.nomeUsuario = nomeUsuario;
        this.dataEmprestimo = LocalDate.now();
    }

    public Livro getLivro() {
        return livro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
}
