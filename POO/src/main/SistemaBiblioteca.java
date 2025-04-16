package main;
// Sistema de Biblioteca Universitária
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBiblioteca {

    // Classe interna Pessoa (superclasse)
    static class Pessoa {
        private String nome; // Nome da pessoa
        private String email; // Email da pessoa

        // Construtor da classe Pessoa
        public Pessoa(String nome, String email) {
            this.nome = nome;
            this.email = email;
        }

        // Métodos getters e setters para acessar e modificar os atributos
        public String getNome() { return nome; }
        public String getEmail() { return email; }
        public void setNome(String nome) { this.nome = nome; }
        public void setEmail(String email) { this.email = email; }

        // Método toString para representar a pessoa como uma string
        @Override
        public String toString() {
            return "Nome: " + nome + ", Email: " + email;
        }
    }

    // Subclasse Aluno que herda de Pessoa
    static class Aluno extends Pessoa {
        private String ra; // Registro acadêmico do aluno
        private String curso; // Curso do aluno

        // Construtor da classe Aluno
        public Aluno(String nome, String email, String ra, String curso) {
            super(nome, email); // Chama o construtor da superclasse Pessoa
            this.ra = ra;
            this.curso = curso;
        }

        // Métodos getters para acessar os atributos específicos de Aluno
        public String getRa() { return ra; }
        public String getCurso() { return curso; }

        // Sobrescrita do método toString para incluir informações específicas de Aluno
        @Override
        public String toString() {
            return "[Aluno] " + super.toString() + ", RA: " + ra + ", Curso: " + curso;
        }
    }

    // Subclasse Professor que herda de Pessoa
    static class Professor extends Pessoa {
        private String matricula; // Matrícula do professor
        private String area; // Área de atuação do professor

        // Construtor da classe Professor
        public Professor(String nome, String email, String matricula, String area) {
            super(nome, email); // Chama o construtor da superclasse Pessoa
            this.matricula = matricula;
            this.area = area;
        }

        // Métodos getters para acessar os atributos específicos de Professor
        public String getMatricula() { return matricula; }
        public String getArea() { return area; }

        // Sobrescrita do método toString para incluir informações específicas de Professor
        @Override
        public String toString() {
            return "[Professor] " + super.toString() + ", Matrícula: " + matricula + ", Área: " + area;
        }
    }

    // Classe Livro
    static class Livro {
        private String titulo; // Título do livro
        private String autor; // Autor do livro
        private String genero; // Gênero do livro
        private int ano; // Ano de publicação do livro
        private boolean emprestado; // Status de empréstimo do livro

        // Construtor principal da classe Livro
        public Livro(String titulo, String autor, String genero, int ano) {
            this.titulo = titulo;
            this.autor = autor;
            this.genero = genero;
            this.ano = ano;
            this.emprestado = false; // Inicialmente, o livro não está emprestado
        }

        // Sobrecarga do construtor - permite criar um livro sem especificar o ano
        public Livro(String titulo, String autor, String genero) {
            this(titulo, autor, genero, 0); // Chama o construtor principal com ano = 0
        }

        // Métodos getters para acessar os atributos
        public String getTitulo() { return titulo; }
        public String getAutor() { return autor; }
        public boolean isEmprestado() { return emprestado; }

        // Método para emprestar o livro
        public void emprestar() {
            if (emprestado) { // Verifica se o livro já está emprestado
                throw new IllegalStateException("Livro já emprestado!");
            }
            emprestado = true; // Marca o livro como emprestado
        }

        // Método para devolver o livro
        public void devolver() {
            emprestado = false; // Marca o livro como disponível
        }

        // Sobrescrita do método toString para representar o livro como uma string
        @Override
        public String toString() {
            return "[Livro] Título: " + titulo + ", Autor: " + autor + ", Gênero: " + genero +
                    ", Ano: " + (ano > 0 ? ano : "Não informado") + ", Status: " + (emprestado ? "Emprestado" : "Disponível");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner para entrada do usuário

        // Listas para armazenar livros e usuários
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Pessoa> usuarios = new ArrayList<>();

        int opcao; // Variável para armazenar a opção do menu

        do {
            // Exibe o menu principal
            System.out.println("\n📚 MENU - SISTEMA BIBLIOTECA UNIVERSITÁRIA");
            System.out.println("1 - Cadastrar novo livro");
            System.out.println("2 - Cadastrar novo aluno");
            System.out.println("3 - Cadastrar novo professor");
            System.out.println("4 - Realizar empréstimo");
            System.out.println("5 - Realizar devolução");
            System.out.println("6 - Listar livros");
            System.out.println("7 - Listar usuários");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt(); // Lê a opção do usuário
            } catch (java.util.InputMismatchException e) {
                // Trata entrada inválida
                System.out.println("❌ Entrada inválida! Por favor, insira um número inteiro.");
                scanner.nextLine(); // Limpa o buffer do scanner
                opcao = -1; // Define uma opção inválida para continuar o loop
            }
            scanner.nextLine(); // Limpa o buffer após a leitura do número

            // Processa a opção escolhida
            switch (opcao) {
                case 1 -> {
                    // Cadastro de um novo livro
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();
                    System.out.print("Ano (opcional, pressione ENTER para ignorar): ");
                    String entrada = scanner.nextLine();

                    if (entrada.isEmpty()) {
                        // Cria o livro sem ano
                        livros.add(new Livro(titulo, autor, genero));
                    } else {
                        // Cria o livro com ano
                        int ano = Integer.parseInt(entrada);
                        livros.add(new Livro(titulo, autor, genero, ano));
                    }
                    System.out.println("✅ Livro cadastrado!");
                }
                case 2 -> {
                    // Cadastro de um novo aluno
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("RA: ");
                    String ra = scanner.nextLine();
                    System.out.print("Curso: ");
                    String curso = scanner.nextLine();
                    usuarios.add(new Aluno(nome, email, ra, curso));
                    System.out.println("✅ Aluno cadastrado!");
                }
                case 3 -> {
                    // Cadastro de um novo professor
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Área: ");
                    String area = scanner.nextLine();
                    usuarios.add(new Professor(nome, email, matricula, area));
                    System.out.println("✅ Professor cadastrado!");
                }
                case 4 -> {
                    // Realizar empréstimo de um livro
                    System.out.print("Digite o título do livro a ser emprestado: ");
                    String titulo = scanner.nextLine();
                    boolean encontrado = false;
                    for (Livro livro : livros) {
                        if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                            try {
                                livro.emprestar(); // Tenta emprestar o livro
                                System.out.println("📦 Livro emprestado com sucesso!");
                            } catch (Exception e) {
                                System.out.println("❌ " + e.getMessage());
                            }
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("🔍 Livro não encontrado.");
                }
                case 5 -> {
                    // Realizar devolução de um livro
                    System.out.print("Digite o título do livro a ser devolvido: ");
                    String titulo = scanner.nextLine();
                    boolean encontrado = false;
                    for (Livro livro : livros) {
                        if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                            livro.devolver(); // Devolve o livro
                            System.out.println("📦 Livro devolvido com sucesso!");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("🔍 Livro não encontrado.");
                }
                case 6 -> {
                    // Listar todos os livros cadastrados
                    System.out.println("📚 Livros cadastrados:");
                    for (Livro l : livros) System.out.println(l);
                }
                case 7 -> {
                    // Listar todos os usuários cadastrados
                    System.out.println("👥 Usuários cadastrados:");
                    for (Pessoa p : usuarios) System.out.println(p);
                }
                case 0 -> System.out.println("👋 Encerrando o programa...");
                default -> System.out.println("❗ Opção inválida.");
            }

        } while (opcao != 0); // Continua o loop até que a opção seja 0 (sair)

        scanner.close(); // Fecha o scanner
    }
}
