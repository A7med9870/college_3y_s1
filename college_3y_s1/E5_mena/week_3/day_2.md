UML and object modelling

next week (4) ms assignment

scenarios and use cases
actor: an entity (rp by user) that can interact with a system, invoking some behavior
Scenario: a specific sequence of actions and interactions between actors and the system being discussed
use case: task to be completed by the actors(a collection of related success and failure scenarios)

Scenario ex
scenarios represent one possible outcome of the actor system interaction
    card-rejected
    account holder places card in slot. system prompts user for pin, user enters pin
    pin is not valid for the given card. card is rejected

use case example
use cases glue together related scenarios

use cae withdrawal
account holder places car in slot
system prompts account holder for pin and the holder enters pin
system says it's valid pin foor the card
the holder selects withdrawal trans
system ensures the account has enough money
system deducts the requested amount from the account
system dispenses cash to the holder
CD shop
in a cd shop, customers are allowed to browse items. if the customer wants to buy a cd, the salesperson is contacted for payment and the customer
collect the cd. if a customer wants to borrow CDs. he/she can select the CD and contact the salesperson for payment. The salesperson will
enter the customer details and due date in the system. the CD will be marked "unavailable" in the system. when a customer returns a CD; it is marked "available"
for the corresponding CD. the salesperson is also responsible for maintaining stock records.
if an item is out of stock, the salesperson can contact the warehouse and place the order.
When a new item is received the salesperson will be responsible for adding new records to the stock file

construct a use diagram for the above system
give textual/tabular descriptions for the use cases.
