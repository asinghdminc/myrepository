Narrative: 
As a user
i want to login to One20 app
To use the features of the app


Scenario: Login with valid credentials
Given user is on login screen
When user logs in with <email> and <password>
Then user lands on plan screen map view

Examples:
|email			|password|
|asingh@dminc.com|qwerty1|