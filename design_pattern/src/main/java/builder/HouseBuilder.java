package builder;

import lombok.Getter;

@Getter
public class HouseBuilder {
    private String floor;
    private String door;
    private String wall;
    private String pool;

    public HouseBuilder(){}

    HouseBuilder buildFloor(String floor) {
        this.floor = floor;
        return this;
    }

    HouseBuilder buildDoor(String door) {
        this.door = door;
        return this;
    }

    HouseBuilder buildWall(String wall) {
        this.wall = wall;
        return this;
    }

    HouseBuilder buildPool(String pool) {
        this.pool = pool;
        return this;
    }

    House build() {
        return new House(this);
    }

    //use lombok to generate getter functions

    public static void main(String[] args) {
        HouseBuilder builder = new HouseBuilder();
        builder.buildDoor("White door")
                .buildFloor("Wood floor")
                .buildWall("Yellow wall")
                .buildPool("Big pool");
        House house = builder.build();

        System.out.println(house);
    }
}
