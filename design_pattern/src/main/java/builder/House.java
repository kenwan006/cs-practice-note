package builder;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class House {
    String floor;
    String door;
    String wall;
    String pool;

    public House(HouseBuilder builder) {
        this.floor = builder.getFloor();
        this.door = builder.getDoor();
        this.wall = builder.getWall();
        this.pool = builder.getPool();
    }

    @Override
    public String toString() {
        return "House{" +
                "floor='" + floor + '\'' +
                ", door='" + door + '\'' +
                ", wall='" + wall + '\'' +
                ", pool='" + pool + '\'' +
                '}';
    }
}
