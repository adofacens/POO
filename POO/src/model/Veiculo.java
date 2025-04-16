package model;

public class Veiculo {
	private String modelo; // public > visível em todas as classes
	private int potencia; // private > não vísivel para as demais classes
	private String combustivel;
	private String marca;
	private int ano;
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) throws Exception {
		//modelo = modelo.trim(); 
		
		// Tratamento do campo, remove espaços extras
		
		if(modelo == null || modelo.trim().isEmpty()) {
			throw new Exception("Modelo é obrigatório!");
		}
		
		this.modelo = modelo;
	}
	
	
	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) throws Exception { 
		// Validação de dados com o uso do Throws e Exception
		if (potencia < 70) {
			throw new Exception("A potência é inválida!");
		}
		this.potencia = potencia;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) throws Exception {
		
		if(combustivel != "Gasolina" && combustivel != "Ethanol") {
			throw new Exception("Combustível não aceito!");
		}
		
		this.combustivel = combustivel;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public static void main(String[] args) throws Exception {
		Veiculo v = new Veiculo();
		
		v.setModelo("Comodoro");
		v.setMarca("Chevrolet");
		v.setPotencia(180);
		v.setCombustivel("Gasolina");
		v.setAno(1976);

	}
	
}
