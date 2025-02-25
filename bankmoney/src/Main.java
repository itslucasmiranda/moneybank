import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        // Cadastro de cliente
        System.out.println("Bem-vindo ao sistema bancário!");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Data de nascimento (YYYY-MM-DD): ");
        String dataNascimentoStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);

        banco.cadastrarCliente(nome, cpf, email, senha, dataNascimento);

        // Login
        System.out.print("Informe o CPF para login: ");
        String cpfLogin = scanner.nextLine();

        System.out.print("Informe a senha: ");
        String senhaLogin = scanner.nextLine();

        Cliente cliente = banco.login(cpfLogin, senhaLogin);
        if (cliente != null) {
            System.out.println("Bem-vindo, " + cliente.getNome() + "!");
            System.out.println("Saldo atual: R$ " + cliente.getSaldo());

            // Opção de transferência
            System.out.println("Deseja realizar uma transferência via PIX? (Sim/Não)");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("Sim")) {
                System.out.print("Informe a chave PIX do destinatário (telefone, email, aleatória ou cpf): ");
                String chavePix = scanner.nextLine();

                System.out.print("Informe o valor para a transferência: R$ ");
                double valorTransferencia = scanner.nextDouble();

                scanner.nextLine(); // Consome o newline

                // Confirmação da transferência
                System.out.println("Dados do cliente:");
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("E-mail: " + cliente.getEmail());
                System.out.println("Saldo disponível: R$ " + cliente.getSaldo());
                System.out.print("Digite sua senha para confirmar a transferência: ");
                String senhaConfirmacao = scanner.nextLine();

                if (cliente.verificarSenha(senhaConfirmacao)) {
                    banco.realizarTransferencia(cliente, chavePix, valorTransferencia);
                } else {
                    System.out.println("Senha incorreta. Transferência cancelada.");
                }
            } else {
                System.out.println("Transferência não realizada.");
            }
        } else {
            System.out.println("Login falhou.");
        }

        scanner.close();
    }
}