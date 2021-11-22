package LowLevelDesign;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Lift extends Thread {
    public int getLiftId() {
        return liftId;
    }

    private int liftId;

    public Wing getWing() {
        return wing;
    }

    private Wing wing;
    private int current_floor;
    private static int max_floor;
    private static int min_floor;
    private BlockingQueue<Integer> destinationFloor;
    private Direction direction;
    boolean isActive;

    public Lift(int liftId, Wing wing, int maxFloor, int min_floor) {
        this.liftId = liftId;
        this.wing = wing;
        this.current_floor = min_floor;
        this.destinationFloor = new ArrayBlockingQueue<Integer>(maxFloor);
        this.direction = Direction.IDEAL;
        this.max_floor = maxFloor;
        this.isActive = false;
        this.min_floor = min_floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void run() {
        while (true) {
            synchronized (destinationFloor) {
                try {
                    if (destinationFloor.contains(current_floor)) {
                        destinationFloor.remove(current_floor);
                        System.out.println("Floor reached waiting for people at floor  " + current_floor);
                        sleep(10);
                    }
                    if (destinationFloor.size() != 0) {
                        gotoFloor();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    void gotoFloor() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(100);
            ++current_floor;
        }
    }

    boolean addDestinations(int floor) {
        validFloor(floor);
        synchronized (this) {
            destinationFloor.add(floor);
            //destinationFloor.notify();
        }
        return true;
    }

    boolean validFloor(int floor) {
        return floor > max_floor && floor < min_floor ? false : true;
    }


    public int getCurrent_floor() {
        return current_floor;
    }

    public boolean reachedDestination(int destination) {
        return current_floor == destination;
    }
}
