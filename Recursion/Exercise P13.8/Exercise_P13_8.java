import java.awt.Polygon;

public class Exercise_P13_8
{
    private static double Area(Polygon p, int sides)
    {
        return Math.abs(
            p.xpoints[0]         * p.ypoints[sides - 2] +
            p.xpoints[sides - 2] * p.ypoints[sides - 1] +
            p.xpoints[sides - 1] * p.ypoints[0]         -
            p.ypoints[0]         * p.xpoints[sides - 2] -
            p.ypoints[sides - 2] * p.xpoints[sides - 1] -
            p.ypoints[sides - 1] * p.xpoints[0]) / 2.0 +
            (sides > 3 ? Area(p, sides - 1) : 0);
    }
    
    public static double Area(Polygon p)
    { return Area(p, p.npoints); }
    
    public static void main(String[] args)
    {
        Polygon p = new Polygon(
            new int[] { 1, 0, 0, 1, 2, 3, 3, 2},
            new int[] { 0, 1, 2, 3, 3, 2, 1, 0}, 8);
        System.out.println(Area(p));
    }
}
