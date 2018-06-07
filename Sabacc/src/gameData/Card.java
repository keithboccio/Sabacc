package gameData;

public class Card 
{
	int value;
	char suit;
	public Card(int v, char s) 
	{
		value = v;
		suit = s;
	}
	public int getValue()
	{
		return value;
	}
	public char getSuit()
	{
		return suit;
	}
}
