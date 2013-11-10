Calculating results

Narrative:
In order to calculate the total price of orders
As a cashier
I want to add a list of prices together

Scenario: Find the total price for an order with one item
Given I am given the list <list>
When I calculate the sum of items in the list
Then I should obtain <expectedTotal>
Examples:
| list         | expectedTotal |
| 10           | 10            |
| 1,2,3        | 6             |
| 10, 12.50    | 22.50         |

