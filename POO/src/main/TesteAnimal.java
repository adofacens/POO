package main;

import java.util.Scanner;

// Clase base ou superclasse
class Animal {
	
	String nome; // Atributo que armazena o nome do animal
	
	// Construtor com parâmetro para inicializar o nome
	Animal(String nome) {
		this.nome = nome; // 'this.nome' refere-se ao atributo da classe, e recebe o valor passado no parâmetro
	}
	
	// Método para exibir o nome do animal
	void mostrarNome() {
		System.out.println("O nome do animal é: " + nome); // Imprime o nome armazenado
	}
	
}

	// Subclasse que herda da classe Animal

class Cachorro extends Animal {
	
	// Construtor da subclasse. Recebe o nome e passa para o construtor da superclase utilizando super()
	Cachorro(String nome) {
		super(nome); // Chama o construtor da superclasse Animal com o valor recebido
	}
	
	// Método específico da subclasse
	void latir() {
		System.out.println(nome + " está latindo: Au Au!"); // Usa o atributo herdado 'nome'
	}
}

// Classe principal (ponto de entrada do programa)
public class TesteAnimal {
	
	public static void main(String[] args) {
		// Cria o objeto Scanner para capturar a entrada do usuário
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o nome do cachorro: ");
		String nomeDoCachorro = scanner.nextLine(); // Lê a linha digitada pelo usuário
		
		// Cria um novo objeto da classe Cachorro utilizando o nome digitado.
		Cachorro meuCachorro = new Cachorro(nomeDoCachorro);
		
		meuCachorro.mostrarNome(); // Chama o método herdado para mostrar o nome do Animal
		meuCachorro.latir(); // Chama o método da subclasse
		
		// Fechar o scanner para evitar vazamento de recursos
		scanner.close(); // Fecha o objeto Scanner após o uso
	}
}
