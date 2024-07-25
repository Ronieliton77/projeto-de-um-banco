import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");
        venilton.setCpf("435.315.698-56");
        venilton.setSenha(1234);

        ContaCorrente cc = new ContaCorrente(venilton);
        ContaPoupanca poupanca = new ContaPoupanca(venilton);

        ValidarCPF validadorCPF = new ValidarCPF();
        boolean cpfValido = validadorCPF.isCPFValido(venilton.getCpf());

        if (cpfValido) {
            System.out.println("CPF válido!");

            cc.depositar(100);

            System.out.print("Digite a senha para transferência: ");
            int senha = scanner.nextInt();
            
            if (cc.transferir(150, poupanca, senha)) {
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Transferência falhou!\nVerifique se a senha esta correta ou se o saldo é superior ao valor a ser transferido");
            }

            cc.imprimirExtrato();
            poupanca.imprimirExtrato();
        } else {
            System.out.println("CPF inválido!");
        }
    }
}
