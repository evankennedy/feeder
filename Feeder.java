import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;

/*
Program Name: Food Finder
Team: Feeder
Purpose: a user interface class that take in some of the requirement input
output background image and sound.
*/

public class Feeder extends JApplet implements ActionListener
{
	
	JLabel zipLabel;
	JTextField zipField, resultField;
	ArrayList<Store> stores;
	//ArrayList<>
	Container container = getContentPane();
	
	public void init()
	{
		try
		{
			container.add(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Jack/Desktop/New Folder/IMG_0.JPG")))));
			
		} catch(IOException a)
		{
			
			System.out.println("Image doesn't exists");
		}
		
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
	
	
	public void showBackGround()
	{
		
		
		
		JFrame F = new JFrame("aps");
		
		try
		{
			backGroundField.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("")))));
			
		}
		catch(IOException e)
		{
			System.out.println("unable to load image");
		
		}
		backGroundField.setResizable(false);
		backGroundField.pack();
		backGroundField.setVisible(true);
			
	}
	/* 
	
	
	
	import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.awt.Container;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Feeder extends Applet
{
	public Button help = new Button("Help");
    public Button credit = new Button("Credit");
    public Button search = new Button("Search");
    public Button restart = new Button("Restart");
    JLabel intro;
    JLabel zipLabel;
    //Container container = getContentPane();
    JTextField zipField, resultField;
    public Interface canvas = new Interface();

    public void init()
    {
    	
    	container.setLayout(new FlowLayout(40));
    	
    	intro = new JLabel("Welcom to Feeder program: Please select the follow bottoms to containue: ");
    	container.add(intro);
    	
    	canvas.setSize(600,600);	
    	
    	add(help);
        add(credit);
        add(search);
        add(restart);
    	
        help.addActionListener(canvas);
        credit.addActionListener(canvas);
        search.addActionListener(canvas);
        restart.addActionListener(canvas);
        
    }
    
    
 


	public class Interface extends Canvas implements ActionListener
    {
    	Object source;
    	public void actionPerformed(ActionEvent event)
    	{
    		source = event.getSource();
    		
    	}
    	
    	public void buttomClick()
    	{
    		
    		if (source == help)
    		{
    			 setUpHelp();
    		}
    		
    		else if (source == credit)
    		{
    			 setUpcredit();
    		}
    		
    		else if (source == search)
    		{
    			setUpSearch();
    		}
    		else if (source == restart)
    		{
    			setUpRestart();
    		}
    		
    	}
    	
    	
    	public void setUpHelp()
        {
    		  JLabel helpLabel;
    		  JLabel help2Label;
    		  Container container = getContentPane();
    		
    		 container.setLayout(new FlowLayout(40)); // this one is just set up some 
             
             helpLabel = new JLabel("The food finder program is a program that will help the users to find a meal"); 
             container.add(helpLabel);
             JLabel help2Label; = new JLabel("using minimum  of money and travling distance. ");
             container.add(help2Label);
             
             
 

        }
        
        public void setUpcredit()
        {
        		System.out.println("This program is made by programing team Feeder");
        		System.out.println("any Users can download and use the programs for free");
                
       
        }
        
        public void setUpSearch()
        {
                
        }
        
        public void setUpRestart()
        {
            
        }
        
    	
  
    	
    }
	
	
}
	
	
	*/
	public void actionPerformed(ActionEvent e)
	{

		String food;
		int zipValue;
		double price;
		
		zipValue = Integer.parseInt(zipField.getText());
		
		
		//food = Findfood(); // i still don't know what kind the function parameter for the search food or the price...
		//price = FindPrice();
		
		
		
		showStatus("Searching for stores... " );
		stores = new ArrayList<Store>();
		try {
			findStores(zipValue);
		} catch (Exception error) {
			error.printStackTrace();
		}
		
		showStatus("Searching for weekly ads...");
		for(int i = stores.size() - 1; i >= 0; i--) {
			System.out.println(stores.get(i).storeName + " at " + stores.get(i).address1 + " with ad url " + stores.get(i).url);
		}
		
		showStatus("Generating Meals...");
		
		
		showStatus("Done");
		//resultField.setText(foodName);
		
		//resultField.setText(FindPrice);
		
	
	}
	
	public double FindPrice(double p)
	{
		double price = 1.01;
		
		return price;
	}

	public String Findfood(long f)
	{
		String foodName= "hamburger";
	
		return foodName;
	}
	
	
	
	// Downloads ads from nearby stores and stores them in a local file
	private void findStores(int zip) throws UnsupportedEncodingException {
		String url = "http://locator.safeway.com/ajax?&xml_request=" + URLEncoder.encode(
			"<request>" +
				"<appkey>5D7395E2-BFE9-11DE-B770-BEE374652C6E</appkey>" +
				"<formdata id=\"locatorsearch\">" +
					"<events>" +
						"<where>" +
							"<eventstartdate>" +
								"<ge>now()</ge>" +
							"</eventstartdate>" +
						"</where>" +
						"<limit>2</limit>" +
					"</events>" +
					"<dataview>store_default</dataview>" +
					"<geolocs>" +
						"<geoloc>" +
							"<addressline>" + zip + "</addressline>" +
							"<longitude></longitude>" +
							"<latitude></latitude>" +
						"</geoloc>" +
					"</geolocs>" +
					"<searchradius>5</searchradius>" +
					"<limit>20</limit>" +
					"<where>" +
						"<closed>" +
							"<distinctfrom>1</distinctfrom>" +
						"</closed>" +
						"<fuelparticipating>" +
							"<distinctfrom>1</distinctfrom>" +
						"</fuelparticipating>" +
						"<bakery><eq></eq></bakery>" +
						"<deli><eq>1</eq></deli>" +
						"<floral><eq></eq></floral>" +
						"<liquor><eq></eq></liquor>" +
						"<meat><eq></eq></meat>" +
						"<pharmacy><eq></eq></pharmacy>" +
						"<produce><eq>1</eq></produce>" +
						"<jamba><eq></eq></jamba>" +
						"<seafood><eq></eq></seafood>" +
						"<starbucks><eq></eq></starbucks>" +
						"<video><eq></eq></video>" +
						"<fuelstation><eq></eq></fuelstation>" +
						"<dryclean><eq></eq></dryclean>" +
						"<digital><eq></eq></digital>" +
						"<dvdplay_kiosk><eq></eq></dvdplay_kiosk>" +
						"<coinmaster><eq></eq></coinmaster>" +
						"<wifi><eq></eq></wifi>" +
						"<bank><eq></eq></bank>" +
						"<seattlesbestcoffee><eq></eq></seattlesbestcoffee>" +
						"<beveragestewards><eq></eq></beveragestewards>" +
						"<photo><eq></eq></photo>" +
						"<wu><eq></eq></wu>" +
						"<debi_lilly_design><eq></eq></debi_lilly_design>" +
					"</where>" +
				"</formdata>" +
			"</request>"
		, "ISO-8859-1");
		
        SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			InputStream    xmlInput  = new URL(url).openStream();
			SAXParser      saxParser = factory.newSAXParser();
			
			SafewayHandler handler   = new SafewayHandler();
			saxParser.parse(xmlInput, handler);
			
			stores.addAll(handler.getStores());
			
		} catch (Throwable e) 
		{
			e.printStackTrace ();
		}
	}
}

