Feature: To check functionality of Saucedemo.com

@Shop
Scenario Outline: place the order and log out off the application
  
Given user is on swag labs products page
When user adds items to the cart
And clicks on cart button
Then lands on cart page and gets added items
When user checks out the added items with details <firstname> , <lastname> and <pincode>
Then checkout is complete and order is placed
When user logs out of the app
Then user lands on saucedemo login page 
  
Examples:
| firstname | lastname | pincode |
| Abhinav   | Nautiyal | 248001  |
