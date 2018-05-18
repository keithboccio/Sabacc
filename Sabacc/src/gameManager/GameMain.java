package gameManager;
import gameData.*;
import java.util.*;

public class GameMain 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int numberOfPlayers;
		System.out.println("Please enter the number of players (2-8: ");
		numberOfPlayers = scanner.nextInt();
		
		GameManager manager = new GameManager(numberOfPlayers);
		manager.Run();
	}

}
