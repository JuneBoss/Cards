package cards.model;

import java.util.ArrayList;
import java.util.Collections;

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
		else if(jokers)
		{
			this.contents = new ArrayList()
					{{
						add("AS"); add("2S"); add("3S"); add("4S"); add("5S"); add("6S"); add("7S"); add("8S"); add("9S"); add("1S"); add("JS"); add("QS"); add("KS");
						add("AD"); add("2D"); add("3D"); add("4D"); add("5D"); add("6D"); add("7D"); add("8D"); add("9D"); add("1D"); add("JD"); add("QD"); add("KD");
						add("AC"); add("2C"); add("3C"); add("4C"); add("5C"); add("6C"); add("7C"); add("8C"); add("9C"); add("1C"); add("JC"); add("QC"); add("KC");
						add("AH"); add("2H"); add("3H"); add("4H"); add("5H"); add("6H"); add("7H"); add("8H"); add("9H"); add("1H"); add("JH"); add("QH"); add("KH");
						add("BJ"); add("RJ");
					}};
		}
		else
		{
			this.contents = new ArrayList()
					{{
						add("AS"); add("2S"); add("3S"); add("4S"); add("5S"); add("6S"); add("7S"); add("8S"); add("9S"); add("1S"); add("JS"); add("QS"); add("KS");
						add("AD"); add("2D"); add("3D"); add("4D"); add("5D"); add("6D"); add("7D"); add("8D"); add("9D"); add("1D"); add("JD"); add("QD"); add("KD");
						add("AC"); add("2C"); add("3C"); add("4C"); add("5C"); add("6C"); add("7C"); add("8C"); add("9C"); add("1C"); add("JC"); add("QC"); add("KC");
						add("AH"); add("2H"); add("3H"); add("4H"); add("5H"); add("6H"); add("7H"); add("8H"); add("9H"); add("1H"); add("JH"); add("QH"); add("KH");
					}};
		}
	}
	
	public ArrayList<String> getContents()
	{	
		return this.contents;
	}
	
	public void shuffle()
	{
		Collections.shuffle(this.contents);
	}
}
