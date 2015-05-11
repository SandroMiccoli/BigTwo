import java.util.ArrayList;


public class Baralho {
	
	private ArrayList<Carta> cartas;
	
	public Baralho(){
		cartas = new ArrayList<Carta>();
		for (Carta.tipoNaipe n : Carta.tipoNaipe.values()){
			for (int v=1; v<=13; v++){
				cartas.add(new Carta(v,n));
			}
		}
	}
	
	public void printBaralho(){
		for(Carta c : cartas){
			c.printCarta();
		}
	}

}
