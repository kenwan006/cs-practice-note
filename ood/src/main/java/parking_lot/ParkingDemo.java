package parking_lot;

import java.time.LocalDateTime;

import static parking_lot.ParkingSpotType.*;

public class ParkingDemo {

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("lax-parking-building-1", "12434 W Central Ave, Los Angeles", 3);
        Vehicle v1 = new Vehicle("8ROSFG");
        Vehicle v2 = new Vehicle("9ROHHH");
        Vehicle v3 = new Vehicle("9ROSSH");
        Vehicle v4 = new Vehicle("9ROHHD");
        Vehicle v5 = new Vehicle("9ROHML");


        parkingLot.enter(HANDICAP, v1);
        parkingLot.enter(COMPACT, v2);
        parkingLot.enter(COMPACT, v3);
        parkingLot.enter(ParkingSpotType.TRUCK, v4);
        parkingLot.enter(ELECTRICAL, v5);

        parkingLot.display();

        parkingLot.park(0, HANDICAP);
        parkingLot.park(0, TRUCK);
        parkingLot.park(1, ELECTRICAL);
        parkingLot.park(2, COMPACT);
        parkingLot.park(2, COMPACT);

        LocalDateTime enterTime = LocalDateTime.parse("2024-09-24T05:00:30");



    }

}
