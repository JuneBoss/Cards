package cards.controller;

import cards.model.Deck;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import cards.view.CardsFrame;

public class Controller
{
	/**
	 * an instance of deck used to hold the cards in the Left deck
	 */
	private Deck Ldeck;
	/**
	 * an instance of deck used to hold the cards in the right deck
	 */
	private Deck Rdeck;
	/**
	 * an instance of deck used to hold the cards in the discard
	 */
	private Deck Discard;
	/**
	 * an instance of deck used to hold the cards in the top left pile
	 */
	private Deck Lpile1;
	/**
	 * an instance of deck used to hold the cards in the top right pile
	 */
	private Deck Rpile1;
	/**
	 * an instance of deck used to hold the cards in the middle left pile
	 */
	private Deck Lpile2;
	/**
	 * an instance of deck used to hold the cards in the middle right pile
	 */
	private Deck Rpile2;
	/**
	 * an instance of deck used to hold the cards in the bottom left pile
	 */
	private Deck Lpile3;
	/**
	 * an instance of deck used to hold the cards in the bottom right pile
	 */
	private Deck Rpile3;
	/**
	 * an instance of cardsFrame 
	 */
	private CardsFrame frame;
	/**
	 * A string representing the datafile
	 */
	private String dataFile;
	/**
	 * an arraylist used to store the saved data
	 */
	private ArrayList<String> contents;
	
