Feature: Search and Place the order for Products

@search
Scenario: Search Experince for product search in home page

	Given User on GreenCart Landing page
	When user searched with Shortname "Tom" and extracted actual name of product
	Then user searched for "Tom" in offers page to check if product exist with same name
	And validate both the name
	#Then Close the browser
	

@offer
Scenario: Search Experince for product search in offer page

	Given User on GreenCart Landing page
	When user click on offer deals link
	Then user lands on offer page
	Then user searched for "Tom" in offers page
	And extract the name
	#Then Close all the browser

@mutilpleprod	
Scenario Outline: Search multiple product search in home page and offer page

	Given User on GreenCart Landing page
	When user searched with Shortname <Name> and extracted actual name of product's
	Then user searched for <Name> in offers page to check if product exist with same name's
	And validate both the name
	#Then Close the browser
	
	Examples:
	|Name |
	|rice |
	|tom  |
	|pot  |
	|straw|

@order	
Scenario: user able to order the product
	
	Given User on GreenCart Landing page
	When user searched with Shortname "Tom" and extracted actual name of product
	Then user add the quantity
	Then user click on add to cart button
	Then click on cart icon
	Then user click on proceed to checkout
	Then click on the place order 
	Then select the country as "India"
	Then check the checkbox on Terms and Conditions
	Then click on proceed

	
	