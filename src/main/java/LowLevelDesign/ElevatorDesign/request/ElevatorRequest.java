package LowLevelDesign.ElevatorDesign.request;

import LowLevelDesign.ElevatorDesign.Model.Direction;
import LowLevelDesign.ElevatorDesign.Model.Wing;

public class ElevatorRequest {


    private int destinationFloor;
    private Wing requestedWing;
    private Direction direction;

    public ElevatorRequest(Direction direction, int destinationFloor, Wing requestedWing) {
        this.direction = direction;
        this.destinationFloor = destinationFloor;
        this.requestedWing = requestedWing;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public Wing getRequestedWing() {
        return requestedWing;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

}
