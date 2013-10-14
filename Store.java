public class Store {
	public String address1;
	public String address2;
	public String city;
	public String state;
	public int zip;
	public double latitude;
	public double longitude;
	public DailyHours[] hours; // 0-7 <=> Sunday-Saturday
	public String url; // URL of weekly ad
	public int divisionNumber; // May be un-needed
	public int storeNumber; // May be un-needed
	
	public Store() {}
	
	public void save() {}
	public void load() {}
	
	/* isOpen()
		minutes must be between 0 (now) and 60*24*7 (one week) otherwise will throw error
		isOpen(0) returns true if store is open now
		isOpen(15) returns true if store is open in 15 minutes
		isOpen(60*2) returns true if store is open in 2 hours
	*/
	public boolean isOpen(int minutes) {}
}

protected class DailyHours {
	int from; // 800 is 8:00am
	int to; // 2200 is 10:00pm
	
	public DailyHours(int from, int to) {
		this.from = from;
		this.to = to;
	}
}


/*
VONS:
http://locator.vons.com/ajax?&xml_request=
<request>
	<appkey>19A7C016-A40F-11E0-BBB2-5A8A4D48D7F4</appkey>
	<formdata id="locatorsearch">
		<dataview>store_default</dataview>
		<geolocs>
			<geoloc>
				<addressline></addressline>
				<longitude>-118.135482</longitude>
				<latitude>33.790802</latitude>
			</geoloc>
		</geolocs>
		<searchradius>10|25|50|100|250</searchradius>
	</formdata>
</request>

RALPHS:
http://services.ralphs.com/StoreLocator/StoreLocatorHandler.ashx?ADDRESSQUERY=90815&RADIUS=5&FindStores=true
*/
