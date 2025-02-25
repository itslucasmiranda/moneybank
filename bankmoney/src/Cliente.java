import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private double saldo;  // Saldo inicial de 200 milhões

    // Construtor
    public Cliente(String nome, String cpf, String email, String senha, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.saldo = 200000000.0;  // Saldo inicial
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }
}