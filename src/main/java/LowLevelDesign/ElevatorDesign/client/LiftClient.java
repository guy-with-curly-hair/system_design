package LowLevelDesign.ElevatorDesign.client;

import LowLevelDesign.ElevatorDesign.request.ElevatorRequest;
import LowLevelDesign.ElevatorDesign.Model.Lift;
import LowLevelDesign.ElevatorDesign.Model.Direction;
import LowLevelDesign.ElevatorDesign.Model.Wing;
import LowLevelDesign.ElevatorDesign.service.ElevatorService;

public class LiftClient {
    private Wing wing;
    private int floor;
    private Direction direction;
    boolean isActive;
    int destinationFloor;
    ElevatorRequest request;
    ElevatorService service;


    public LiftClient(Wing wing, int floor, ElevatorService service) {
        this.wing = wing;
        this.floor = floor;
        this.direction = Direction.IDEAL;
        this.isActive = false;
        this.destinationFloor = 0;
        this.request = new ElevatorRequest(direction, floor, wing);
        this.service=service;

    }

    public void callElevator(int destinationFloor) throws InterruptedException {

        isActive = true;
        request.setDestinationFloor(floor);
        //request.setDirection(floor <  ? Direction.UPWARD : Direction.DOWNWARD);
        Lift lift = service.getElevator(request);
        System.out.println("lift allocated for destination" + lift.getId());
        while (!lift.reachedDestination(floor))
        {
            System.out.println( " floor  reached  " + lift.getCurrent_floor());
        }
        System.out.println( "destination floor  reached  " + lift.getCurrent_floor());
        System.out.println("passenger loading " );
        lift.sleep(10);
        isActive = false;
    }


}
