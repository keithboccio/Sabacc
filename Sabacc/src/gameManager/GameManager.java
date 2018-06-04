package gameManager;
import java.util.*;
import gameData.*;

public class GameManager 
{
	Scanner scanner = new Scanner(System.in); //For input from players
	int numPlayers;	//Number of players in the game
	ArrayList<Player> players = new ArrayList(0); //Arraylist of players
	Deck deck = new Deck(); //the deck being used
	int mainPot = 0; //Main pot for the round
	int sabaccPot = 0; //Sabacc pot for the overall game
	int currentBet; //Current bet for the round
	int round = 0; //round counter
	String inputString; //Read in string
	int inputInt; //Read in int
	boolean bet = false; //track if current round has a bet
	
	//Constructor
	public GameManager(int i)
	{
		numPlayers = i;
	}
	
	//Runs the bulk the of game
	public void Run()
	{
		Setup();//setup the hand
		while (round <=4)
		{
			for (int a = 0; a<=numPlayers-1; a++)//betting
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
											break;
							case ("raise"):	System.out.println("Current bet: " + currentBet + " Raise amount: ");
											inputInt = scanner.nextInt();
											currentBet += inputInt;
											mainPot += currentBet;
											players.get(a).setPlayerCredits(players.get(a).getPlayerCredits()-inputInt);
											break;
							case ("fold"):	players.get(a).setPlayerFold(true);
											break;
							default: 		System.out.println("Please enter call or raise or fold: ");
											a--;
											break;
											
						}
						
					}
					else
					{
						//do nothing
					}
				}

			}
			
			for (int i = 1; i<=numPlayers-1; i++)//Draw or stand
			{
				System.out.println("Draw or Stand?: ");
				inputString = scanner.next();
				switch (inputString)
				{
					case ("draw"): 		players.get(i).getPlayerHand().addToHand(deck.draw());
					case ("stand"): 	break;
					default: 			System.out.println("Please enter draw or stand");
										i--;//don't go to next player
										break;
				}
 
			}
		}
		
	}
	
	//Gets the deck and players read for the hand being played
	public void Setup()
	{
		for (int i = 0; i<=numPlayers-1; i++) //Fill the Arraylist of players
		{
			players.add(new Player(i));
		}
		//deck.randomize();
		for (int i = 1; i <=2; i++) //give they players their starting hands of 2 cards each
		{
			for (int j = 0; j <numPlayers; j++)
			{
				players.get(j).getPlayerHand().addToHand(deck.draw());
			}
		}
		round++;//set round to 1(first betting)
	
	}

}
