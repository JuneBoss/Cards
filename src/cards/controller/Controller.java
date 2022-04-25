package cards.controller;



import cards.model.Deck;
public class Controller
{

	private Deck Ldeck;
	private Deck Rdeck;
	private Deck Discard;
	private Deck Lpile1;
	private Deck Rpile1;
	private Deck Lpile2;
	private Deck Rpile2;
	private Deck Lpile3;
	private Deck Rpile3;
	
	
	public Controller()
	{
	
	this.Ldeck = new Deck(false, false);
	this.Rdeck = new Deck(true, false);
	this.Discard = new Deck(true, false);
	this.Lpile1 = new Deck(true, false);
	this.Rpile1 = new Deck(true, false);
	this.Lpile2 = new Deck(true, false);
	this.Rpile2 = new Deck(true, false);
	this.Lpile3 = new Deck(true, false);
	this.Rpile3 = new Deck(true, false);
		
	}
	
	public void start()
	{
		Ldeck.shuffle();
		Rdeck.add(Ldeck.split());
		System.out.println(Ldeck.getContents());
		System.out.println(Rdeck.getContents());
		
		Lpile1.add(Ldeck.draw());
		Rpile1.add(Rdeck.draw());
		Lpile2.add(Ldeck.draw());
		Rpile2.add(Rdeck.draw());
		Lpile3.add(Ldeck.draw());
		Rpile3.add(Rdeck.draw());
		
		System.out.print("Left 1: " + Lpile1.getContents());
		System.out.println(" Right 1: " + Rpile1.getContents());
		System.out.print("Left 2: " + Lpile2.getContents());
		System.out.println(" Right 2: " + Rpile2.getContents());
		System.out.print("Left 3: " + Lpile3.getContents());
		System.out.println(" Right 3: " + Rpile3.getContents());
		
		System.out.println(victor(Lpile1.peek(), Rpile1.peek()));
		System.out.println(victor(Lpile2.peek(), Rpile2.peek()));
		System.out.println(victor(Lpile3.peek(), Rpile3.peek()));
		
		
		System.out.println(Discard.peek());
	}
	
	
	/**
	 * Takes two strings and uses the result of the battle method to return a string describing the outcome
	 * @param left
	 * @param right
	 * @return returns left, right, or tie based on the result of the battle
	 */
	public String victor(String left, String right)
	{
		String result = "";
		char Ltemp = left.charAt(0);
		char Rtemp = right.charAt(0);
		int outcome = battle(Ltemp, Rtemp);
		
		if(outcome == 1)
		{
			result = "Left";
		}
		else if (outcome == 2)
		{
			result = "Right";
		}
		else if (outcome == 3)
		{
			result = "Tie";
		}
		else
		{
			result = "what?";
		}
		
		return result;
	}
	
	/**
	 * Takes two chars and derives an outcome based on a switch statement
	 * @param left
	 * @param right
	 * @return Returns an int of 1, 2, or 3 based on the results
	 */
	private int battle(char left, char right)
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
		default:
			outcome = 4;
		}
		
		return outcome;
	}
}