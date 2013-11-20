feeder
======
A project for CECS 343

#Feed Url
URL: http://cecs343-feeder.appspot.com/

#Sample Feed

```xml
<?xml version="1.0" encoding="UTF-8"?>
<feed>
	<items>
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
	</items>
	<stores>
		<s>
			<n>Ralphs</n> <!-- Name -->
			<d>1.01</d> <!-- Distance (miles) -->
			<id>703-00186</id> <!-- id -->
			<a1>1930 N Lakewood Blvd</a1> <!-- Address 1 -->
			<a2></a2> <!-- Address 2 -->
			<c>Long Beach</c> <!-- City -->
			<s>CA</s> <!-- State -->
			<z>90815</z> <!-- Zip -->
		</s>
	</stores>
</feed>
```

We need to find meals that we can make out of this list. The list will be changing each week! I'll also try to think of ideas if it gets difficult.
