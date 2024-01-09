import java.util.Scanner;
public class TheGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("WELCOME");
		System.out.println("Set your nikname");
		String tstNikname = sc.next();
		
		PlayerStatus Player1 = new PlayerStatus(tstNikname);
		System.out.println(Player1.getNikname() + " has found an artifact in a building. "
				+ "Enter the code of the artifact he has found!");
		int tstArtifactCode = sc.nextInt();
		Player1.findArtifact(tstArtifactCode);
		
		System.out.println(Player1.getNikname() + " is going to a shop to buy a weapon. "
				+ "What weapon do you want to buy?");
		String tstWeapon1 = sc.next();
		Player1.setWeaponInHand(tstWeapon1);
		
		System.out.println("Player 2 turn");
		System.out.println("Set Player 2 nikname");
		String tstNikname2 = sc.next();
		
		PlayerStatus Player2 = new PlayerStatus(tstNikname2);
		System.out.println(Player2.getNikname() + " has found an artifact in a building. "
				+ "Enter the code of the artifact he has found!");
		int tstArtifactCode2 = sc.nextInt();
		Player2.findArtifact(tstArtifactCode2);
		
		System.out.println(Player2.getNikname() + " is going to a shop to buy a weapon. "
				+ "What weapon do you want to buy?");
		String tstWeapon2 = sc.next();
		Player2.setWeaponInHand(tstWeapon2);
		
		System.out.print("\n" + Player1.getNikname() + " Status:" + "\t\t\t\t\t" + Player2.getNikname()+ " Status");
		
		System.out.println("\n" + "Weapon in hand: " + Player1.getWeaponInHand() + "\t\t" + 
					"Weapon in hand: " + Player2.getWeaponInHand());
		System.out.println("Score: " + Player1.getScore() + "\t\t\t\t\t" + "Score: " + Player2.getScore());
		System.out.println("Lives: " + Player1.getLives() + "\t\t\t\t\t" + "Lives: " + Player2.getLives());
		System.out.println("Health: " + Player1.getHealth() + "\t\t\t\t\t" + "Health: " + Player2.getHealth() + "\n\n");
		
		System.out.println(Player1.getNikname() + " walk towards " + Player2.getNikname() + 
							" and ocupy a new position. Enter " + Player1.getNikname() + 
							" new coordinates!" + "\nEnter position X");
		double tstPositionX = sc.nextDouble();
		Player1.setPositionX(tstPositionX);
		System.out.println("Enter position Y");
		double tstPositionY = sc.nextDouble();
		Player1.setPositionY(tstPositionY);
		System.out.println(Player1.getNikname() + " attaks " + Player2.getNikname() + 
							"\n" + Player1.getNikname() + " wins?   >>> " + Player1.shouldAttackOpponent(Player2));
		sc.close();
	}
}
