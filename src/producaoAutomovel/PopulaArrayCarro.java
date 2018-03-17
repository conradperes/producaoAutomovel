package producaoAutomovel;

import javax.swing.JOptionPane;

public class PopulaArrayCarro {
	
	public Carro[] populaArray() {
		Carro[] carros = {new Carro("Ferrari", "Ferrari 74", 1000000.00), 
				new Carro("Ferrari", "Ferrari 74", 1000000.00),
				new Carro("BMW", "BMW Z5", 500000.00),
				new Carro("Fiat", "Fremont", 100000.00),
				new Carro("Tesla", "Tesla Modelo X", 120000.00),
				new Carro("Fusca", "Fusca 50", 10.00),
				new Carro("Citroen", "Lounge Turbo", 100000.00),
				new Carro("Honda", "Civic", 120000.00),
				new Carro("Bulgari", "Chiron", 1000000.00),
				new Carro("Mazda", "RX7", 150000.00),
				new Carro("Limosine", "Limosine Luxo", 300000.00),
				new Carro("Mini Coper", "Mini", 100000.00),
				new Carro("Chrysler", "300C", 3000000.00),
				new Carro("Audi", "TT", 200000.00)};
		return carros;
	}
	
	public Carro buscaCarros(Carro[] carros, String modelo) {
		
		for(Carro c: carros) {
			if(c.getModelo().contains(modelo))
				return c;
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		PopulaArrayCarro popula = new PopulaArrayCarro();
		String modelo = JOptionPane.showInputDialog(null, "escolha o modelo");
		System.out.println(popula.buscaCarros(popula.populaArray(), modelo ));
	}

}
