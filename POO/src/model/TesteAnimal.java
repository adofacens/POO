package model; 
// Define que esta classe pertence ao pacote 'model'.
// Isso é útil para organização de projetos maiores e separação por camadas (ex: model, view, controller).

import java.util.Scanner; 
// Importa a classe Scanner da biblioteca Java para permitir a entrada de dados pelo teclado.


// =========================
// SUPERCLASSE: Animal
// =========================
class Animal {
    String nome; // Armazena o nome do animal
    String cor;  // Armazena a cor do animal

    // Construtor que exige nome e cor ao criar um objeto Animal
    Animal(String nome, String cor) {
        // Validação: impede que um nome vazio ou nulo seja aceito
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
            // 'throw' lança uma exceção que impede a continuação do programa se os dados forem inválidos
        }

        // Inicializa os atributos com os valores recebidos como parâmetro
        this.nome = nome;
        this.cor = cor; // Aceita cores nulas aqui, tratadas depois na subclasse
    }

    // Método para exibir o nome do animal
    void mostrarNome() {
        System.out.println("O nome do animal é: " + nome);
    }
}


// =========================
// SUBCLASSE: Cachorro
// =========================
class Cachorro extends Animal {
    
    // Construtor que chama a superclasse (Animal) e trata a cor se for nula ou vazia
    Cachorro(String nome, String cor) {
        super(nome, (cor == null || cor.isEmpty()) ? "Desconhecida" : cor);
        // Aqui usamos o operador ternário: se 'cor' for vazia, usamos "Desconhecida" como padrão
    }

    // Método específico da subclasse, simulando o latido do cachorro
    void latir() {
        System.out.println(nome + " está latindo: Au Au!");
        // Acessa o atributo 'nome' herdado da superclasse
    }
}


// =========================
// CLASSE PRINCIPAL: TesteAnimal
// =========================
public class TesteAnimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        // Cria um objeto Scanner para permitir entrada de dados digitados no console

        // Solicita o nome do cachorro ao usuário
        System.out.print("Digite o nome do cachorro: ");
        String nomeDoCachorro = scanner.nextLine(); 
        // Armazena a entrada do usuário na variável 'nomeDoCachorro'

        // Solicita a cor do cachorro
        System.out.print("Digite a cor do cachorro: ");
        String cor = scanner.nextLine(); 
        // Armazena a cor digitada

        // Cria um objeto Cachorro com os dados fornecidos
        Cachorro meuCachorro = new Cachorro(nomeDoCachorro, cor);

        // =========================
        // PAUSA VISUAL NO TERMINAL
        // =========================
        System.out.println("\n🐾 Preparando as informações do cachorro...");
        // Mostra uma mensagem amigável ao usuário antes de apresentar os dados

        System.out.println("--------------------------------------------");
        // Linha de separação visual, para organizar melhor a saída

        try {
            Thread.sleep(1500); 
            // Cria uma pausa de 1,5 segundos para simular carregamento de dados
            // Pode ser útil pedagogicamente para destacar o momento da saída
        } catch (InterruptedException e) {
            // Caso ocorra uma interrupção inesperada, esta mensagem será exibida
            System.out.println("Pausa interrompida.");
        }

        // =========================
        // SAÍDA DE DADOS DO OBJETO
        // =========================
        System.out.println("\n=== Dados do Cachorro ===");
        // Cabeçalho visual para os dados que serão exibidos

        meuCachorro.mostrarNome(); 
        // Chama o método herdado da superclasse que imprime o nome

        System.out.println("A cor do cachorro é: " + meuCachorro.cor);
        // Acessa diretamente o atributo herdado 'cor' (visibilidade default)

        meuCachorro.latir(); 
        // Método exclusivo da subclasse, simula o comportamento de um cachorro

        scanner.close(); 
        // Encerra o uso do Scanner — prática recomendada para evitar vazamento de recursos
    }
}
