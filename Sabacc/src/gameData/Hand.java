package gameData;
import java.util.*;

public class Hand extends ArrayList
{
	ArrayList h = new ArrayList();
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

}
