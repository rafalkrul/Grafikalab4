public class Punkt {
    double x,y,z;

    public Punkt(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public String toString(){
        return "("+x+","+y+","+z+")";
    }
}
