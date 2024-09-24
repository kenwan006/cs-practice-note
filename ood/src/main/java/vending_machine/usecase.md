## classes and relationship

### VendingMachine
- properties: name, inventory
- behavior: display(), checkOut()

### Inventory
- properties: Map<Item, quantity> items
- behavior: checkAvailability(), addItem(), consumeItem()

### Item
- properties: name, price
- behavior: getName(), getPrice()

### Payment
- properties: insertedAmount
- behavior: makePayment(), cancelPayment()





