public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double distance = Math.sqrt(Math.pow(this.xxPos - p.xxPos, 2) + Math.pow(this.yyPos - p.yyPos, 2));
        return distance;
    }

    public double calcForceExertedBy(Planet p) {
        double G = 6.67 * Math.pow(10, -11);
        double distance = this.calcDistance(p);
        double force = G * this.mass * p.mass / Math.pow(distance, 2);
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double Xforce = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
        return Xforce;
    }

    public double calcForceExertedByY(Planet p) {
        double Yforce = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
        return Yforce;
    }

    public double calcNetForceExertedByX(Planet[] p_array){
        double NetForceX = 0;
        for (int i=0; i < p_array.length; i++) {
            Planet p = p_array[i];
            if (!this.equals(p)) {
                NetForceX += this.calcForceExertedByX(p);
            }
        }
         return NetForceX;
    }

    public double calcNetForceExertedByY(Planet[] p_array){
        double NetForceY = 0;
        for (int i=0; i < p_array.length; i++) {
            Planet p = p_array[i];
            if (!this.equals(p)) {
                NetForceY += this.calcForceExertedByY(p);
            }
        }
         return NetForceY;
    }

    public void update(double dt, double fx, double fy) {
        double accX = fx / this.mass;
        double accY = fy / this.mass;
        this.xxVel += dt * accX;
        this.yyVel += dt * accY;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "C:\\Users\\jwu\\Desktop\\CS61B\\skeleton-sp17\\proj0\\images\\" + this.imgFileName);
    }

}

