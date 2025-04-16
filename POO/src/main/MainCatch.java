package main;

public class MainCatch {

	public static void main(String[] args) {
		int a = 9; // Declarando as variáveis e seus valores.
		int b = 0;
		
		try {
			int c = a / b;
			System.out.println("c = " + c);
		}
		catch (Exception e) {
			System.err.println("Ocorreu um problema, verifique os números e tente novamente!");
		}

	}

}
