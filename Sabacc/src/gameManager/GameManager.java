package gameManager;
import java.util.*;
import gameData.*;

public class GameManager 
{
	int numPlayers;
	ArrayList<Player> players = new ArrayList(0);
	Deck deck = new Deck();
	
	public GameManager(int i)
	{
		numPlayers = i;
	}
	public void Run()
	{

		
	}
	public void Setup()
	{
		for (int i = 1; i<=numPlayers; i++)
		{
			players.add(new Player(i));
		}
		deck.randomize();
		for (int i = 1; i <=2; i++)
		{
			for (int j = 0; j <numPlayers; j++)
			{
				players.get(j).getPlayerHand().addToHand(deck.pop());
			}
		}
	}

}
