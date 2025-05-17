package GerenciamentoLivros;

import java.time.LocalDate;

public class Cliente {
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String email;

    public Cliente (int id, String nome, LocalDate dataNascimento, String email) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public  String toString() {
        return "Cliente{" +"id=" + id + "," +
                " nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + '\'' + '}';
    }
}
