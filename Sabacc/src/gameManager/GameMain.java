package gameManager;
import gameData.*;
import java.util.*;

public class GameMain 
{
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args)  
	{
		
		int numberOfPlayers;
		String input;
		System.out.println("Please enter the number of players (2-8): ");
		numberOfPlayers = scanner.nextInt();
		GameManager manager = new GameManager(numberOfPlayers);
		manager.Run();
		while (true)
		{
			System.out.print("Play again? (yes or no): ");
			input = scanner.next();
			if (input.equals("no"))
			{
				System.exit(1);
			}
			System.out.print("Please enter the number of players (2-8): ");
			numberOfPlayers = scanner.nextInt();
			manager.Run();
		}

	}
	public String getInput(String s)
	{
		System.out.println(s);
		return scanner.next();
	}

}
