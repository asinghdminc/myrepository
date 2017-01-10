Narrative:
In order to user Google Maps/Apple Maps and Truck Safe Navigation
As an authenticated user
I want to go to Navigate screen to 
					 
Scenario:  Navigate Using Truck Safe Navigation
Given user is on plan map view
When user goes to POI More info screen
And opens Navigate screen
Then Truck Safe Navigation option should be displayed

Scenario: Navigate using Google Maps/Apple Maps
Given user goes to plan map view
When user goes to POI More info screen
And opens Navigate screen
And chooses Google Maps/Apple maps
Then Google Maps/Apple Maps should get launched