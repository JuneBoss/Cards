package cards.controller;

import cards.model.Deck;
import java.util.Scanner;
import cards.view.CardsFrame;

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
	private Deck Choice;
	private Scanner input;
	private CardsFrame frame;
	
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
	this.Choice = new Deck(true, false);
	this.input = new Scanner(System.in);
	this.frame = new CardsFrame(this);
	}
	
	public void start()
	{
		Boolean over = false;
		Ldeck.shuffle();
		Rdeck.add(Ldeck.split());
		/*
		while(!over)
		{
			placement();
			removal();
			
			System.out.println("left has " + Ldeck.checkSize() + " cards remaining");
			System.out.println("right has " + Rdeck.checkSize() + " cards remaining");
			
			if(Ldeck.checkSize() == 0 && Lpile1.peek() == "XX" && Lpile2.peek() == "XX" && Lpile3.peek() == "XX")
			{
				System.out.println("Right wins, better luck next time");
				over = true;
			}
			else if(Rdeck.checkSize() == 0 && Rpile1.peek() == "XX" && Rpile2.peek() == "XX" && Rpile3.peek() == "XX")
			{
				System.out.println("Left wins, good job");
				over = true;
			}
		}
		*/
		
		
	}
	
	public void removal()
	{
		String round1 = victor(Lpile1.peek(), Rpile1.peek());
		String round2 = victor(Lpile2.peek(), Rpile2.peek());
		String round3 = victor(Lpile3.peek(), Rpile3.peek());
		if(round1 == "Left")
		{
			Discard.add(Rpile1.draw());
			System.out.println("Left wins row 1");
		}
		else if (round1 == "Right")
		{
			Discard.add(Lpile1.draw());
			System.out.println("Right wins row 1");
		}
		else if (round1 == "Tie")
		{
			Discard.add(Lpile1.draw());
			Discard.add(Rpile1.draw());
			System.out.println("Its a tie, they both die");
		}
		
		if(round2 == "Left")
		{
			Discard.add(Rpile2.draw());
			System.out.println("Left wins row 2");
		}
		else if (round2 == "Right")
		{
			Discard.add(Lpile2.draw());
			System.out.println("Right wins row 2");
		}
		else if (round2 == "Tie")
		{
			Discard.add(Lpile2.draw());
			Discard.add(Rpile2.draw());
			System.out.println("Its a tie, they both die");
		}
		
		if(round3 == "Left")
		{
			Discard.add(Rpile3.draw());
			System.out.println("Left wins row 3");
		}
		else if (round3 == "Right")
		{
			Discard.add(Lpile3.draw());
			System.out.println("Right wins row 3");
		}
		else if (round3 == "Tie")
		{
			Discard.add(Lpile3.draw());
			Discard.add(Rpile3.draw());
			System.out.println("Its a tie, they both die");
		}
	}
	
	public void display()
	{
		String one = "";
		String two = "";
		String three = "";
		
		one = "Left 1 : " + Lpile1.getContents() + " Right 1 : " + Rpile1.getContents();
		two = "Left 2 : " + Lpile2.getContents() + " Right 2 : " + Rpile2.getContents();
		three = "Left 3 : " + Lpile3.getContents() + " Right 3 : " + Rpile3.getContents();
		
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
	}
	
	public void emptyPlace()
	{
		if(Lpile1.checkSize() == 0)
		{
			Lpile1.add("XX");
			if(Rpile1.checkSize() != 0)
			{
				if(Rpile1.peek() != "XX")
				{
					Rdeck.add(Rpile1.draw());
					Rpile1.add("XX");
				}
			}
			else if (Rpile1.checkSize() == 0)
			{
				Rpile1.add("XX");
			}
		}
		
		else if(Lpile2.checkSize() == 0)
		{
			Lpile2.add("XX");
			if(Rpile2.checkSize() != 0)
			{
				if(Rpile2.peek() != "XX")
				{
					Rdeck.add(Rpile2.draw());
					Rpile2.add("XX");
				}
			}
			else if (Rpile2.checkSize() == 0)
			{
				Rpile2.add("XX");
			}
		}
		
		else if (Lpile3.checkSize() == 0)
		{
			Lpile3.add("XX");
			if(Rpile3.checkSize() != 0)
			{
				if(Rpile3.peek() != "XX")
				{
					Rdeck.add(Rpile3.draw());
					Rpile3.add("XX");
				}
			}
			else if (Rpile3.checkSize() == 0)
			{
				Rpile3.add("XX");
			}
		}
	}
	
	public void placement()
	{
		if(Rpile1.checkSize() == 0)
		{
			if(Rdeck.checkSize() == 0)
			{
				Rpile1.add("XX");
				if(Lpile1.checkSize() != 0)
				{
					if(Lpile1.peek() != "XX")
					{
						Ldeck.add(Lpile1.draw());
						Lpile1.add("XX");
					}
				}
				else if (Lpile1.checkSize() == 0)
				{
					Lpile1.add("XX");
				}
			}
			else
			{
			Rpile1.add(Rdeck.draw());
			}
		}
		
		if(Lpile1.checkSize() == 0 || Lpile2.checkSize() == 0 || Lpile3.checkSize() == 0)
		{
			if(Ldeck.checkSize() == 0)
			{
				emptyPlace();
			}
			else
			{
			display();
			cardSelect(Ldeck.draw());
			}
		}
		
		if(Rpile2.checkSize() == 0)
		{
			if(Rdeck.checkSize() == 0)
			{
				Rpile2.add("XX");
				if(Lpile2.checkSize() != 0)
				{
					if(Lpile2.peek() != "XX")
					{
						Ldeck.add(Lpile2.draw());
						Lpile2.add("XX");
					}
				}
				else if (Lpile2.checkSize() == 0)
				{
					Lpile2.add("XX");
				}
			}
			else
			{
			Rpile2.add(Rdeck.draw());
			}
		}
		
		if(Lpile1.checkSize() == 0 || Lpile2.checkSize() == 0 || Lpile3.checkSize() == 0)
		{
			if(Ldeck.checkSize() == 0)
			{
				emptyPlace();
			}
			else
			{
			display();
			cardSelect(Ldeck.draw());
			}
		}
		
		if(Rpile3.checkSize() == 0)
		{
			if(Rdeck.checkSize() == 0)
			{
				Rpile3.add("XX");
				if(Lpile3.checkSize() != 0)
				{
					if(Lpile3.peek() != "XX")
					{
						Ldeck.add(Lpile3.draw());
						Lpile3.add("XX");
					}
				}
				else if (Lpile3.checkSize() == 0)
				{
					Lpile3.add("XX");
				}
			}
			else
			{
			Rpile3.add(Rdeck.draw());
			}
		}
		
		if(Lpile1.checkSize() == 0 || Lpile2.checkSize() == 0 || Lpile3.checkSize() == 0)
		{
			if(Ldeck.checkSize() == 0)
			{
				emptyPlace();
			}
			else
			{
			display();
			cardSelect(Ldeck.draw());
			}
		}
	}
	
	public void cardSelect(String card)
	{
		String choices = "You may place the card " + card + " at ";
		int choice = 0;
		Boolean done = false;
		
		if(Lpile1.checkSize() == 0)
		{
			choices += "1, ";
		}
		if(Lpile2.checkSize() == 0)
		{
			choices += "2, ";
		}
		if(Lpile3.checkSize() == 0)
		{
			choices += "3";
		}
		
		System.out.println(choices);
		while(!done)
		{
		choice = input.nextInt();
		
		if(choice == 1 && Lpile1.checkSize() == 0)
		{
			Lpile1.add(card);
			done = true;
		}
		else if (choice == 2 && Lpile2.checkSize() == 0)
		{
			Lpile2.add(card);
			done = true;
		}
		else if (choice == 3 && Lpile3.checkSize() == 0)
		{
			Lpile3.add(card);
			done = true;
		}
		else
		{
			System.out.println("Please enter an appropriate value");
		}
		}
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
			else if (right == 'X')
			{
				outcome = 4;
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
			else if (right == 'X')
			{
				outcome = 4;
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
			else if (right == 'X')
			{
				outcome = 4;
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
			else if (right == 'X')
			{
				outcome = 4;
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
			else if (right == 'X')
			{
				outcome = 4;
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
			else if (right == 'X')
			{
				outcome = 4;
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
			else if (right == 'X')
			{
				outcome = 4;
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
			else if (right == 'X')
			{
				outcome = 4;
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
			else if (right == 'X')
			{
				outcome = 4;
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
			else if (right == 'X')
			{
				outcome = 4;
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
			else if (right == 'X')
			{
				outcome = 4;
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
			else if (right == 'X')
			{
				outcome = 4;
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
			else if (right == 'X')
			{
				outcome = 4;
			}
			else
			{
				outcome = 1;
			}
			break;
		case 'X':
			outcome = 4;
			break;
		default:
			outcome = 4;
		}
		
		return outcome;
	}
}