	/**
	 * initializes all the values
	 */
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
	this.frame = new CardsFrame(this);
	this.dataFile = new String("save.cards");
	this.contents = new ArrayList<String>();
	}
	 /**
	  * sets up the game
	  */
	public void start()
	{
		Ldeck.shuffle();
		Rdeck.add(Ldeck.split());
		
	}
	 
	/**
	 * checks if the game is over
	 * @return
	 * returns true or false based on if the game is over or not
	 */
	public Boolean checkOver()
	{
		Boolean over = false;
		
		if(Lpile1.peek() == "XX" && Lpile2.peek() == "XX" && Lpile3.peek() == "XX")
		{
			over = true;
		}
		else if(Rpile1.peek() == "XX" && Rpile2.peek() == "XX" && Rpile3.peek() == "XX")
		{
			over = true;
		}
		
		return over;
	}
	
	/**
	 * a method to save the contents of the discard pile
	 */
	public void save()
	{
		contents.addAll(Discard.getContents());
		IOController.saveData(dataFile, frame, contents);
	}
	
	/**
	 * a method to load the saved contents of a discard pile
	 */
	public void load()
	{
		ArrayList<String> loadList = IOController.loadData(dataFile, frame);
		JOptionPane.showMessageDialog(null, loadList);
	}
	
	/**
	 * determines the outcome of the game
	 * @return
	 * returns a string detailing the winner
	 */
	public String whoWins()
	{
		String winner = "";
		
		if(Ldeck.checkSize() == 0 && Rdeck.checkSize() == 0)
		{
			winner = "Tie";
		}
		else if(Ldeck.checkSize() == 0)
		{
			winner = "Right";
		}
		else if(Rdeck.checkSize() == 0)
		{
			winner = "Left";
		}
		
		return winner;
	}
	
	/**
	 * checks the size of the left deck
	 * @return
	 * the number of cards left in the deck
	 */
	public int LdeckSize()
	{
		int size = Ldeck.checkSize();
		return size;
	}
	
	/**
	 * checks the top card of the left deck
	 * @return
	 * the value of the top card
	 */
	public String peekLeft()
	{
		String peek = Ldeck.peek();
		return peek;
	}
	
	/**
	 * checks the size of the right deck
	 * @return
	 * the number of cards left in the deck
	 */
	public int RdeckSize()
	{
		int size = Rdeck.checkSize();
		return size;
	}
	
	/**
	 * checks the three rows for the empty cards
	 * @return
	 * returns a string containing 1,2, and/or 3 based on if the rows have empty cards in them
	 */
	public String checkEmpty()
	{
		String check = "";
	
			if(Lpile1.peek() == "XX" || Rpile1.peek() == "XX")
			{
				check += "1";
			}
			if(Lpile2.peek() == "XX" || Rpile2.peek() == "XX")
			{
				check += "2";
			}
			if(Lpile3.peek() == "XX" || Rpile3.peek() == "XX")
			{
				check += "3";
			}
		
		return check;
	}
	
	/**
	 * checks the left values to determine which ones have cards or not
	 * @return
	 * returns a string with 1,2,and/or 3 based on what rows on the left side are empty
	 */
	public String checkLeft()
	{
		String check = "";
		
		if(Lpile1.checkSize() == 0)
		{
			check += "1";
		}
		if(Lpile2.checkSize() == 0)
		{
			check += "2";
		}
		if(Lpile3.checkSize() == 0)
		{
			check += "3";
		}
		
		return check;
	}
	
	/**
	 * checks the right values to determine which ones have cards or not
	 * @return
	 * returns a string containing 1.2.and/or 3 based on what right rows are empty
	 */
	public String checkRight()
	{
		String check = "";
		
		if(Rpile1.checkSize() == 0)
		{
			check += "1";
		}
		if(Rpile2.checkSize() == 0)
		{
			check += "2";
		}
		if(Rpile3.checkSize() == 0)
		{
			check += "3";
		}
		
		return check;
	}
	
	/**
	 * fills a selected value with empty cards
	 * @param location
	 * the location of the empty placement
	 */
	public void emptyPlace(String location)
	{
		switch(location)
		{
		case "L1":
			if(Lpile1.checkSize() != 0)
			{
				Ldeck.add(Lpile1.draw());
			}
			Lpile1.add("XX");
			break;
		case "L2":
			if(Lpile2.checkSize() != 0)
			{
				Ldeck.add(Lpile2.draw());
			}
			Lpile2.add("XX");
			break;
		case "L3":
			if(Lpile3.checkSize() != 0)
			{
				Ldeck.add(Lpile3.draw());
			}
			Lpile3.add("XX");
			break;
		case "R1":
			if(Rpile1.checkSize() != 0)
			{
				Rdeck.add(Rpile1.draw());
			}
			Rpile1.add("XX");
			break;
		case "R2":
			if(Rpile2.checkSize() != 0)
			{
				Rdeck.add(Rpile2.draw());
			}
			Rpile2.add("XX");
			break;
		case "R3":
			if(Rpile3.checkSize() != 0)
			{
				Rdeck.add(Rpile3.draw());
			}
			Rpile3.add("XX");
			break;
		}
	}
	
	/**
	 * checks if all piles on the board are full
	 * @return
	 * true or false based on if its full or not
	 */
	public boolean boardFull()
	{
		boolean full = true;
		
		if(!leftFull())
		{
			full = false;
		}
		if(!rightFull())
		{
			full = false;
		}
		
		return full;
	}
	
	/**
	 * checks if the left piles are all full
	 * @return
	 * true or false based on if its full or not
	 */
	public boolean leftFull()
	{
		boolean full = true;
		
		if(Lpile1.checkSize() == 0)
		{
			full = false;
		}
		if(Lpile2.checkSize() == 0)
		{
			full = false;
		}
		if(Lpile3.checkSize() == 0)
		{
			full = false;
		}
		
		return full;
	}
	
	/**
	 * checks if the right piles are all full
	 * @return
	 * returns true or false based on if its full or not
	 */
	public boolean rightFull()
	{
		boolean full = true;
		
		if(Rpile1.checkSize() == 0)
		{
			full = false;
		}
		if(Rpile2.checkSize() == 0)
		{
			full = false;
		}
		if(Rpile3.checkSize() == 0)
		{
			full = false;
		}
		
		return full;
	}
	
	/**
	 * places a card at a given location
	 * @param pile
	 * the chosen pile to place a card in
	 * @return
	 * the value of the card placed
	 */
	public String placement(String pile)
	{
		String card = "";
		
		switch(pile)
		{
		case "L1":
			card = Ldeck.peek();
			Lpile1.add(Ldeck.draw());
			break;
		case "L2":
			card = Ldeck.peek();
			Lpile2.add(Ldeck.draw());
			break;
		case "L3":
			card = Ldeck.peek();
			Lpile3.add(Ldeck.draw());
			break;
		case "R1":
			card = Rdeck.peek();
			Rpile1.add(Rdeck.draw());
			break;
		case "R2":
			card = Rdeck.peek();
			Rpile2.add(Rdeck.draw());
			break;
		case "R3":
			card = Rdeck.peek();
			Rpile3.add(Rdeck.draw());
		}
		
		return card;
		
	}
	
	/**
	 * uses the results from victor to remove cards of a given row
	 * @param row
	 * the row effected
	 * @return
	 * the result of the chosen fight
	 */
	public String combat(int row)
	{
		String result = "";
		
		if(row == 1)
		{
			result = victor(Lpile1.peek(), Rpile1.peek());
			if(result == "Left")
			{
				Discard.add(Rpile1.draw());
			}
			else if(result == "Right")
			{
				Discard.add(Lpile1.draw());
			}
			else if (result == "Tie")
			{
				Discard.add(Lpile1.draw());
				Discard.add(Rpile1.draw());
			}
		}
		else if(row == 2)
		{
			result = victor(Lpile2.peek(), Rpile2.peek());
			if(result == "Left")
			{
				Discard.add(Rpile2.draw());
			}
			else if(result == "Right")
			{
				Discard.add(Lpile2.draw());
			}
			else if (result == "Tie")
			{
				Discard.add(Lpile2.draw());
				Discard.add(Rpile2.draw());
			}
		}
		else if(row == 3)
		{
			result = victor(Lpile3.peek(), Rpile3.peek());
			if(result == "Left")
			{
				Discard.add(Rpile3.draw());
			}
			else if(result == "Right")
			{
				Discard.add(Lpile3.draw());
			}
			else if (result == "Tie")
			{
				Discard.add(Lpile3.draw());
				Discard.add(Rpile3.draw());
			}
		}
		return result;
	}
	
	/**
	 * Takes two strings and uses the result of the battle method to return a string describing the outcome
	 * @param left
	 * a string value representing a card
	 * @param right
	 * a string value representing a card
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