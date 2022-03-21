package cards.controller;

import java.util.ArrayList;
import java.util.Collections;
import cards.model.Deck;
public class Controller
{

	private Deck deck;
	private Deck hand;
	
	public Controller()
	{
	
	this.deck = new Deck(false, true);
	this.hand = new Deck(true, false);
		
	}
	
	public void start()
	{
		System.out.println(deck.getContents());
		deck.shuffle();
		System.out.println(deck.getContents());
		
		
		//hand.add(deck.draw(3));
		//System.out.println(hand.getContents());
		//System.out.println(deck.getContents());
		
		//deck.shuffle();
		//System.out.println(deck.getContents());
		System.out.println(deck.checkSize() / 2);
		hand.add(deck.split());
		System.out.println(deck.checkSize());
		System.out.println(deck.checkSize());
		System.out.println(deck.getContents());
		System.out.println(hand.getContents());
		
	}
	
	public int battle(String left, String right)
	{
		int outcome = 0;
		
		switch (left)
		{
		case "2":
			if(right == "A" || right == "K" || right == "Q")
			{
				outcome = 1;
			}
			else if (right == "2")
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case "3":
			if(right == "2" || right == "A" || right == "K")
			{
				outcome = 1;
			}
			else if (right == "3")
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case "4":
			if(right == "2" || right == "3" || right == "A")
			{
				outcome = 1;
			}
			else if(right == "4")
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case "5":
			if(right == "2" || right == "3" || right == "4")
			{
				outcome = 1;
			}
			else if(right == "5")
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case "6":
			if(right == "2" || right == "3" || right == "4" || right == "5")
			{
				outcome = 1;
			}
			else if(right == "6")
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case "7":
			if(right == "2" || right == "3" || right == "4" || right == "5" || right == "6")
			{
				outcome = 1;
			}
			else if(right == "7")
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case "8":
			if(right == "2" || right == "3" || right == "4" || right == "5" || right == "6" || right == "7")
			{
				outcome = 1;
			}
			else if(right == "8")
			{
				outcome = 3;
			}
			else
			{
				outcome = 2;
			}
			break;
		case "9":
			if(right == "1" || right == "J" || right == "Q" || right == "K" || right == "A")
			{
				outcome = 2;
			}
			else if(right == "9")
			{
				outcome = 3;
			}
			else
			{
				outcome = 1;
			}
			break;
		case "1":
			if(right == "J" || right == "Q" || right == "K" || right == "A")
			{
				outcome = 2;
			}
			else if(right == "1")
			{
				outcome = 3;
			}
			else
			{
				outcome = 1;
			}
			break;
		case "J":
			if(right == "Q" || right == "K" || right == "A")
			{
				outcome = 2;
			}
			else if(right == "J")
			{
				outcome = 3;
			}
			else
			{
				outcome = 1;
			}
			break;
		case "Q":
			if(right == "K" || right == "A" || right == "2")
			{
				outcome = 2;
			}
			else if(right == "Q")
			{
				outcome = 3;
			}
			else
			{
				outcome = 1;
			}
			break;
		case "K":
			if(right == "A" || right == "2" || right == "3")
			{
				outcome = 2;
			}
			else if(right == "K")
			{
				outcome = 3;
			}
			else
			{
				outcome = 1;
			}
			break;
		case "A":
			if(right == "2" || right == "3" || right == "4")
			{
				outcome = 2;
			}
			else if(right == "A")
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