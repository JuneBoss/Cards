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
}