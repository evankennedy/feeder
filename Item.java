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
class Item {
    public String brand;
    public ArrayList<String> type = new ArrayList<String>();
    public String name;
    public float price;
    public String unit;
    pubilc String expireDate;
    public String postDate;
    public String sid;
    public boolean memberOnly = false;
    public String category;
}
