
public class Carta {

	public static enum tipoNaipe{
		OUROS,
		PAUS,
		COPAS,
		ESPADAS
	};
	
	private int valor; // Valor da carta. De 1 até 13, sendo 1=A, 11=J, 12=Q e 13=K.
	private tipoNaipe naipe;
	
	public Carta(int v, tipoNaipe n){
		this.valor = v;
		this.naipe = n;
	}
	
	public void printCarta(){
		System.out.println(this.valor+" de "+this.naipe);
	}
	
}
