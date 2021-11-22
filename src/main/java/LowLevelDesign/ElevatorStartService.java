package LowLevelDesign;

public class ElevatorStartService {

    private static ElevatorService service = new ElevatorService();
    public static void main (String[] args) throws InterruptedException {
        registerLifts();
    }


    private static void registerLifts()
    {
        Lift l1= new Lift(1,Wing.ARTICA_A,10,-2);
        Lift l2= new Lift(2,Wing.ARTICA_A,10,-2);
/*        Lift l3= new Lift(3,Wing.ARTICA_A,7,0);
        Lift l4= new Lift(4,Wing.PACIFICA_A,8,-3);*/
        Lift l5= new Lift(5,Wing.PACIFICA_A,11,-2);
        Lift l6= new Lift(6,Wing.PACIFICA_A,12,1);
        service.registerLift(l1);
        service.registerLift(l2);
/*        service.registerLift(l3);
        service.registerLift(l4);*/
        service.registerLift(l5);
        service.registerLift(l6);

    }





}
