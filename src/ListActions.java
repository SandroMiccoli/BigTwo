import java.util.Scanner;


public class ListActions implements PlayerState {

	@Override
	public void doAction(Player player) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(player.getName()+" choose your action:");

		System.out.println("1) Pass");
		System.out.println("2) Sort hand by suit");
		System.out.println("3) Sort hand by rank");
		System.out.println("4) Create combination of cards");
		
		int action = scanner.nextInt();
	}

}
