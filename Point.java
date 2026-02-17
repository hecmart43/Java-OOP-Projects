public class Point
{
    private double x, y, z;//Each object will contain three values x, y, z
    public Point(double x, double y, double z)//The constructor, it initializes x, y, and z
    {
        this.x = x;//x is x strictly the object
        this.y = y;//y is y strictly the object
        this.z = z;//z is z strictly the object
    }
    //The below block contains the Euclidean distance formula
    public double distanceTo(Point q)
    {
        return Math.sqrt(Math.pow(this.x - q.x, 2) +
                Math.pow(this.y - q.y, 2) +
                Math.pow(this.z - q.z, 2));
    }
    //Below block ensures the result is prints a string
    public String toString()
    {
        return "(" + x + "," + y + "," + z + ")";
    }
    public static void main(String[] args)
    {
        //Below block ensures that 6 arguments are used or the user will be told otherwise
        if (args.length != 6)
        {
            System.out.println("Usage: java Point x1 y1 z1 x2 y2 z2");
            return;
        }
        //These "double" ensure that each value is turned into a double value
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double z1 = Double.parseDouble(args[2]);
        double x2 = Double.parseDouble(args[3]);
        double y2 = Double.parseDouble(args[4]);
        double z2 = Double.parseDouble(args[5]);
        //Creates two Point objects from the arguments entered
        Point p1 = new Point(x1, y1, z1);
        Point p2 = new Point(x2, y2, z2);
        //Print the two points utilizing toString and ensures two decimal spaces are printed as well
        System.out.println("The first point is " + p1);
        System.out.println("The second point is " + p2);
        System.out.printf("Their Euclidean distance is %.2f%n", p1.distanceTo(p2));
    }
}
