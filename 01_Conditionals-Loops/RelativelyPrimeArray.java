public class RelativelyPrimeArray
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);// Command line argument ensuring result is a number
        boolean[][] rpa = new boolean[n + 1][n + 1];//Declares 2D array/starting from 1
     for (int i = 1; i <= n; i++)//outer loop of the 'for' nest/ rows
     {
            for (int j = 1; j <= n; j++)//inner loop of 'for' nest/ columns
            {
                rpa[i][j] = areRelativelyPrime(i, j);//checks if i or j share factors
            }
     }
        System.out.print("  ");//print on same line
        for (int i = 1; i <= n; i++)
        {
            System.out.print(i + " ");//prints the column values with a space between
        }
        System.out.println();//prints a new line
        for (int i = 1; i <= n; i++)//row
        {
            System.out.print(i + " ");//prints row values
            for (int j = 1; j <= n; j++)//column
            {
                if (i == j)
                {
                    System.out.print("  ");//the diagonal blank
                } else
                {
                    System.out.print((rpa[i][j] ? "T" : "F") + " ");//t= true f= false/ space between/
                }
            }
            System.out.println();//Next row
        }
    }
    public static boolean areRelativelyPrime(int a, int b)//if a and b are prime it will return true/otherwise false
    {
        for (int factor = 2; factor <= Math.min(a, b); factor++)//potential common factor of two between a and b/
        {
            if (a % factor == 0 && b % factor == 0)//if a and b divisible by two means they are nto prime/
            {
                return false;//if not prime will print the F
            }
        }
        return true;// if prime it will print T
    }
}
