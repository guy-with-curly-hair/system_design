package LowLevelDesign;

public class LiftClientWithoutDestination {
    private Wing wing;
    private int floor;
    private Direction direction;
    boolean isActive;
    int destinationFloor;
    ElevatorRequest request;
    ElevatorService service;


    public LiftClientWithoutDestination(LowLevelDesign.Wing wing, int floor, ElevatorService service) {
        this.wing = wing;
        this.floor = floor;
        this.direction = Direction.IDEAL;
        this.isActive = false;
        this.destinationFloor = 0;
        this.request = new ElevatorRequest(direction, floor, wing);
        this.service=service;

    }

    public void callElevator() throws InterruptedException {

        isActive = true;
        request.setDestinationFloor(floor);
        Lift lift = service.getElevator(request);
        while (!lift.reachedDestination(floor))
        {
            System.out.println( " floor  reached  " + lift.getCurrent_floor());
        }
        System.out.println( "destination floor  reached  " + lift.getCurrent_floor());isActive = false;
       // lift.set
    }


}
