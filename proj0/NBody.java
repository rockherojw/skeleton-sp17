import java.util.*;

public class NBody {

    public static double readRadius(String file) {
        In in = new In(file);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String file) {
        List<Planet> lst = new ArrayList<Planet>();
        In in = new In(file);
        in.readInt();
        in.readDouble();
        /* Planet[] thePlanets = new Planet[5];
        for(int i=0 ; i<5 ; i++) {
            double xxp = in.readDouble();
            double yyp = in.readDouble();
            double xxv = in.readDouble();
            double yyv = in.readDouble();
            double mm = in.readDouble();
            String imageFile = in.readString();
            thePlanets[i] = new Planet(xxp, yyp, xxv, yyv, mm, imageFile);
            */
        int[] a = new int[5];
        for (int element : a) {
            double xxp = in.readDouble();
            double yyp = in.readDouble();
            double xxv = in.readDouble();
            double yyv = in.readDouble();
            double mm = in.readDouble();
            String imageFile = in.readString();
            lst.add(new Planet(xxp, yyp, xxv, yyv, mm, imageFile));
        }
        Planet[] lst2 = lst.toArray(new Planet[lst.size()]);
        return lst2;
    }

    public static void main(String[] args) {
        // Collecting All Needed Input
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = NBody.readRadius(filename);
        Planet[] planets = NBody.readPlanets(filename);
        // Drawing planets on universe pic
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "/images/starfield.jpg");
        for (Planet p : planets) {
            p.draw();
        }
        // Creating an Animation
        double time = 0;
        while (time != T) {
            double[] xForces = new double[5];
            double[] yForces = new double[5];
            int i = 0;
            for (Planet p : planets) {
                double fx = p.calcNetForceExertedByX(planets);
                double fy = p.calcNetForceExertedByY(planets);
                xForces[i] = fx;
                yForces[i] = fy;
                i += 1;
            }
            int j = 0;
            for (Planet p : planets) {
                p.update(dt, xForces[j], yForces[j]);
                j += 1;
            }
            StdDraw.picture(0, 0, "/images/starfield.jpg");
            for (Planet p : planets) {
                p.draw();
            }
            time += dt;
            StdDraw.show(10);
            //StdAudio.read("/audio/2001.mid");
        }
        // Print out the final state of the universe
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
