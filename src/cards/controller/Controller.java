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
	
	System.out.println(deck.getContents());
	deck.shuffle();
	System.out.println(deck.getContents());
	
	
	hand.add(deck.draw(3));
	System.out.println(hand.getContents());
	System.out.println(deck.getContents());
		
	}
	
	public void start()
	{
	
	}
}