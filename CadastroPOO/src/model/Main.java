package CadastroPOO.src.model;

/**
 *
 * @author dilnae
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();

        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Incluir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Exibir pelo ID");
            System.out.println("5. Exibir Todos");
            System.out.println("6. Salvar Dados");
            System.out.println("7. Recuperar Dados");
            System.out.println("0. Finalizar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    incluir(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 2:
                    alterar(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 3:
                    excluir(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 4:
                    obter(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 5:
                    obterTodos(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 6:
                    salvarDados(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 7:
                    recuperarDados(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 0:
                    System.out.println("Finalizando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void incluir(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Escolha o tipo:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (tipo == 1) {
            System.out.println("Incluir Pessoa Física:");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();

            PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
            pessoaFisicaRepo.inserir(pessoaFisica);
            System.out.println("Pessoa Física incluída com sucesso.");
        } else if (tipo == 2) {
            System.out.println("Incluir Pessoa Jurídica:");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();

            PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
            pessoaJuridicaRepo.inserir(pessoaJuridica);
            System.out.println("Pessoa Jurídica incluída com sucesso.");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static void alterar(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Escolha o tipo:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        
        if (tipo == 1) {
            System.out.print("ID da Pessoa Física a ser alterada: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            PessoaFisica pessoaFisica = pessoaFisicaRepo.obter(id);
            if (pessoaFisica != null) {
                System.out.println("Dados atuais da Pessoa Física:");
                pessoaFisica.exibir();
                System.out.print("Novo nome: ");
                String novoNome = scanner.nextLine();
                pessoaFisica.setNome(novoNome);
                System.out.print("Novo CPF: ");
                String novoCpf = scanner.nextLine();
                pessoaFisica.setCpf(novoCpf);
                System.out.print("Nova idade: ");
                int novaIdade = scanner.nextInt();
                pessoaFisica.setIdade(novaIdade);
                pessoaFisicaRepo.alterar(pessoaFisica);
                System.out.println("Pessoa Física alterada com sucesso.");
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (tipo == 2) {
            System.out.print("ID da Pessoa Jurídica a ser alterada: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter(id);
            if (pessoaJuridica != null) {
                System.out.println("Dados atuais da Pessoa Jurídica:");
                pessoaJuridica.exibir();
                System.out.print("Novo nome: ");
                String novoNome = scanner.nextLine();
                pessoaJuridica.setNome(novoNome);
                System.out.print("Novo CNPJ: ");
                String novoCnpj = scanner.nextLine();
                pessoaJuridica.setCnpj(novoCnpj);
                pessoaJuridicaRepo.alterar(pessoaJuridica);
                System.out.println("Pessoa Jurídica alterada com sucesso.");
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
    
    private static void excluir(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Escolha o tipo:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        System.out.print("ID da entidade a ser excluída: ");
        int id = scanner.nextInt();
        if (tipo == 1) {
            pessoaFisicaRepo.excluir(id);
            System.out.println("Pessoa Física excluída com sucesso.");
        } else if (tipo == 2) {
            pessoaJuridicaRepo.excluir(id);
            System.out.println("Pessoa Jurídica excluída com sucesso.");
        } else {
            System.out.println("Opção inválida.");
        }
    }
    
    private static void obter(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Escolha o tipo:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        System.out.print("ID da entidade a ser obtida: ");
        int id = scanner.nextInt();
        if (tipo == 1) {
            PessoaFisica pessoaFisica = pessoaFisicaRepo.obter(id);
            if (pessoaFisica != null) {
                System.out.println("Dados da Pessoa Física:");
                pessoaFisica.exibir();
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (tipo == 2) {
            PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter(id);
            if (pessoaJuridica != null) {
                System.out.println("Dados da Pessoa Jurídica:");
                pessoaJuridica.exibir();
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
    
    private static void obterTodos(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Escolha o tipo:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        if (tipo == 1) {
            ArrayList<PessoaFisica> pessoasFisicas = pessoaFisicaRepo.obterTodos();
            System.out.println("Pessoas Físicas:");
            for (PessoaFisica pessoaFisica : pessoasFisicas) {
                pessoaFisica.exibir();
                System.out.println();
            }
        } else if (tipo == 2) {
            ArrayList<PessoaJuridica> pessoasJuridicas = pessoaJuridicaRepo.obterTodos();
            System.out.println("Pessoas Jurídicas:");
            for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
                pessoaJuridica.exibir();
                System.out.println();
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
    
    private static void salvarDados(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.print("Digite o prefixo dos arquivos: ");
        String prefixo = scanner.nextLine();
        pessoaFisicaRepo.persistir(prefixo + ".fisica.bin");
        pessoaJuridicaRepo.persistir(prefixo + ".juridica.bin");
        System.out.println("Dados salvos com sucesso.");
    }
    
    private static void recuperarDados(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.print("Digite o prefixo dos arquivos: ");
        String prefixo = scanner.nextLine();
        pessoaFisicaRepo.recuperar(prefixo + ".fisica.bin");
        pessoaJuridicaRepo.recuperar(prefixo + ".juridica.bin");
        System.out.println("Dados recuperados com sucesso.");
    }
    
}
