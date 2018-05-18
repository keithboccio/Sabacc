package gameData;
import java.util.*;
public class Deck extends Stack 
{
	Card c = new Card(1,'n');
	Deck s = new Deck();
	public Deck()
	{
		for (int x = 1; x <= 15; x++)
		{
			s.add(new Card(x,'f'));//flasks
		}
		for (int x = 1; x <= 15; x++)
		{
			s.add(new Card(x,'s'));//staves
		}
		for (int x = 1; x <= 15; x++)
		{
			s.add(new Card(x,'b'));//sabers
		}
		for (int x = 1; x <= 15; x++)
		{
			s.add(new Card(x,'c'));//coins
		}
		s.add(new Card(-11, 'n'));//Balance
		s.add(new Card(-11, 'n'));//Balance
		s.add(new Card(0, 'n'));//Idiot
		s.add(new Card(0, 'n'));//Idiot
		s.add(new Card(-8, 'n'));//Endurance
		s.add(new Card(-8, 'n'));//Endurance
		s.add(new Card(-14, 'n'));//Moderation
		s.add(new Card(-14, 'n'));//Moderation
		s.add(new Card(-15, 'n'));//The Evil One
		s.add(new Card(-15, 'n'));//The Evil One
		s.add(new Card(-2, 'n'));//The queen of Air and Darkness
		s.add(new Card(-2, 'n'));//The Queen of Air and Darkness
		s.add(new Card(-13, 'n'));//Demise
		s.add(new Card(-13, 'n'));//Demise
		s.add(new Card(-10, 'n'));//The Star (classic)
		s.add(new Card(-10, 'n'));//The Star (Classic)
	}
	
	public Deck randomize(Deck d)
	{
		
		return d;
	}
	public Deck getDeck()
	{
		return s;
	}
}

/*
The other 16 were two sets of 8 special cards: Balance (numbered -11), The Idiot (0), 
Endurance (-8), Moderation (-14), The Evil One (-15), The Queen of Air and Darkness (-2), 
Demise (-13), and The Star (-17[10] or -10(classic)).
*/
