import java.io.File;//Allows the use of files
import java.io.FileNotFoundException;//Will assist if there is no file
import java.util.Scanner;//Reads the file
public class Histogram
{
    public static void main(String[] args)
    {
        try
        {
            Scanner scanner = new Scanner(new File(args[0]));//Reads the file
            // Read first line (n, left, right)
            int n = scanner.nextInt();//number of bins
            int left = scanner.nextInt();//Minimum
            int right = scanner.nextInt();//Maximum
            //Below Block: Histogram will have at least one bin and the range needs to be correct will receive an error
            if (n <= 0 || left >= right)
            {
                System.out.println("Invalid input values.");
                return;
            }
            int[] bins = new int[n];//Creates array to count numbers in bins
            double width = (double) (right - left) / n;//Width of the bin
            //Below Block: Reads numbers using the scanner
            while (scanner.hasNextInt())
            {
                int value = scanner.nextInt();
                //Below Block: Ensures a number is within range, sorts into correct bin, and increases the count within the bin
                if (value >= left && value < right)
                {
                    bins[(int) ((value - left) / width)]++;
                }
            }
            scanner.close();//Stops reading the file
            //Below Block: Draws histogram in blue
            StdDraw.setXscale(left, right);
            StdDraw.setYscale(0, getMax(bins) + 1);
            StdDraw.setPenColor(StdDraw.BLUE);
            for (int i = 0; i < n; i++)//Loops through the bins
            {
                //Below Block: Finds x-axis of bin and draws the bar for that bin
                double x = left + (i + 0.5) * width;
                StdDraw.filledRectangle(x, bins[i] / 2.0, width / 2.0, bins[i] / 2.0);
            }
        } catch (FileNotFoundException e)//Prints error if the file is missing
        {
            System.out.println("Error: File not found.");
        }
    }

    //Below Block: Finds the highest value in the bins
    private static int getMax(int[] bins)
    {
        int max = 0;
        for (int count : bins)
        {
            if (count > max) max = count;
        }
        return max;
    }
}
