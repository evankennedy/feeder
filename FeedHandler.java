import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FeedHandler extends DefaultHandler {
  
    private ArrayList<Store> stores = new ArrayList<Store>();
    private ArrayList<Item> items = new ArrayList<Item>();
    private Store currentStore;
    private Item currentItem;
  private ArrayList<String> openTags = new ArrayList<String>();
    
    public void startDocument() throws SAXException {
    	
    }

    public void endDocument() throws SAXException {
    	
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    	if(qName.equals("s")) stores.add(currentStore = new Store());
        if(qName.equals("i")) items.add(currentItem = new Item());
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
        if(openTags.indexOf("stores") != -1) {
            // In Stores
            /*
            <s>
                <n>Ralphs</n> <!-- Name -->
                <d>1.01</d> <!-- Distance (miles) -->
                <id>703-00186</id> <!-- id -->
                <a1>1930 N Lakewood Blvd</a1> <!-- Address 1 -->
                <a2></a2> <!-- Address 2 -->
                <c>Long Beach</c> <!-- City -->
                <st>CA</s> <!-- State -->
                <z>90815</z> <!-- Zip -->
            </s>
            */
            try {
                if(tag == "n") currentStore.storeName = value;
                else if(tag == "a1") currentStore.address1 = value;
                else if(tag == "a2") currentStore.address2 = value;
                else if(tag == "c") currentStore.city = value;
                else if(tag == "st") currentStore.state = value;
                else if(tag == "z") currentStore.zip = Integer.parseInt(value);
                else if(tag == "d") currentStore.distance = Float.parseFloat(value);
                else if(tag == "id") currentStore.id = value;
            } catch(Exception e) {}
        } else if(openTags.indexOf("items") != -1) {
            // In Items
            /*
            <i>
                <b>Fresh Eating Right</b> <!-- brand -->
                <t>Boneless</t> <!-- type -->
                <t>Skinless</t>
                <t>Breasts</t>
                <n>Chicken</n> <!-- name -->
                <p>2.99</p> <!-- price -->
                <u>lb</u> <!-- unit (lb, oz, ea, etc..) -->
                <ed>11/20/2013</ed> <!-- expire date (the date which the ad is no longer valid) -->
                <pd>11/13/2013</pd> <!-- post date (the date which the ad starts being valid) -->
                <sid>703-00186</sid> <!-- Store id -->
                <m>0</m> <!-- Member's only -->
                <c>Meat & Seafood</c> <!-- Category -->
            </i>
            */
            try {
                if(tag == "b") currentItem.brand = value;
                else if(tag == "t") currentItem.type.add(value);
                else if(tag == "n") currentItem.name = value;
                else if(tag == "p") currentItem.price = Float.parseFloat(value);
                else if(tag == "u") currentItem.unit = value;
                else if(tag == "ed") currentItem.expireDate = value;
                else if(tag == "pd") currentItem.postDate = value;
                else if(tag == "sid") currentItem.sid = value;
                else if(tag == "m") currentItem.memberOnly = (value == "1");
                else if(tag == "c") currentItem.category = value;
            } catch(Exception e) {}
        }
            
        }

    public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
    	
    }
    
    public ArrayList<Store> getStores() {
        return stores;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
}    
