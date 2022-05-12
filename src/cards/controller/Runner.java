package cards.controller;

import cards.controller.Controller;

public class Runner
{
	/**
	 * makes the program run
	 * @param args
	 */
	public static void main (String [] args)
	{
		Controller app = new Controller();
		app.start();
	}
}