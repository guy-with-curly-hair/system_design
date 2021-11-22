package LowLevelDesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorService {

    List<Lift> currentLifts=new ArrayList<>();

    public boolean registerLift(Lift lift) {
        currentLifts.add(lift);
        System.out.println("starting lift ");
        lift.start();
        System.out.println("started lift ");

        return true;
    }

    public Lift getElevator(ElevatorRequest request) {
        System.out.println("thread name in getElevator " + Thread.currentThread().getName());
        return getElevatorNumber(request.getRequestedWing(), request.getDestinationFloor(), request.getDirection());
    }

    private Lift getElevatorNumber(final Wing wing, final int destinationFloor, Direction requestedDirection) {

        Lift sectedLift= currentLifts.stream().
                filter(lift -> lift.getWing().equals(wing))
        .findAny().get();
        System.out.println("lift allocated  "+ sectedLift.getLiftId() + " at current Floor "+sectedLift.getCurrent_floor());
        sectedLift.addDestinations(destinationFloor);
    /*            .filter(lift -> wing.equals(lift.getWing()))
                .filter(lift -> requestedDirection.equals(lift.getDirection()))
                .filter(lift ->  destinationFloor -lift.getCurrent_floor() > 2)*/
return  sectedLift;
    }

}
