import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import javax.swing.*;

public class Search extends JFrame implements ActionListener
{
	
	public JLabel zipLabel;
	public JTextField zipField, resultField;
	public JButton btnSearch, btnExit;
	
   
    public Search()
    {
    	
    	setLayout(null);
		setSize(700,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		zipLabel = new JLabel("Please Enter Your Zip Code:");
		zipLabel.setBounds(100,0,200,200);
		add(zipLabel);
		
		zipField = new JTextField(10);
		zipField.setBounds(100,120,200,25);
		zipField.addActionListener(this);
		add(zipField);
		
		btnSearch = new JButton ("Search!");
		btnSearch.setBounds(350,100,100,100);
		btnSearch.addActionListener(this);
		add(btnSearch);

		
		btnExit = new JButton("Main Menu ");
		btnExit.setBounds(500,500,100,100);
		btnExit.addActionListener(this);
		add(btnExit);
		
		ImageIcon imageIcon = new ImageIcon("img/image1.jpg");
		Image image = imageIcon.getImage();
    }
    
    public ImageIcon FoodImg; 
	public JLabel Fname;
    
    public void actionPerformed(ActionEvent e)
    {
    	
    	if (e.getSource() == btnSearch)
		{
    		int zipValue;
            zipValue = Integer.parseInt(zipField.getText());
            repaint();

            setBackground(Color.white);
			System.out.println("Searching");
			String name = pickFood();
			System.out.println("Food "+ name);
			result(name);

			
		}
    	
    	if (e.getSource() == btnExit)
		{
    		userInterface i = new userInterface();
    		i.setVisible(true);
    		
		}
            
    }
    
public void result(String foodName){

  //	repaint();
	switch(foodName){
	case "Pasta" : 
		FoodImg = new ImageIcon(getClass().getResource("Pasta.jpg"));
		break;
	
	case "Pizza" : 
		FoodImg = new ImageIcon(getClass().getResource("Pizza.jpg"));
		break;

	case "Seafood" : 
		FoodImg = new ImageIcon(getClass().getResource("Seafood.jpg"));
		break;

	case "Deli" : 
		FoodImg = new ImageIcon(getClass().getResource("Deli.jpg"));
		break;

	case "Frozen" : 
		FoodImg = new ImageIcon(getClass().getResource("Frozen.jpg"));
		break;

	case "Canned" : 
		FoodImg = new ImageIcon(getClass().getResource("Canned.jpg"));
		break;

	case "Wine" : 
		FoodImg = new ImageIcon(getClass().getResource("Wine.jpg"));
		break;

	case "Bakery" : 
		FoodImg = new ImageIcon(getClass().getResource("Bakery.jpg"));
		break;
		

	case "Fruit" : 
		FoodImg = new ImageIcon(getClass().getResource("Fruits.jpg"));
		break;

	case "Soup" : 
		FoodImg = new ImageIcon(getClass().getResource("Soup.jpg"));
		break;
	
	}
	 
		

	//FoodImg = new ImageIcon(getClass().getResource("Food-Finder.png"));
	Fname = new JLabel(FoodImg);
	Fname.setBounds(150,300,301,376);
	add(Fname);
	//remove(Fname);
}
public static String pickFood() 
{
	String foodName= " ";
	String [] foodList = {"Pasta","Pizza","Seafood","Deli","Frozen","Canned","Wine","Bakery","Fruit","Soup"};
	int pickNum = (int) (Math.random()*9);
	foodName = foodList[pickNum];
return foodName;
}

    
    
}

        
      
        
       
