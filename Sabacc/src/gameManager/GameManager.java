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
	boolean flip = false; //track if player has flipped
	
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
									break;
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
			
			for (int i = 0; i<=numPlayers-1; i++)//Draw or stand
			{
				players.get(i).getPlayerHand().printHand();
				System.out.print("Draw or Stand?: ");
				inputString = scanner.next();
				switch (inputString)
				{
					case ("draw"): 		players.get(i).getPlayerHand().addToHand(deck.draw());
										break;
										
					case ("stand"): 	break;
					default: 			System.out.println("Please enter draw or stand");
										i--;//don't go to next player
										break;
				}
 
			}
		}
		while (flip != true)
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
									break;
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
			
			for (int i = 0; i<=numPlayers-1; i++)//Draw or stand
			{
				players.get(i).getPlayerHand().printHand();
				System.out.print("Draw, Stand, or Flip?: ");
				inputString = scanner.next();
				switch (inputString)
				{
					case ("draw"): 		players.get(i).getPlayerHand().addToHand(deck.draw());
										break;	
					case ("stand"): 	break;
					case ("flip"):		flip = true;
										processFlip(i);
										break;
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
	public void processFlip(int player)
	{
		int winner = player;
		boolean sabacc = false;
		for (int i = 0; i < players.size(); i++)
		{
			if (players.get(player).getPlayerFold() == true)
			{
				players.get(player).getPlayerHand().setValue(0);				
			}
			else
			{
				players.get(player).getPlayerHand().printHand();
				if(players.get(player).getPlayerHand().getValue() > 23 || players.get(player).getPlayerHand().getValue() < -23)
				{
					System.out.println("Player " + player+1 + " busted");
				}
				else if (players.get(player).getPlayerHand().getValue() == 23 || players.get(player).getPlayerHand().getValue() == -23)
				{
					System.out.println("Player " + player+1 + " has pure Sabacc!");
					winner = player;
					sabacc = true;
				}
				else if (players.get(player).getPlayerHand().getValue() > players.get(winner).getPlayerHand().getValue())
				{
					winner = player;
				}
			}
			if(player > players.size())
			{
				player = 0;
			}
		}
		System.out.println("Player " + player+1 + " has won");
		players.get(winner).setPlayerCredits(players.get(winner).getPlayerCredits() + mainPot);
		mainPot = 0;
		if(sabacc == true)
		{
			players.get(winner).setPlayerCredits(players.get(winner).getPlayerCredits() + sabaccPot);
			sabaccPot = 0;
		}
	}

}
