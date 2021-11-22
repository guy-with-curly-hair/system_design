package LowLevelDesign;

public class ElevatorClientService {

    private static ElevatorService service = new ElevatorService();
    private static LiftClientWithoutDestination client1 = new LiftClientWithoutDestination(Wing.ARTICA_A, 1,service);
    private static LiftClientWithoutDestination l2 = new LiftClientWithoutDestination(Wing.ARTICA_A, 2,service);
    private static LiftClientWithoutDestination l3 = new LiftClientWithoutDestination(Wing.ARTICA_A, 3,service);
    private static LiftClientWithoutDestination l4 = new LiftClientWithoutDestination(Wing.PACIFICA_A, 1,service);
    private static LiftClientWithoutDestination l5 = new LiftClientWithoutDestination(Wing.PACIFICA_A, 2,service);
    private static LiftClientWithoutDestination l6 = new LiftClientWithoutDestination(Wing.PACIFICA_A, 3,service);

    public static void main (String[] args) throws InterruptedException {
        registerLifts();
        System.out.println("Serving another request" + Thread.currentThread().getName());
        client1.callElevator();
        System.out.println("Serving another request " + Thread.currentThread().getName());
        l4.callElevator();
    }


    private static void registerLifts()
    {
        Lift l1= new Lift(1,Wing.ARTICA_A,10,-2);
        Lift l2= new Lift(2,Wing.ARTICA_A,10,-2);
        Lift l3= new Lift(3,Wing.ARTICA_A,7,0);
        Lift l4= new Lift(4,Wing.PACIFICA_A,8,-3);
        Lift l5= new Lift(5,Wing.PACIFICA_A,11,-2);
        Lift l6= new Lift(6,Wing.PACIFICA_A,12,1);
        service.registerLift(l1);
        service.registerLift(l2);
        service.registerLift(l3);
        service.registerLift(l4);
        service.registerLift(l5);
        service.registerLift(l6);

    }





}
