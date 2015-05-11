import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


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
	
	public void imprimirTodasAsCartas(){
		System.out.println("Imprimindo todas as cartas...");
		for(Carta c : cartas){
			c.printCarta();
		}
	}
	
	public void embaralhar(){
		System.out.println("Embaralhando o baralho...");
		long seed = System.nanoTime();
		Collections.shuffle(cartas, new Random(seed));
	}

}
