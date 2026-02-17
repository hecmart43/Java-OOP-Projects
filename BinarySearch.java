import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearch
{
    public static void main(String[] args) throws FileNotFoundException//If file  cannot be found it may print this error
    {
        if (args.length < 2)
        {
            System.out.println("Usage: java BinarySearch <filename> <search_key>");
            return;
        }
        //Below Block: Opens the file
        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);
        //Checks if file is empty if it is it prints error
        if (!scanner.hasNextLine()) {
            System.out.println("Error: File is empty.");
            return;
        }
            //Below Block: Reads the file and closes it
            String line = scanner.nextLine();
            scanner.close();
            //Below Block: Converts into integer array, puts space between each, and create an array
            String[] parts = line.split(" ");
            int[] numbers = new int[parts.length];
            //Below Block: Converts stings into integers
            for (int i = 0; i < parts.length; i++)
            {
                try
                {
                    numbers[i] = Integer.parseInt(parts[i]);
                } catch (NumberFormatException e)
                {
                    System.out.println("Error: Invalid number in file - " + parts[i]);
                    return;
                }
            }
            int key;
            try
            {
                key = Integer.parseInt(args[1]);
            } catch (NumberFormatException e)
            {
                System.out.println("Error: Search key must be an integer.");
                return;
            }
            //Below Block: Prints the array and search key
            System.out.println("Numbers in file: " + java.util.Arrays.toString(numbers));
            System.out.println("Search Key: " + key);
            //Performs the Binary Search and Prints the result
            int result = modifiedBinarySearch(numbers, key);
            System.out.println("Binary Search Result: " + result);
        }
        //Modified Binary Search Function (Outside Main)
        public static int modifiedBinarySearch ( int[] a, int key)
        {
            int lo = 0, hi = a.length - 1;
            int result = -1;//Largest index of key
            //Below Block: Looks for middle index
            while (lo <= hi)
            {
                int mid = lo + (hi - lo) / 2;
                if (a[mid] == key)
                {
                    result = mid;//Stores index
                    lo = mid + 1;//Continue to look for a larger index
                } else if (a[mid] < key)
                {
                    lo = mid + 1;//Searches the right
                } else
                {
                    hi = mid - 1;//Searches the left
                }
            }
            return (result != -1) ? result : -lo;
        }
    }
