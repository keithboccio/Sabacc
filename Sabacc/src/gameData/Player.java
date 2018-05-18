package gameData;
import java.util.*;

public class Player 
{
	int playerNumber;
	Hand h;
	
	public Player(int i)
	{
		playerNumber = i;
		h = new Hand();
	}
	
	public int getPlayerNumber()
	{
		return playerNumber;
	}
	public void setPlayerNumber(int i)
	{
		playerNumber = i;
	}
	public Hand getPlayerHand()
	{
		return h;
	}
}
