package gameData;
import java.util.*;

public class Player 
{
	int playerNumber; 
	int credits;
	Hand h;
	boolean fold;
	
	public Player(int i)
	{
		playerNumber = i;
		credits = 500;
		h = new Hand();
		fold = false;
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
	public void discardPlayerHand()
	{
		h = new Hand();
	}
	public void setPlayerCredits(int i)
	{
		credits = i;
	}
	public int getPlayerCredits()
	{
		return credits;
	}
	public void setPlayerFold(boolean b)
	{
		fold = b;
	}
	public boolean getPlayerFold()
	{
		return fold;
	}
}
