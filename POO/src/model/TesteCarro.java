package model;

import java.util.Scanner; // Importa Scanner para entrada de dados pelo usuário

// ============================
// SUPERCLASSE: Veiculo
// ============================
class Veiculo {
    String marca;   // Armazena a marca do veículo
    String modelo;  // Armazena o modelo do veículo

    // Construtor com dois parâmetros
    Veiculo(String marca, String modelo) {
        // Atribui os valores diretamente aos atributos da classe
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método que exibe marca e modelo do veículo
    void exibirInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
    }
}

// ============================
// SUBCLASSE: Carro (herda de Veiculo)
// ============================
class Carro extends Veiculo { // uso do extends para herança
    // Atributos específicos da subclasse Carro
    int ano;        // Ano de fabricação do carro
    String cor;     // Cor do carro

    // Construtor básico com 2 parâmetros (herda marca e modelo)
    Carro(String marca, String modelo) {
        super(marca, modelo);           // Chama o construtor da superclasse Veiculo
        this.ano = 0;                   // Define ano padrão como 0
        this.cor = "não definida";      // Define cor padrão
    }

    // Construtor sobrecarregado com 4 parâmetros
    Carro(String marca, String modelo, int ano, String cor) {
        super(marca, modelo);           // Reutiliza o construtor da superclasse
        this.ano = ano;
        this.cor = (cor == null || cor.isEmpty()) ? "Indefinida" : cor; // uso do ==  significa que o valor é nulo ou vazio
        // uso do || significa que a cor é nula ou vazia
        // Se a cor for nula ou vazia, define como "Indefinida"
        // Trata cor inválida para evitar valor nulo
    }

    // Método para exibir todos os dados do carro
    void exibirDetalhes() {
        System.out.println("===== DADOS COMPLETOS DO CARRO =====");
        exibirInfo(); // Método herdado da superclasse
        System.out.println("Ano: " + (ano > 0 ? ano : "Não informado"));
        System.out.println("Cor: " + cor);
    }
}

// ============================
// CLASSE PRINCIPAL
// ============================
public class TesteCarro {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) { // try -catch para evitar interrupção inesperada
            System.out.println("🚗 === SISTEMA DE CADASTRO DE CARROS ===");

            // Captura os dados da superclasse
            System.out.print("Digite a marca do carro: ");
            String marca = sc.nextLine().trim(); // .trim() remove espaços antes/depois

            System.out.print("Digite o modelo do carro: ");
            String modelo = sc.nextLine().trim(); // Captura o modelo com . trim()
            // Validação simples: impede que marca ou modelo sejam vazios

            // Verifica se o usuário deseja inserir dados extras
            System.out.print("Deseja informar o ano e a cor? (s/n): ");
            String resposta = sc.nextLine().trim().toLowerCase();

            Carro carro; // Declaração do objeto Carro

            if (resposta.equals("s")) { // Se o usuário quiser informar ano e cor
                // uso do .equals() para comparação de strings
                // Captura ano e cor com tratamento de entrada vazia
                // Captura ano com validação simples
                System.out.print("Digite o ano do carro: ");
                int ano = 0;
                try {
                    ano = Integer.parseInt(sc.nextLine()); // Conversão direta
                } catch (NumberFormatException e) { // Tratamento de erro para entrada inválida
                    // Uso do NumberFormatException para capturar erro de conversão
                    // Se o usuário digitar algo que não seja um número, exibe mensagem
                    // Se a conversão falhar, define ano como 0 e exibe mensagem
                    System.out.println("Ano inválido! Usando valor padrão (0).");
                }

                // Captura a cor com tratamento de entrada vazia
                System.out.print("Digite a cor do carro: ");
                String cor = sc.nextLine().trim();

                // Cria o objeto com todos os dados (usa construtor sobrecarregado)
                carro = new Carro(marca, modelo, ano, cor);

            } else { // else para o caso de não querer dados extras
                // Se o usuário não quiser informar ano e cor, cria o objeto com dados básicos
                // Cria o objeto com marca e modelo apenas
                carro = new Carro(marca, modelo);
            }

            // Pausa visual para separar entrada da exibição
            System.out.println("\n🔧 Processando informações...");
            try { // try -catch para evitar interrupção inesperada
                Thread.sleep(1000); // 1 segundo de pausa

            } catch (InterruptedException e) { // catch para exceção de interrupção e o uso InterruptedException para capturar a exceção
                // Caso a pausa seja interrompida, exibe mensagem de erro
                // Exibe mensagem de erro se a pausa for interrompida
                System.out.println("Erro na pausa!"); // Mensagem de erro
            }

            // Exibe todos os dados do objeto Carro
            System.out.println();
            carro.exibirDetalhes(); // Chamada do método de exibição
        }
    }
}
