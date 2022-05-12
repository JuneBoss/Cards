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
	public static ArrayList<String> loadData(String dataFile, CardsFrame frame)
	{
		ArrayList<String> load = null;
		
		try (FileInputStream inputStream = new FileInputStream(dataFile);
				ObjectInputStream input = new ObjectInputStream(inputStream))
		{
			ArrayList<String> loadedDiscard;
			loadedDiscard = (ArrayList<String>) input.readObject();
			load = loadedDiscard;
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
	
	public static void saveData(String dataFile, CardsFrame frame, ArrayList<String> discard)
	{
		try (FileOutputStream outputStream = new FileOutputStream(dataFile);
				ObjectOutputStream output = new ObjectOutputStream(outputStream))
		{
			output.writeObject(discard);
		}
		catch (IOException fileError)
		{
			JOptionPane.showMessageDialog(frame,  fileError.getMessage(), "Saving Error!", JOptionPane.ERROR_MESSAGE);;
		}
	}
}
