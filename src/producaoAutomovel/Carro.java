package producaoAutomovel;

public class Carro {
	
	private String marca;
	private String modelo;
	private double valor;
	public Carro(String marca, String modelo, double valor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public String toString() {
		return "Meu carro= "+modelo +"--" +marca+ "--" +valor;
	}
}
