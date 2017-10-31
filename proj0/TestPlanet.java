public class TestPlanet{
    public static void main (string[] arg){
        Planet a = Planet(1,1.0,1.0, 1.0,1.0,"1");
        Planet a = new Planet(1,1.0,1.0, 1.0,1.0,"1");
        Planet b = new Planet(2.0, 2.0, 2.0, 2.0, 2.0,"2");
        System.out.print(a.calcForceExertedByY(b));
    }
}