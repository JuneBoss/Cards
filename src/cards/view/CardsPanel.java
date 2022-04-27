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
		private ImageIcon Lpic1;
		private JLabel Llabel1;
		private ImageIcon Lpic2;
		private JLabel Llabel2;
		private ImageIcon Lpic3;
		private JLabel Llabel3;
		private ImageIcon Rpic1;
		private JLabel Rlabel1;
		private ImageIcon Rpic2;
		private JLabel Rlabel2;
		private ImageIcon Rpic3;
		private JLabel Rlabel3;
		

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
		this.Lpic1 = new ImageIcon();
		this.Llabel1 = new JLabel("Llabel1");
		this.Lpic2 = new ImageIcon();
		this.Llabel2 = new JLabel("Llabel2");
		this.Lpic3 = new ImageIcon();
		this.Llabel3 = new JLabel("Llabel3");
		this.Rpic1 = new ImageIcon();
		this.Rlabel1 = new JLabel("Rlabel1");
		this.Rpic2 = new ImageIcon();
		this.Rlabel2  = new JLabel("Rlabel2");
		this.Rpic3 = new ImageIcon();
		this.Rlabel3 = new JLabel("Rlabel3");
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void updateDisplay(String name)
	{
		String path = "/cards/view/Card_Images/";
		String defaultName = "CardBack";
		String extension = ".png";
		
		try
		{
			Lpic1 = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingFile)
		{
			Lpic1 = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		Llabel1.setIcon(Lpic1);
	}

	private void setupPanel()
	{
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(new Color(54, 89, 74));
		
		leftPanel.add(Lfield1);
		leftPanel.add(Lfield2);
		leftPanel.add(Lfield3);
		leftPanel.add(Llabel1);
		
		this.add(leftPanel);
	}

	private void setupListeners()
	{
	}

	private void setupLayout()
	{
		
	}
}