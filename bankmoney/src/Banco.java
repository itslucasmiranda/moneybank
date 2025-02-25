import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;

    // Construtor
    public Banco() {
        this.clientes = new ArrayList<>();
    }

    // Método para cadastrar cliente
    public void cadastrarCliente(String nome, String cpf, String email, String senha, LocalDate dataNascimento) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println("CPF já cadastrado! Tente fazer login.");
                return;
            }
        }
        Cliente novoCliente = new Cliente(nome, cpf, email, senha, dataNascimento);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Método para fazer login
    public Cliente login(String cpf, String senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf) && cliente.verificarSenha(senha)) {
                System.out.println("Login realizado com sucesso!");
                return cliente;
            }
        }
        System.out.println("CPF ou senha incorretos.");
        return null;
    }

    // Método para realizar transferência via PIX
    public void realizarTransferencia(Cliente cliente, String chavePix, double valor) {
        if (cliente.getSaldo() >= valor) {
            cliente.setSaldo(cliente.getSaldo() - valor);
            System.out.println("Transferência realizada com sucesso!");
            System.out.println("Novo saldo: R$ " + cliente.getSaldo());
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }
}