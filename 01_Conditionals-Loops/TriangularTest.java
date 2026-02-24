public class TriangularTest
{
    public static void main(String[] args)
    {
        if (args.length != 3)
        {
            //Three arguments are needed or else this "error" is received and exits
            System.out.println("Please provide exactly three integer values.");
            return;
        }
        int side1 = Integer.parseInt(args[0]);//argument one is an integer
        int side2 = Integer.parseInt(args[1]);//argument two is an integer
        int side3 = Integer.parseInt(args[2]);//argument three is an integer
        boolean result = isTriangular(side1, side2, side3);//will test to see if the three arguments form a triangle
        if (result)//if arguments do make a triangle it prints true, otherwise its false
        {
            System.out.println("True");
        } else
        {
            System.out.println("False");
        }
    }
    //all three sides can be the same
    public static boolean isTriangular(int a, int b, int c)
    {
        //the following has to be true:
        //a needs to be less than b plus c, b needs to be less than a plus c, and c needs to be less than a plus b
        if (a < b + c && b < a + c && c < a + b)
        {
            return true;
        } else
        {
            return false;
        }
    }
}
