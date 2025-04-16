package model;

import java.util.Scanner; // Importa Scanner para entrada do usuário

// Superclasse Funcionario
class Funcionario {
    private String nome;       // Atributo privado (encapsulamento)
    private double salario;    // Salário base

    // Construtor com validação de parâmetros
    public Funcionario(String nome, double salario) {
        // Validação de nome vazio
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio ou conter apenas espaços.");
        }

        // Validação de salário inválido
        if (salario <= 0) {
            throw new IllegalArgumentException("O salário deve ser maior que zero.");
        }

        this.nome = nome;
        this.salario = salario;
    }

    // Métodos de acesso aos atributos privados
    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    // Método que exibe os dados do funcionário
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.printf("Salário: R$ %.2f\n", salario);
    }
}

// Subclasse Gerente que herda de Funcionario
class Gerente extends Funcionario {
    private String departamento;
    private double bonus;

    // Construtor com bônus padrão
    public Gerente(String nome, double salario, String departamento) {
        super(nome, salario); // Chama construtor da superclasse

        // Valida o departamento
        if (departamento == null || departamento.isEmpty()) {
            throw new IllegalArgumentException("O departamento não pode ser vazio.");
        }

        this.departamento = departamento;
        this.bonus = 1000; // Valor padrão de bônus
    }

    // Sobrecarga: Construtor com bônus personalizado
    public Gerente(String nome, double salario, String departamento, double bonus) {
        super(nome, salario); // Reaproveita construtor da superclasse

        if (departamento == null || departamento.isEmpty()) {
            throw new IllegalArgumentException("O departamento não pode ser vazio.");
        }

        if (bonus < 0) {
            throw new IllegalArgumentException("O bônus não pode ser negativo.");
        }

        this.departamento = departamento;
        this.bonus = bonus;
    }

    // Método que exibe os dados completos do gerente
    public void exibirRelatorioGerente() {
        System.out.println("--- GERENTE ---");
        exibirDados(); // Método herdado da superclasse
        System.out.println("Departamento: " + departamento);
        System.out.printf("Bônus: R$ %.2f\n", bonus);
        System.out.printf("Salário total: R$ %.2f\n", (getSalario() + bonus));
    }
}

// Classe principal
public class SistemaCadastro {
    public static void main(String[] args) {
        System.out.println("==== SISTEMA DE CADASTRO ====");

        try (Scanner scanner = new Scanner(System.in)) { // Scanner para entrada do usuário

        System.out.print("Você quer cadastrar um FUNCIONÁRIO ou GERENTE? (F/G): ");
        String tipo = scanner.nextLine().trim().toUpperCase(); // Captura e normaliza a escolha

        try {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine(); // Captura o nome

            System.out.print("Digite o salário base: ");
            double salario = Double.parseDouble(scanner.nextLine()); // Captura o salário

            if (tipo.equals("F")) {
                // Instancia funcionário
                Funcionario f = new Funcionario(nome, salario);
                f.exibirDados();

            } else if (tipo.equals("G")) {
                System.out.print("Digite o departamento: ");
                String departamento = scanner.nextLine();

                System.out.print("Deseja informar bônus personalizado? (S/N): ");
                String bonusOpcional = scanner.nextLine().trim().toUpperCase();

                Gerente g;

                if (bonusOpcional.equals("S")) {
                    System.out.print("Digite o valor do bônus: ");
                    double bonus = Double.parseDouble(scanner.nextLine());
                    g = new Gerente(nome, salario, departamento, bonus); // Usa construtor com 4 parâmetros
                } else {
                    g = new Gerente(nome, salario, departamento); // Usa construtor com bônus padrão
                }

                g.exibirRelatorioGerente();

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } catch (Exception e) {
            // Trata exceções como entradas inválidas
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }
}
}
