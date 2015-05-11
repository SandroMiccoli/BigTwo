
public class Carta {

	public static enum tipoNaipe{
		OUROS, PAUS, COPAS, ESPADAS
	};
	
	public static enum tipoValor{
		�S,
		UM, DOIS, TR�S, QUATRO, CINCO, SEIS, SETE, OITO, NOVE, DEZ, 
		VALETE, DAMA, REI	
	}
	
	private tipoValor valor; // Valor da carta. De 1 at� 13, sendo 1=A, 11=J, 12=Q e 13=K.
	private tipoNaipe naipe;
	
	public Carta(tipoValor v, tipoNaipe n){
		this.valor = v;
		this.naipe = n;
	}
	
	public void printCarta(){
		System.out.println(this.valor+" de "+this.naipe);
	}
	
}
