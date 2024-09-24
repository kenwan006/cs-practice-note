package parking_lot;

import java.util.HashMap;
import java.util.Map;

import static parking_lot.ParkingSpotType.*;

public class ParkingFloor {
    private int level;
    private int handicapCap, compactCap, truckCap, electricalCap;
    private Map<ParkingSpotType, Integer> availableSpotsByType;

    public ParkingFloor(int level, int handicapCap, int compactCap, int truckCap, int electricalCap) {
        this.level = level;
        this.handicapCap = handicapCap;
        this.compactCap = compactCap;
        this.truckCap = truckCap;
        this.electricalCap = electricalCap;
        availableSpotsByType =  Map.of(
                ParkingSpotType.HANDICAP, handicapCap,
                ParkingSpotType.COMPACT, compactCap,
                ParkingSpotType.TRUCK, truckCap,
                ParkingSpotType.ELECTRICAL, electricalCap
        );
    }

    //as we know each parking spot has a sensor, if a car is parked, a light change from green to red
    // it will call this park() function
    public void park(ParkingSpotType type) {
        if (availableSpotsByType.get(type) > 0) {
            availableSpotsByType.put(type, availableSpotsByType.get(type) - 1);
        }
    }

    //leave the spot - a light change from red to green
    public void unPark(ParkingSpotType type) {
        availableSpotsByType.put(type, availableSpotsByType.get(type) + 1);
    }

    //check the count of available spots of given type
    public int availableCount(ParkingSpotType type) {
        return availableSpotsByType.get(type);
    }

    //display the available spots of each type at current level
    public void display() {
        String s = "Available spots at level: " + level + ": \n";
        s = s + HANDICAP + ": " + availableSpotsByType.get(HANDICAP) + "\n" +
                COMPACT + ": " + availableSpotsByType.get(COMPACT) + "\n" +
                TRUCK + ": " + availableSpotsByType.get(TRUCK) + "\n" +
                ELECTRICAL + ": " + availableSpotsByType.get(ELECTRICAL);
        System.out.println(s);
    }
}
