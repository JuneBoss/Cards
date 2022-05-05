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
		private Controller app;
		private JPanel leftPanel;
		private JPanel rightPanel;
		private SpringLayout layout;
		private JButton Lfield1;
		private JButton Lfield2;
		private JButton Lfield3;
		private JLabel Llabel1;
		private JLabel Llabel2;
		private JLabel Llabel3;
		private JLabel Rlabel1;
		private JLabel Rlabel2;
		private JLabel Rlabel3;
		private JLabel Ldeck;
		private JLabel Rdeck;
		private JButton start;
		private JButton next;
		private JLabel discard;
		private ImageIcon picture;
		

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
		
		setupPanel();
		setupListeners();
		setupLayout();
	}

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
		
		updateDisplay("", "LD");
		updateDisplay("", "RD");
		updateDisplay("", "DC");
		Lfield1.setVisible(false);
		Lfield2.setVisible(false);
		Lfield3.setVisible(false);
		

		
		next.setVisible(false);
		
		
		this.add(rightPanel);
		this.add(leftPanel);
	}

	private void setupListeners()
	{
		Lfield1.addActionListener(click -> updateDisplay(drawCard("L1"), "L1"));
		Lfield2.addActionListener(click -> updateDisplay(drawCard("L2"), "L2"));
		Lfield3.addActionListener(click -> updateDisplay(drawCard("L3"), "L3"));
		
		
	}
	
	private String drawCard(String pile)
	{
		String card = "";
		
		card = app.placement(pile);
		
		return card;
	}
	
	private void fillBoard()
	{
		while(!app.boardFull()) 
		{
			if(!app.leftFull()) 
			{
				
			}
			if(!app.rightFull())
			{
				
			}
		}
	}
	
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
		Lfield1.setVisible(false);
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
		Lfield2.setVisible(false);
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
		Lfield3.setVisible(false);
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
		
	}
}