import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente cliente = null;
        FaturaCliente fatura = null;
        ContaCliente conta = null;

        int opcao;

        do {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Criar Fatura");
            System.out.println("3 - Criar Conta");
            System.out.println("4 - Depositar na Conta");
            System.out.println("5 - Sacar da Conta");
            System.out.println("6 - Ver Conta");
            System.out.println("7 - Ver Fatura com Desconto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastrar Cliente ---");
                    System.out.print("ID: ");
                    int idCliente = sc.nextInt();
                    sc.nextLine(); // limpar buffer
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Desconto (%): ");
                    int desconto = sc.nextInt();
                    cliente = new Cliente(idCliente, nome, desconto);
                    System.out.println("Cliente cadastrado: " + cliente);
                    break;

                case 2:
                    if (cliente == null) {
                        System.out.println("Primeiro cadastre um cliente.");
                        break;
                    }
                    System.out.println("\n--- Criar Fatura ---");
                    System.out.print("ID da fatura: ");
                    int idFatura = sc.nextInt();
                    System.out.print("Valor da fatura: ");
                    double valorFatura = sc.nextDouble();
                    fatura = new FaturaCliente(idFatura, cliente, valorFatura);
                    System.out.println("Fatura criada: " + fatura);
                    break;

                case 3:
                    if (cliente == null) {
                        System.out.println("Primeiro cadastre um cliente.");
                        break;
                    }
                    System.out.println("\n--- Criar Conta ---");
                    System.out.print("ID da conta: ");
                    int idConta = sc.nextInt();
                    conta = new ContaCliente(idConta, cliente);
                    System.out.println("Conta criada com sucesso.");
                    break;

                case 4:
                    if (conta == null) {
                        System.out.println("Crie a conta primeiro.");
                        break;
                    }
                    System.out.print("Valor para depósito: ");
                    double deposito = sc.nextDouble();
                    conta.addDeposito(deposito);
                    break;

                case 5:
                    if (conta == null) {
                        System.out.println("Crie a conta primeiro.");
                        break;
                    }
                    System.out.print("Valor para saque: ");
                    double saque = sc.nextDouble();
                    conta.subSaldo(saque);
                    break;

                case 6:
                    if (conta == null) {
                        System.out.println("Crie a conta primeiro.");
                    } else {
                        System.out.println("Conta atual: " + conta);
                    }
                    break;

                case 7:
                    if (fatura == null) {
                        System.out.println("Crie uma fatura primeiro.");
                    } else {
                        System.out.println("Fatura atual: " + fatura);
                        System.out.printf("Valor com desconto: R$%.2f\n", fatura.getValorComDesconto());
                    }
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
