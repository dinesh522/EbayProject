Feature: Add item to Cart

Scenario: Add item to cart and remove from the cart

Given User launch Ebay website
And Search for book
And Click first available book
And Add the book to the Cart
And User navigates to Shopping cart page
And verify whether the book is added to the cart
And Remove the book from the car
And Go to Cart page
And veriy the cart is empty
And Close the browser

