package cards.view;

import cards.controller.Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;



public class CardsPanel extends JPanel
{
		/**
		 * A connection to the controller
		 */
		private Controller app;
		/**
		 * a panel to hold Llabel 1-3
		 */
		private JPanel leftPanel;
		/**
		 * a panel to hold Rlabel 1-3
		 */
		private JPanel rightPanel;
		/**
		 * they layout for the gui
		 */
		private SpringLayout layout;
		/**
		 * a button for placing the top left card
		 */
		private JButton Lfield1;
		/**
		 * a button for placing the middle left card
		 */
		private JButton Lfield2;
		/**
		 * a button for placing the bottom left card
		 */
		private JButton Lfield3;
		/**
		 * a label to display the top left card
		 */
		private JLabel Llabel1;
		/**
		 * a label to display the middle left card
		 */
		private JLabel Llabel2;
		/**
		 * a label to display the bottom left card
		 */
		private JLabel Llabel3;
		/**
		 * a label to display the top right card
		 */
		private JLabel Rlabel1;
		/**
		 * a label to display the middle right card
		 */
		private JLabel Rlabel2;
		/**
		 * a label to display the bottom right card
		 */
		private JLabel Rlabel3;
		/**
		 * a label to display the left deck of cards
		 */
		private JLabel Ldeck;
		/**
		 * a label to display the right deck of cards
		 */
		private JLabel Rdeck;
		/**
		 * a button to begin the game
		 */
		private JButton start;
		/**
		 * a button that controls the flow of the game
		 */
		private JButton next;
		/**
		 * a label to display the discard pile
		 */
		private JLabel discard;
		/**
		 * an imageIcon used to change the pictures on the labels
		 */
		private ImageIcon picture;
		/**
		 * an int used to determine the state the games in
		 */
		private int nextControl;
		/**
		 * a string used to determine where in the battle phase the game is in
		 */
		private String battle;
		/**
		 * a label used to display the winner of the game
		 */
		private JLabel title;
		
		/**
		 * initializes the values in the gui
		 * @param app
		 * an instance of the controller
		 */
	public CardsPanel(Controller app)
	{
		super();
		this.app = app;
		
		this.layout = new SpringLayout();
		this.leftPanel = new JPanel();
		this.rightPanel = new JPanel();
		this.Lfield1 = new JButton("L1");
		this.Lfield2 = new JButton("L2");
		this.Lfield3 = new JButton("L3");
		this.Llabel1 = new JLabel("");
		this.Llabel2 = new JLabel("");
		this.Llabel3 = new JLabel("");
		this.Rlabel1 = new JLabel("");
		this.Rlabel2  = new JLabel("");
		this.Rlabel3 = new JLabel("");
		this.Ldeck = new JLabel("");
		this.Rdeck = new JLabel("");
		this.start = new JButton("Start Game");
		this.next = new JButton("put steps here");
		this.discard = new JLabel("");
		this.picture = new ImageIcon();
		this.nextControl = 0;
		this.battle = "";
		this.title = new JLabel("");
		
		
		
		setupPanel();
		setupListeners();
		setupLayout();
	}

	/**
	 * sets up the game and gui
	 */
	private void setupPanel()
	{
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(new Color(54, 89, 74));
		
		
		leftPanel.add(Lfield1);
		leftPanel.add(Llabel1);
		leftPanel.add(Lfield2);
		leftPanel.add(Llabel2);
		leftPanel.add(Lfield3);
		leftPanel.add(Llabel3);
		
		rightPanel.add(Rlabel1);
		rightPanel.add(Rlabel2);
		rightPanel.add(Rlabel3);
		
		this.add(start);
		this.add(next);
		this.add(Ldeck);
		this.add(Rdeck);
		this.add(discard);
		this.add(title);
		
		updateDisplay("", "LD");
		updateDisplay("", "RD");
		updateDisplay("", "DC");
		Lfield1.setVisible(false);
		Lfield2.setVisible(false);
		Lfield3.setVisible(false);
		Llabel1.setForeground(Color.BLACK);
		Llabel1.setBackground(Color.red);
		
		next.setVisible(false);
		
		
		this.add(rightPanel);
		this.add(leftPanel);
	}

	/**
	 * holds the ActionListeners for the game
	 */
	private void setupListeners()
	{
		Lfield1.addActionListener(click -> updateDisplay(drawCard("L1"), "L1"));
		Lfield2.addActionListener(click -> updateDisplay(drawCard("L2"), "L2"));
		Lfield3.addActionListener(click -> updateDisplay(drawCard("L3"), "L3"));
		start.addActionListener(click -> start());
		next.addActionListener(click -> nextButton(nextControl));
	}
	
	/**
	 * a function to access the placement function in the controller, sends a value equivalent to a card drawn in placement
	 * @param pile
	 * the value sent to placement as a parameter, used to determine what pile to draw a card from
	 * @return
	 * returns the value of the card as a string
	 */
	private String drawCard(String pile)
	{
		String card = "";
		
		card = app.placement(pile);
		
		return card;
	}
	
