import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SafewayHandler extends DefaultHandler {
	
	private ArrayList<Store> stores = new ArrayList<Store>();
	private Store currentStore;
	private ArrayList<String> openTags = new ArrayList<String>();
	
    public void startDocument() throws SAXException {
    	
    }

    public void endDocument() throws SAXException {
    	
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    	if(qName == "poi") {
    		currentStore = new Store();
        	stores.add(currentStore);
    	}
    	openTags.add(0, qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
    	int n = openTags.indexOf(qName);
    	for(int i=0; i<=n; i++) openTags.remove(0);
    	if(qName == "poi") {
	    	currentStore.url = "http://weeklyspecials." + currentStore.storeName.toLowerCase() + ".com/rss.jsp?drpStoreID=" + currentStore.storeNumber + "&categories=all";
	    	currentStore = null;
    	}
    }

    public void characters(char ch[], int start, int length) throws SAXException {
    	String tag = openTags.get(0);
    	String value = new String(ch, start, length);
    	try {
	    	if(tag == "name") currentStore.storeName = value;
	    	else if(tag == "address1") currentStore.address1 = value;
	    	else if(tag == "address2") currentStore.address2 = value;
	    	else if(tag == "city") currentStore.city = value;
	    	else if(tag == "state") currentStore.state = value;
	    	else if(tag == "postalcode") currentStore.zip = Integer.parseInt(value);
	    	else if(tag == "address2") currentStore.address2 = value;
	    	else if(tag == "divnumber") currentStore.divisionNumber = Integer.parseInt(value);
	    	else if(tag == "clientkey") currentStore.storeNumber = Integer.parseInt(value);
    	} catch(Exception e) {}
    }

    public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
    	
    }
    
    public ArrayList<Store> getStores() {
    	return stores;
    }
}    
