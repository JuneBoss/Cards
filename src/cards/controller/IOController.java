package cards.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import cards.view.CardsFrame;




public class IOController
{
	public static String loadData(String dataFile, CardsFrame frame)
	{
		String load = null;
		
		try (FileInputStream inputStream = new FileInputStream(dataFile);
				ObjectInputStream input = new ObjectInputStream(inputStream))
		{
			String loadedScore;
			loadedScore = (String) input.readObject();
			load = loadedScore;
		}
		catch (IOException fileError)
		{
			JOptionPane.showMessageDialog(frame,  fileError.getMessage(), "Could not read File!", JOptionPane.ERROR_MESSAGE);;
		}
		catch (ClassNotFoundException classError)
		{
			JOptionPane.showMessageDialog(frame, classError.getMessage(), "Incorrect class type!", JOptionPane.ERROR_MESSAGE);
		}
		
		return load;
	}
	
	public static void saveData(String dataFile, CardsFrame frame, String scoreBoard)
	{
		try (FileOutputStream outputStream = new FileOutputStream(dataFile);
				ObjectOutputStream output = new ObjectOutputStream(outputStream))
		{
			output.writeObject(scoreBoard);
		}
		catch (IOException fileError)
		{
			JOptionPane.showMessageDialog(frame,  fileError.getMessage(), "Saving Error!", JOptionPane.ERROR_MESSAGE);;
		}
	}
}