	/**
	 * gets the game in motion
	 */
	private void start()
	{
		next.setText("draw");
		next.setVisible(true);
		start.setVisible(false);
		nextControl = 0;
	}
	
	/**
	 * places a card on the right and allows the player to place a card
	 */
	private void placeBoth()
	{
		int deckSize = 0;
		String available = "";
		if(app.boardFull() == false) 
		{
			if(app.rightFull() == false)
			{
				deckSize = app.RdeckSize();
				available = app.checkRight();
				if(deckSize == 0)
				{
					Rdeck.setVisible(false);
					if(available.contains("1"))
					{
						app.emptyPlace("L1");
						updateDisplay("XX", "L1");
						app.emptyPlace("R1");
						updateDisplay("XX", "R1");
					}
					else if (available.contains("2"))
					{
						app.emptyPlace("L2");
						updateDisplay("XX", "L2");
						app.emptyPlace("R2");
						updateDisplay("XX", "R2");
					}
					else if (available.contains("3"))
					{
						app.emptyPlace("L3");
						updateDisplay("XX", "L3");
						app.emptyPlace("R3");
						updateDisplay("XX", "R3");
					}
				}
				else
				{
					if(available.contains("1"))
					{
						updateDisplay(drawCard("R1"), "R1");
					}
					else if (available.contains("2"))
					{
						updateDisplay(drawCard("R2"), "R2");
					}
					else if (available.contains("3"))
					{
						updateDisplay(drawCard("R3"), "R3");
					}
				}
			}
			if(app.leftFull() == false) 
			{
				deckSize = app.LdeckSize();
				available = app.checkLeft();
				if(deckSize == 0)
				{
					Ldeck.setVisible(false);
					if(available.contains("1"))
					{
						app.emptyPlace("L1");
						updateDisplay("XX", "L1");
						app.emptyPlace("R1");
						updateDisplay("XX", "R1");
					}
					else if (available.contains("2"))
					{
						app.emptyPlace("L2");
						updateDisplay("XX", "L2");
						app.emptyPlace("R2");
						updateDisplay("XX", "R2");
					}
					else if (available.contains("3"))
					{
						app.emptyPlace("L3");
						updateDisplay("XX", "L3");
						app.emptyPlace("R3");
						updateDisplay("XX", "L3");
					}
				}
				else
				{
					updateDisplay(app.peekLeft(), "LD");
					if(available.contains("1"))
					{
						Lfield1.setVisible(true);
					}
					if(available.contains("2"))
					{
						Lfield2.setVisible(true);
					}
					if(available.contains("3"))
					{
						Lfield3.setVisible(true);
					}
					
				}
				
			}
			
		}
	}
	
	/**
	 * controls the speed of the game by tying it to the press of a button
	 * @param control
	 * the phase of the game the next button should be controlling
	 */
	private void nextButton(int control)
	{
		if(control == 0)//placement
		{
			if(app.boardFull() == false)
			{
				placeBoth();
			}
			if(app.boardFull() == true)
			{
				if(app.checkOver()) 
				{
					if(app.whoWins() == "Tie")
					{
						title.setText("WoW a Tie");
					}
					else if(app.whoWins() == "Left")
					{
						title.setText("You Win!");
					}
					else if(app.whoWins() == "Right")
					{
						title.setText("haha you lose");
					}
					next.setText("game over");
					nextControl = 2;
				}
				else
				{
				next.setText("battle");
				nextControl = 1;
				battle = "";
				}
			}
		}
		if(control == 1)//battle
		{
			String result = "";
			battle += app.checkEmpty();
			
			
			if(!battle.contains("1"))
			{
				result = app.combat(1);
				if(result == "Right")
				{
					Llabel1.setText("X");
				}
				else if (result == "Left")
				{
					Rlabel1.setText("X");
				}
				else if (result == "Tie")
				{
					Llabel1.setText("X");
					Rlabel1.setText("X");
				}
				battle += "1";
			}
			else if (!battle.contains("2"))
			{
				result = app.combat(2);
				if(result == "Right")
				{
					Llabel2.setText("X");
				}
				else if (result == "Left")
				{
					Rlabel2.setText("X");
				}
				else if (result == "Tie")
				{
					Llabel2.setText("X");
					Rlabel2.setText("X");
				}
				battle += "2";
			}
			else if(!battle.contains("3"))
			{
				result = app.combat(3);
				if(result == "Right")
				{
					Llabel3.setText("X");
				}
				else if (result == "Left")
				{
					Rlabel3.setText("X");
				}
				else if (result == "Tie")
				{
					Llabel3.setText("X");
					Rlabel3.setText("X");
				}
				next.setText("clear");
				battle += "3";
			}
			else
			{
				String set = app.checkLeft();
				if(set.contains("1"))
				{
					Llabel1.setVisible(false);
					Llabel1.setText("");
				}
				if(set.contains("2"))
				{
					Llabel2.setVisible(false);
					Llabel2.setText("");
				}
				if(set.contains("3"))
				{
					Llabel3.setVisible(false);
					Llabel3.setText("");
				}
				
				set = app.checkRight();
				if(set.contains("1"))
				{
					Rlabel1.setVisible(false);
					Rlabel1.setText("");
				}
				if(set.contains("2"))
				{
					Rlabel2.setVisible(false);
					Rlabel2.setText("");
				}
				if(set.contains("3"))
				{
					Rlabel3.setVisible(false);
					Rlabel3.setText("");
				}
				next.setText("placement");
				nextControl = 0;
			}
		}
		if(control == 2)
		{
			setBackground(randomColor());
		}
		
	}
	
