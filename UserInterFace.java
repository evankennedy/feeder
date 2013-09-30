import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextField;
/*
Program Name: Food Finder
 Team: Feeder
 Purpose: a user interface class that take in some of the requirement input
 
 
 
 */


public class UserInterFace extends JApplet implements ActionListener
{
	
	JLabel zipLabel;
	JTextField zipField, resultField;
	

	public void init()
	{
		
		

		Container container = getContentPane();
		container.setLayout(new FlowLayout(40)); // this one is just set up some 
	
		zipLabel = new JLabel("Please enter your zip code: "); 
		container.add(zipLabel);

		
		 zipField = new JTextField(10);
			
		 container.add(zipField);
		 zipField.addActionListener(this);
		 
	
		resultField = new JTextField(10);
		resultField.setEditable(false);
		container.add(resultField);
	}	
	
	
	public void actionPerformed(ActionEvent e)
	{

		String food;
		long zipValue;
		double price;
		
		zipValue = Long.parseLong(zipField.getText());
		
		
		//food = Findfood(); // i still don't know what kind the function parameter for the search food or the price...
		//price = FindPrice();
		
		
		
		showStatus("Searching...... " ); // add in another search function class which might take some time to search fodo ads
		showStatus("Food Find! ");// once find output it over here....
			
		//resultField.setText(foodName);
		
		//resultField.setText(FindPrice);
		
	
	}
	
	public double FindPrice(double p)
	{
		double price =1.01;
		
		return price;
	}

	public String Findfood(long f)
	{
		String foodName= "hamburger";
		
		return foodName;
	}

}
