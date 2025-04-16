package main;

import model.Veiculo;

public class Main {

	public static void main(String[] args) throws Exception {
		Veiculo v = new Veiculo();
		
		try {
		v.setModelo("Opala");
		v.setMarca("Chevrolet");
		v.setPotencia(20);
		v.setAno(1977);
			
		v.setCombustivel("Gasolina");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Vendo este carro: \n");
		System.out.println("Marca: " + v.getMarca());
		System.out.println("Modelo: " + v.getModelo());
		System.out.println("Potencia: " + v.getPotencia() + "cv");
		System.out.println("Combustível: " + v.getCombustivel());
		System.out.println("Ano: " + v.getAno());
	}

}