	/**
	 * a function to get a random color
	 * @return
	 * a color
	 */
	private Color randomColor()
	{
		Color randomColor = null;
		
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		
		randomColor = new Color (red, green, blue);
		
		return randomColor;
	}
	
	/**
	 * takes two values to update a label to look like the specified card
	 * @param name
	 * the value of the card you want to make the label look like
	 * @param target
	 * the label you want to change
	 */
	private void updateDisplay(String name, String target)
	{
		String path = "/cards/view/Card_Images/";
		String defaultName = "CardBack";
		String extension = ".jpeg";
		
		if(target == "L1")
		{
		try
		{
			picture = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingFile)
		{
			picture = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		Llabel1.setIcon(picture);
		Llabel1.setVisible(true);
		Lfield1.setVisible(false);
		Lfield2.setVisible(false);
		Lfield3.setVisible(false);
		updateDisplay("", "LD");
		}
		else if(target == "L2")
		{
		try
		{
			picture = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingFile)
		{
			picture = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		Llabel2.setIcon(picture);
		Llabel2.setVisible(true);
		Lfield1.setVisible(false);
		Lfield2.setVisible(false);
		Lfield3.setVisible(false);
		updateDisplay("", "LD");
		}
		else if(target == "L3")
		{
		try
		{
			picture = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingFile)
		{
			picture = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		Llabel3.setIcon(picture);
		Llabel3.setVisible(true);
		Lfield1.setVisible(false);
		Lfield2.setVisible(false);
		Lfield3.setVisible(false);
		updateDisplay("", "LD");
		}
		else if(target == "LD")
		{
		try
		{
			picture = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingFile)
		{
			picture = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		Ldeck.setIcon(picture);
		}
		else if(target == "R1")
		{
		try
		{
			picture = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingFile)
		{
			picture = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		Rlabel1.setIcon(picture);
		Rlabel1.setVisible(true);
		}
		else if(target == "R2")
		{
		try
		{
			picture = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingFile)
		{
			picture = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		Rlabel2.setIcon(picture);
		Rlabel2.setVisible(true);
		}
		else if(target == "R3")
		{
		try
		{
			picture = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingFile)
		{
			picture = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		Rlabel3.setIcon(picture);
		Rlabel3.setVisible(true);
		}
		else if(target == "RD")
		{
		try
		{
			picture = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingFile)
		{
			picture = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		Rdeck.setIcon(picture);
		}
		else if(target == "DC")
		{
		try
		{
			picture = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingFile)
		{
			picture = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		discard.setIcon(picture);
		}
	}
	
	/**
	 * sets the layout of the gui
	 */
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, leftPanel, 40, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, leftPanel, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, leftPanel, -40, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, leftPanel, -500, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, rightPanel, 0, SpringLayout.NORTH, leftPanel);
		layout.putConstraint(SpringLayout.WEST, rightPanel, 500, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, rightPanel, 0, SpringLayout.SOUTH, leftPanel);
		layout.putConstraint(SpringLayout.EAST, rightPanel, -150, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.WEST, start, 300, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, start, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.SOUTH, next, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, next, 410, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Ldeck, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, Ldeck, 30, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, Rdeck, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, Rdeck, 10, SpringLayout.EAST, rightPanel);
		layout.putConstraint(SpringLayout.NORTH, discard, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, discard, 50, SpringLayout.EAST, leftPanel);
		layout.putConstraint(SpringLayout.EAST, Rdeck, 0, SpringLayout.EAST, this);
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		layout.putConstraint(SpringLayout.NORTH, title, 0, SpringLayout.NORTH, leftPanel);
		layout.putConstraint(SpringLayout.SOUTH, title, -50, SpringLayout.NORTH, discard);
		layout.putConstraint(SpringLayout.WEST, title, 20, SpringLayout.EAST, leftPanel);
		layout.putConstraint(SpringLayout.EAST, title, 0, SpringLayout.WEST, rightPanel);
	}
}