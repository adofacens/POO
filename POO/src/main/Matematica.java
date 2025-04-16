package main;

// Classe principal que contém métodos de operações matemáticas
public class Matematica {

	// Método sobrecarregado: soma de dois inteiros
	public int soma(int a, int b) {
		// Retorna a soma dos dois valores recebidos como argumento
		return a + b;
	}

	// Método sobrecarregado: soma de três inteiros
	public int soma(int a, int b, int c) {
		// Retorna a soma dos três valores recebidos como argumento
		return a + b + c;
	}

	// Método sobrecarregado: soma dos elementos de um array de inteiros
	public int soma(int[] lista) {
		// Inicializa a variável que armazenará o resultado da soma
		int result = 0;

		// Laço for-each para percorrer todos os elementos do array
		for(int n : lista)
			result += n; // Acumula o valor de cada elemento em 'result'

		// Retorna o valor total somado
		return result;
	}

	// Método principal que serve como ponto de entrada da aplicação
	public static void main(String[] args) {

		// Instancia um objeto da classe Matematica
		Matematica mat = new Matematica();

		// Cria um array de inteiros
		int[] array = {1,2,3,4,5,6,7,8,9};

		// Chamada dos métodos sobrecarregados de soma
		int x = mat.soma(1, 2);         // Soma de dois valores
		int y = mat.soma(3, 4, 5);      // Soma de três valores
		int z = mat.soma(array);       // Soma dos valores contidos no array

		// Impressão dos resultados das somas
		System.out.println("x = " + x); // Saída Esperada: 3
		System.out.println("y = " + y); // Saída Esperada: 12
		System.out.println("z = " + z); // Saída Esperada: 45

		// Utiliza os métodos da classe interna OperacaoComArrays
		OperacaoComArrays op = mat.new OperacaoComArrays(); // Cria uma instância da classe interna

		System.out.println("\nImprimindo array completo:");
		op.printArray(array); // Chama o método que imprime todos os elementos do array

		System.out.println("\nImprimindo 5 primeiros elementos:");
		op.printArray(array, 5); // Imprime os 5 primeiros elementos do array

		System.out.println("\nImprimindo elementos do índice 2 ao 6:");
		op.printArray(array, 2, 6); // Imprime elementos do índice 2 ao índice 5 (o índice 6 não é incluso)

	}

	// Classe interna responsável por operações específicas com arrays
	public class OperacaoComArrays {

		// 1. Método para imprimir todos os elementos do array
		public void printArray(int[] array) {
			// Percorre cada elemento do array e imprime individualmente
			for(int i=0; i<array.length; i++) {
				System.out.println(array[i] + " ");
			}
			System.out.println(); // Quebra de linha após a impressão completa
		}

		// 2. Método para imprimir os primeiros 'qtd' elementos do array
		public void printArray(int[] array, int qtd) {
			// Garante que a quantidade não ultrapasse o tamanho do array
			int limite = Math.min(qtd, array.length);

			// Imprime os elementos até o limite definido
			for(int i = 0; i < limite; i++) {
				System.out.println(array[i] + " ");
			}
			System.out.println(); // Quebra de linha após a impressão
		}

		// 3. Método para imprimir os elementos dentro de um intervalo específico
		public void printArray(int[] array, int inicio, int fim) {
			// Verifica se os índices estão dentro dos limites válidos do array
			if (inicio < 0 || fim >= array.length || inicio > fim) {
				System.err.println("Intervalo Inválido!");
				return; // Interrompe a execução do método se os parâmetros forem inválidos
			}

			// Imprime os elementos do índice 'inicio' até 'fim - 1'
			for(int i = inicio; i < fim ; i++) {
				System.out.println(array[i] + " ");
			}
			System.out.println(); // Quebra de linha após a impressão
		}
	}
}
