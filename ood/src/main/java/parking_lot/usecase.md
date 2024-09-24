## classes and relationship

### ParkingLot
- properties: name, location, parking floors
- behavior: checkAvailability(), checkIn(), checkOut(), 

### ParkingFloor
- properties: floor number, available parking spots for each type of cars
- behavior: updateAvailableCount()

### Parking Spot
- properties: soptId, floorId, status, carId
- behavior: park(), unpark()

### Spot Type
- enum class: HANDICAP, COMPACT, TRUCK, ELECTRICAL

### Vehicle
- properties: carId

### Ticket
- properties: vehicle, enterTime, exitTime, rate
- calculateFee(), markPaid(), printTicket()

