package gameManager;
import java.util.*;
import gameData.*;

public class GameManager 
{
	Scanner scanner = new Scanner(System.in);
	int numPlayers;
	ArrayList<Player> players = new ArrayList(0);
	Deck deck = new Deck();
	int mainPot = 0;
	int sabaccPot = 0;
	int currentBet;
	int round = 0;
	String inputString;
	int inputInt;
	boolean bet = false;
	
	public GameManager(int i)
	{
		numPlayers = i;
	}
	public void Run()
	{
		Setup();
		while (round <=4)
		{
			for (int a = 1; a<=numPlayers; a++)//betting
			{
				if (bet == false)
				{
					System.out.println("Bet(for no bet enter 0): ");
					inputInt = scanner.nextInt();
					switch (inputInt)
					{
						case (0): 	break;
						default:	bet = true;
									currentBet = inputInt;
									players.get(a).setPlayerCredits(players.get(a).getPlayerCredits()-inputInt);
									mainPot += currentBet;
					}
				}
				else 
				{
					if (players.get(a).getPlayerFold() == false)
					{
						System.out.println("Call, raise, or fold: ");
						inputString = scanner.next();
						switch(inputString)
						{
							case ("call"):	players.get(a).setPlayerCredits(players.get(a).getPlayerCredits()-inputInt);
											mainPot += currentBet;
							case ("raise"):	System.out.println("Current bet: " + currentBet + " Raise amount: ");
											inputInt = scanner.nextInt();
											currentBet += inputInt;
											mainPot += currentBet;
											players.get(a).setPlayerCredits(players.get(a).getPlayerCredits()-inputInt);
							case ("fold"):	players.get(a).setPlayerFold(true);
							default: 		System.out.println("Please enter call or raise or fold: ");
											a--;
											
						}
						
					}
					else
					{
						//do nothing
					}
				}

			}
			
			for (int i = 1; i<=numPlayers; i++)//Draw or stand
			{
				System.out.println("Draw or Stand?: ");
				inputString = scanner.next();
				switch (inputString)
				{
					case ("draw"): 		players.get(i).getPlayerHand().addToHand((Card)deck.pop());
					case ("stand"): 	break;
					default: 			System.out.println("Please enter draw or stand:");
										i--;//don't go to next player
										break;
				}
 
			}
		}
		
	}
	public void Setup()
	{
		for (int i = 1; i<=numPlayers; i++)
		{
			players.add(new Player(i));
		}
		//deck.randomize();
		for (int i = 1; i <=2; i++)
		{
			for (int j = 0; j <numPlayers; j++)
			{
				players.get(j).getPlayerHand().addToHand((Card)deck.pop());
			}
		}
		round++;//set round to 1(first betting)
	
	}

}
