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
		}
		
		return outcome;
	}
}