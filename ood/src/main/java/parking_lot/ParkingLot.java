package parking_lot;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    ParkingFloor[] parkingFloors;
    private String name;
    private String location;
    Map<Vehicle, Ticket> tickets;

    public ParkingLot(String name, String location, int totalFloors) {
        this.name = name;
        this.location = location;
        parkingFloors = new ParkingFloor[totalFloors];
        tickets = new HashMap<>();
        initializeFloors();
    }

    //for each floor, we initialize it with 100 spots in total including
    //10 handicap, 70 compact, 10 truck, 10 electrical
    private void initializeFloors() {
        for (int i = 0; i < parkingFloors.length; i++) {
            parkingFloors[i] = new ParkingFloor(i, 10, 70, 10, 10);
        }
    }

    // check the availability when entering to the parking lot
    public void enter(ParkingSpotType type, Vehicle car) {
        for (ParkingFloor floor : parkingFloors) {
            int availableCount = floor.availableCount(type);
            if (availableCount > 0) {
                System.out.println("There are " + availableCount + " spots available, please drive in to check");
                System.out.println("Here is you ticket");
                generateTicket(car);
                return;
            }
        }
        System.out.println("No spots available at this moment!");;
    }

    //generate a ticket when enters
    public void generateTicket(Vehicle car) {
        Ticket ticket = new Ticket(car, LocalDateTime.now());
        tickets.put(car, ticket);
    }

    //exit the parking lot
    public void exit(Ticket ticket, LocalDateTime exitTime) {
        ticket.setExitTime(exitTime);
        int fees = ticket.calculateFee();
        System.out.println("You parking fee is: " + fees);
        ticket.setStatus("paid");
        tickets.remove(ticket.getVehicle());
        System.out.println("Thanks for parking with us. Here is your receipt");
        ticket.printTicket();
    }

    //park car at certain floor
    public void park(int level, ParkingSpotType type) {
        parkingFloors[level].park(type);
    }

    //unPark car from certain floor
    public void unPark(int level, ParkingSpotType type) {
        parkingFloors[level].unPark(type);
    }

    //display the available spots at each floor
    public void display() {
        for (ParkingFloor floor : parkingFloors) {
            floor.display();
        }
    }

}
