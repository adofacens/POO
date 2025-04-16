package main;

import java.util.Scanner;

// ======================
// SUPERCLASSE: Veículo
//=======================

class Veiculo {
	String marca; // Armazena a marca do veículo
	String modelo; // Armazena o modelo do veículo
	
	// Construtor com dois parâmetros
	Veiculo(String marca, String modelo) {
		// Atribui os valores diretamente aos atributos da classe
		this.marca = marca;
		this.modelo = modelo;
	}
	
	// Método que exibe a marca e modelo do veículo
	void exibirInfo() {
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
	}
}

// =====================================
// SUBCLASSE: Carro (Herda de Veiculo)
//=====================================

class Carro extends Veiculo { // Uso do extends para herança
	// Atributos específicos da subclasse carro
	int ano; // Ano de fabricação
	String cor; // Cor de carro
	
	// Construtor básico com 2 parâmetros (herda marca e modelo)
	Carro(String marca, String modelo) {
		super(marca, modelo); // Chama o construtor da superclasse Veiculo
		this.ano = 0; // Define o ano padrão como 0
		this.cor = "não definida"; // Define a cor padrão
	}
	
	// Construtor sobrecarregado com 4 parâmetros
	Carro(String marca, String modelo, int ano, String cor) {
		super(marca, modelo); // Reutiliza o construtor da superclasse
		this.ano = ano;
		this.cor = (cor == null || cor.isEmpty()) ? "Indefinida" : cor;
		// uso do == significa que o valor é nulo ou vazio
		// uso do || significa que a cor é nula ou vazia
	}
	
	// Método para exibir todos os dados do carro
	void exibirDetalhes() {
		System.out.println("===== DADOS COMPLETOS DO CARRO =====");
		exibirInfo(); // Método herdado da Superclasse
		System.out.println("Ano: " + (ano > 0 ? ano : "Não informado"));
		System.out.println("Cor: " + cor);
	}	
}

// ============================
// CLASSE PRINCIPAL
//============================

public class TesteCarro {

	public static void main(String[] args) {
		// try - catch > para evitar interrupção inesperada
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("=== SISTEMA DE CADASTRO DE CARROS ===");
			
			// Captura os dados da superclasse
			System.out.println("Digite a marca do carro: ");
			String marca = sc.nextLine().trim(); // .trim remove espaços antes e depois do texto
			
			System.out.println("Digite o modelo do carro: ");
			String modelo = sc.nextLine().trim(); // .trim remove espaços antes e depois do texto
			// Validação simples: impede que a marca ou modelo estejam vazios			
			System.out.println("Deseja informar o ano e a cor: (s/n): ");
			String resposta = sc.nextLine().trim().toLowerCase(); // .trim remove espaços antes e depois do texto
			
			Carro carro; // Declaração do objeto carro
			
			if (resposta.equals("s")) { // Se o usuário quiser informar ano e cor
				// uso do .equals() para comparação de strings
				System.out.println("Digite o ano do carro: ");
				int ano = 0;
				try {
					ano = Integer.parseInt(sc.nextLine()); // Conversçao direta
				} catch (NumberFormatException e) {
					// tratamento de erro para entradas inválidas
					System.err.println("Ano inválido! Usando valor padrão (0)");
				}
				
				// Captura a cor com tratamento de entrada vazia
				System.out.println("Digite a cor do carro: ");
				String cor = sc.nextLine().trim();
				
				// Criar o objeto com todos os dados (utilizando o construtor sobrecarergador
				carro = new Carro(marca, modelo, ano, cor);				
			} else {
				// se o usuário não optar por informar ano e cor
				carro = new Carro(marca, modelo);
			}
			
			// pausa visual para separar entrada da exibição
			System.out.println("\n Processando informações...");
			try {
				Thread.sleep(1000); // 1 segundo de pausa = 1000mili
			} catch (InterruptedException e) {
				System.err.println("Erro na pausa!");
			}
			
			// Exibe todos os dados do objeto carro
			System.out.println();
			carro.exibirDetalhes(); // chama o método de exibição
			
			// fecha o Scanner para evitar vazamento de recursos
			sc.close();
					
		}
	}
}
