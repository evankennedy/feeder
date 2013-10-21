public class Store {
		public String storeName;
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
        public boolean isOpen(int minutes) {
			return false;
		}
        
        
        private class DailyHours {
            int from; // 800 is 8:00am
            int to; // 2200 is 10:00pm
            
            public DailyHours(int from, int to) {
                    this.from = from;
                    this.to = to;
            }
        }  
}
