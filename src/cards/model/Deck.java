package cards.model;

import java.util.ArrayList;

public class Deck
{
	private Boolean jokers;
	private Boolean empty;
	private ArrayList<String> contents;

	
	public Deck(Boolean empty, Boolean jokers)
	{
		if(empty)
		{
			this.contents = new ArrayList()
					{{
						
					}};
		}
	}
}
