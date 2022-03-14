package cards.controller;

import java.util.ArrayList;
import java.util.Collections;
import cards.model.Deck;
public class Controller
{

	private Deck deck;
	private ArrayList <String> hand;
	
	public Controller()
	{
	
	this.deck = new Deck(false, true);
	
	System.out.print(deck.getContents());
	deck.shuffle();
	System.out.println();
	System.out.print(deck.getContents());
		
		
	
		
	}
	
	public void start()
	{
	
	}
}