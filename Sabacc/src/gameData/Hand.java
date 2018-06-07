package gameData;
import java.util.*;

public class Hand extends ArrayList
{
	ArrayList<Card> h = new ArrayList();
	int value;
	
	public Hand()
	{
		value = 0;	
	}
	
	public int getValue()
	{
		return value;
	}
	public void setValue(int i)
	{
		value = i;
	}
	public void addToHand(Card c)
	{
		h.add(c);
		value += c.getValue();
	}
	public void printHand()
	{
		for (int i = 0; i < h.size(); i++)
		{
			System.out.print(h.get(i).getValue());
			System.out.print(h.get(i).getSuit() + " ");
		}
		System.out.println("Total: " + value);
	}

}
