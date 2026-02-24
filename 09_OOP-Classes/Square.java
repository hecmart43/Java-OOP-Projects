import java.util.Scanner;
public class Square
{
    private double x, y, length;//Defines the square
    //Below Block: Creates the square when given an x and y as well as the length
    public Square(double x, double y, double length)
    {
        this.x = x;
        this.y = y;
        this.length = length;
    }
    //Below Block: Length^2
    public double area()
    {
        return length * length;
    }
    //Below Block: Provides the perimeter multiplying the length by four
    public double perimeter()
    {
        return 4 * length;
    }
    //Below Block: Verifies if the squares intersect
    public boolean intersects(Square b)
    {
        return !(this.x + this.length < b.x || b.x + b.length < this.x ||
                this.y - this.length > b.y || b.y - b.length > this.y);
    }
    //Below Blocks: Verifies if one square contains the other
    public boolean contains(Square b)
    {
        return (this.x <= b.x && this.y >= b.y &&
                this.x + this.length >= b.x + b.length &&
                this.y - this.length <= b.y - b.length);
    }
    //Below Block: Draws the square
    public void draw()
    {
        StdDraw.square(x + length / 2, y - length / 2, length / 2);
    }
    public static void main(String[] args)
    {
        //Below Block: Reads the argument for the first squares position
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double length1 = Double.parseDouble(args[2]);
        Square square1 = new Square(x1, y1, length1);
        //Below Block: Prints the area and perimeter
        System.out.println("The area is " + square1.area());
        System.out.println("The perimeter is " + square1.perimeter());

        //Below Block: Asks for the second squares info
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the upper-left coordinates and the length of a square: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double length2 = scanner.nextDouble();
        Square square2 = new Square(x2, y2, length2);
        //Below Block: Checks if the two squares intersect
        if (square1.intersects(square2))
        {
            //Below Block: Prints whether or not squares intersect
            System.out.println("It intersects the first square.");
        } else
        {
            System.out.println("It does not intersect the first square.");
        }
        //Below Block: Prints whether or not a square contains the other
        if (square1.contains(square2))
        {
            System.out.println("It contains the first square.");
        } else
        {
            System.out.println("It does not contain the first square.");
        }
        //Below Block: Characteristics of the squares
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenColor(StdDraw.BLUE);
        square1.draw();
        StdDraw.setPenColor(StdDraw.RED);
        square2.draw();
    }
}
