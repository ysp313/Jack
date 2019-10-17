
import java.util.Random; //outil Random qui sert à faire des tirages au sort
import java.util.Scanner; //outil pour pouvoir créer des "input" (choix du joueur)
/*
 * Classe Play 
 * Permet de jouer au BlackJack
 */
class  Play 
{
	public static int pick(int[] cardValor)
	{
		Random generator = new Random();

		//Je veux un entier entre [0 et 51[ ou entre 0 inclus et 52 exclus
			int index; 
			int value;
			index = generator.nextInt(cardValor.length);
				while (cardValor[index] == 0) // tant que la valeur de la carte a déja été piochée
				{
				index ++;
					if (index > 51)
					{
						index = 0;
					}
				}	
			value = cardValor[index];
			cardValor[index] = 0;
			return value;
	}
	public static boolean restart()
		{
			Scanner userRestart =new Scanner(System.in); // initialisation du scanner
			String choice; // valeur

			System.out.println("Tapez oui ou alors non");
			choice = userRestart.next();  
			choice = choice.toLowerCase(); // enlève les majuscules

			//Boucle tant que le joueur ne tape pas le bon mot
			while(!choice.equals("oui") && !choice.equals("non"))
			{
				System.out.println("Merci de taper oui ou non ");
				choice = userRestart.next();
				choice = choice.toLowerCase();
			}
			return choice.equals("oui");
		}

	public static boolean choice()
		{
			Scanner userChoice = new Scanner(System.in);// initialisation du scanner
			String choice; // définition de la variable

			System.out.println("Tapez oui ou alors non");
			choice = userChoice.next();  
			choice = choice.toLowerCase(); // enlève les majuscules

			//Boucle tant que le joueur ne tape pas le bon mot
			while(!choice.equals("oui") && !choice.equals("non"))
			{
				System.out.println("Merci de taper oui ou non ");
				choice = userChoice.next();
				choice = choice.toLowerCase();
			}
			return choice.equals("oui");
		}

	public static void main(String[] args)
	{
		System.out.println("welcome to JackJAck !"); //Message d'acceuil

		//création du jeu de carte et de la valeur des cartes
		int[] cardGame = 
		{
			1,2,3,4,5,6,7,8,9,10,10,10,10,1,2,3,4,5,6,7,8,9,10,10,10,
			10,1,2,3,4,5,6,7,8,9,10,10,10,10,1,2,3,4,5,6,7,8,9,10,10,10,10 //10 = valet, dame, roi
		};
		
		// Annonce Player
		System.out.println("Vos deux premières cartes sont");

		// Premère carte joueur
		int card = pick(cardGame);
			if (card == 1)
				{
				card = 11;
				}
		int playerHand = card;
		System.out.println("première carte: "+card);

		//Deuxième carte joueur
		card = pick(cardGame);
			if (card == 1)
			{	
				if ( playerHand <= 10)
				{
					 card = 11;
				}
				else 
				{
					card = 1;
				}
			}
		System.out.println("Deuxième carte: "+card);

		playerHand = playerHand + card;
		System.out.println("Votre total est de : "+playerHand);
		if (playerHand == 21)
			{
				System.out.println("BLACKJACK !! Vous avez gagné");
				System.out.println("Voulez vous recommencer une partie?");

				if (restart())
				{
					 new Play();
				}
				else
				{
					System.exit(1);
				}

			}

		System.out.println("--------------------------"); //Séparateur

		// Annonce Bank
		System.out.println("La banque a les cartes suivantes");

		// Premère carte bank
		card = pick(cardGame);
			if (card == 1)
				{
				card = 11;
				}
		int bankHand = card;
		System.out.println("Première carte : Celle-ci n'est pas visible");

		//Deuxième carte bank
		card = pick(cardGame);
			if (card == 1)
			{	
				if ( bankHand <= 10)
				{
					card = 11;
				}
				else 
				{
					card = 1;
				}
			}
		System.out.println("Deuxième carte: "+card);

		bankHand = bankHand + card;
			if (bankHand == 21)
			{
				System.out.println("ET.... BLACKJACK !! La banque gagne");
				System.out.println("Voulez vous recommencer une partie?");

				if (restart())
				{
					 new Play();
				}
				else
				{
					System.exit(1);
				}
			}

		System.out.println("--------------------------"); //Séparateur

		// Choix du joueur
		System.out.println("Touti touti ladadada, Voulez-vous piochez une nouvelle carte?");

		if (choice())
		{
			card = pick(cardGame);
			System.out.println("Troisème carte: "+card);
			playerHand = playerHand + card;
			System.out.println("Votre nouveau total est :"+playerHand);
			if (playerHand == 21)
			{
				System.out.println("ET.... BLACKJACK !! Vous avez gagné");
				System.out.println("Voulez vous recommencer une partie?");

				if (restart())
				{
					 new Play();
				}
				else
				{
					System.exit(1);
				}
			}
			if (playerHand > 21)
			{
				System.out.println("Vous avez "+playerHand+", vous perdez !");
				System.out.println("Voulez vous recommencer une partie?");

				if (restart())
				{
					 new Play();
				}
				else
				{
					System.exit(1);
				}
			}

		}
		else
		{
			System.out.println("Vous ne voulez pas de nouvelle carte");
		}
		
		// Choix de la banque

		if (bankHand < 17)
		{
			card = pick(cardGame);
			if (card == 1)
			{	
				if ( bankHand <= 10)
				{
					card = 11;
				}
				else 
				{
					card = 1;
				}
			}
		}
		System.out.println("La banque tire à nouveau la carte a la valeur: "+card);
		bankHand = bankHand + card;
			if (bankHand == 21)
			{
				System.out.println("ET.... BLACKJACK !! La banque gagne");
			}
			if (bankHand > 21)
			{
				System.out.println("La banque a "+bankHand+", elle perd donc, Vous GAGNEZ !");
			}

		// Choix du joueur 2
		System.out.println("Voulez-vous piochez une nouvelle carte?");

			if (choice())
			{
				card = pick(cardGame);
				System.out.println("Quatrième carte: "+card);
				playerHand = playerHand + card;
				System.out.println("Votre nouveau total est :"+playerHand);
				if (playerHand == 21)
				{
					System.out.println("ET.... BLACKJACK !! Vous avez gagné");
				}
				if (playerHand > 21)
				{
					System.out.println("Vous avez "+playerHand+", vous perdez !");
				}

			}
			else
			{
				System.out.println("Vous ne voulez pas de nouvelle carte");
			}
		
		// Choix de la banque

		if (bankHand < 17)
		{
			card = pick(cardGame);
			if (card == 1)
			{	
				if ( bankHand <= 10)
				{
					card = 11;
				}
				else 
				{
					card = 1;
				}
			}
		System.out.println("La banque tire la carte a la valeur: "+card);
		bankHand = bankHand + card;
			if (bankHand == 21)
			{
				System.out.println("ET.... BLACKJACK !! La banque gagne");
			}
			if (bankHand > 21)
			{
				System.out.println("La banque a "+bankHand+", elle perd donc, Vous GAGNEZ !");
			}
		}

	}
}
