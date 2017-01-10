Narrative:
In order to sort and filter deals
As an authenticated used
I want to go to deals screen and sort them based on start date and end date and filter them
					 
Scenario:  Sort by start date
Given user is on plan map view screen
When user goes to save tab
And sorts deals by recently added
Then deals should get sorted by start date

Scenario: Sort by end date
Given user is on save tab
When sorts deals by expiring soon
Then deals should get sorted by end date

Scenario: Filter deals
Given user is on save tab
When user filters deals
Then user should get correct number of deals on save screen