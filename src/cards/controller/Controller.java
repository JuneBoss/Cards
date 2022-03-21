package cards.controller;



import cards.model.Deck;
public class Controller
{

	private Deck Ldeck;
	private Deck Rdeck;
	private Deck Lpile1;
	private Deck Rpile1;
	private char Ltemp;
	private char Rtemp;
	
	public Controller()
	{
	
	this.Ldeck = new Deck(false, false);
	this.Rdeck = new Deck(true, false);
	this.Lpile1 = new Deck(true, false);
	this.Rpile1 = new Deck(true, false);
		
	}
	
	public void start()
	{
		Ldeck.shuffle();
		Rdeck.add(Ldeck.split());
		System.out.println(Ldeck.getContents());
		System.out.println(Rdeck.getContents());
		
		Lpile1.add(Ldeck.draw());
		Rpile1.add(Rdeck.draw());
		
		System.out.println("Left: " + Lpile1.getContents());
		System.out.println("Right: " + Rpile1.getContents());
		
		Ltemp = Lpile1.peek().charAt(0);
		Rtemp = Rpile1.peek().charAt(0);
		
		System.out.println(Ltemp + " " + Rtemp);
	}
	
	public int battle(char left, char right)
	{
		int outcome = 0;
		
		switch (left)
		{
		case '2':
			if(right == 'A' || right == 'K' || right == 'Q')
			{
				outcome = 1;
			}
			else if (right == '2')
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case '3':
			if(right == '2' || right == 'A' || right == 'K')
			{
				outcome = 1;
			}
			else if (right == '3')
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case '4':
			if(right == '2' || right == '3' || right == 'A')
			{
				outcome = 1;
			}
			else if(right == '4')
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case '5':
			if(right == '2' || right == '3' || right == '4')
			{
				outcome = 1;
			}
			else if(right == '5')
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case '6':
			if(right == '2' || right == '3' || right == '4' || right == '5')
			{
				outcome = 1;
			}
			else if(right == '6')
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case '7':
			if(right == '2' || right == '3' || right == '4' || right == '5' || right == '6')
			{
				outcome = 1;
			}
			else if(right == '7')
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case '8':
			if(right == '2' || right == '3' || right == '4' || right == '5' || right == '6' || right == '7')
			{
				outcome = 1;
			}
			else if(right == '8')
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case '9':
			if(right == '1' || right == 'J' || right == 'Q' || right == 'K' || right == 'A')
			{
				outcome = 2;
			}
			else if(right == '9')
			{
				outcome = 3;
			}
			else
			{
				outcome = 1;
			}
			break;
		case '1':
			if(right == 'J' || right == 'Q' || right == 'K' || right == 'A')
			{
				outcome = 2;
			}
			else if(right == '1')
			{
				outcome = 3;
			}
			else
			{
				outcome = 1;
			}
			break;
		case 'J':
			if(right == 'Q' || right == 'K' || right == 'A')
			{
				outcome = 2;
			}
			else if(right == 'J')
			{
				outcome = 3;
			}
			else
			{
				outcome = 1;
			}
			break;
		case 'Q':
			if(right == 'K' || right == 'A' || right == '2')
			{
				outcome = 2;
			}
			else if(right == 'Q')
			{
				outcome = 3;
			}
			else
			{
				outcome = 1;
			}
			break;
		case 'K':
			if(right == 'A' || right == '2' || right == '3')
			{
				outcome = 2;
			}
			else if(right == 'K')
			{
				outcome = 3;
			}
			else
			{
				outcome = 1;
			}
			break;
		case 'A':
			if(right == '2' || right == '3' || right == '4')
			{
				outcome = 2;
			}
			else if(right == 'A')
			{
				outcome = 3;
			}
			else
			{
				outcome = 1;
			}
			break;
		}
		
		return outcome;
	}
}