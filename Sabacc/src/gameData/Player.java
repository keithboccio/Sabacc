package gameData;
import java.util.*;

public class Player 
{
	int playerNumber;
	Hand h = new Hand();
	
	public Player(int i)
	{
		playerNumber = i;
	}
	
	public int getPlayerNumber()
	{
		return playerNumber;
	}
	public void setPlayerNumber(int i)
	{
		playerNumber = i;
	}
}
