package gameManager;
import gameData.*;
import java.util.*;

public class GameMain 
{
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		
		int numberOfPlayers;
		System.out.println("Please enter the number of players (2-8: ");
		numberOfPlayers = scanner.nextInt();
		
		GameManager manager = new GameManager(numberOfPlayers);
		manager.Run();
	}
	public String getInput(String s)
	{
		System.out.println(s);
		return scanner.next();
	}

}
