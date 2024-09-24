package parking_lot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class Ticket {
    LocalDateTime enterTime, exitTime;
    Vehicle vehicle;
    String status; //ticket paid or not paid
    int rate = 10; //$10 charged for each hour parking

    public Ticket(Vehicle vehicle, LocalDateTime enterTime) {
        this.enterTime = enterTime;
        this.vehicle = vehicle;
        this.status = "unpaid";
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int calculateFee() {
        Duration duration = Duration.between(enterTime, exitTime);
        return (int) duration.toHours() * rate;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String printTicket() {
        return "Ticket{" +
                "enterTime=" + enterTime +
                ", exitTime=" + exitTime +
                ", vehicle=" + vehicle +
                ", status='" + status + '\'' +
                '}';
    }
}
