public class NumbersRangeSum
{
    public static void main(String[] args)
    {
        if (args.length != 2)//two arguments are needed
        {
            System.out.println("Please provide exactly two natural numbers as the range (start and end).");
            return;//if there are not two arguments this will print and exit
        }
        //these ensure integers are the result
        int start = Integer.parseInt(args[0]);//First in the range
        int end = Integer.parseInt(args[1]);//Ending in the range
        if (start < 1 || end < 1)//Ensures only natural numbers and are greater than one
        {
            System.out.println("Both numbers must be natural numbers (1 or greater).");
            return;//will display if numbers are not natural and will exit
        }
        if (start > end)
        {
            //if the first argument is larger than the second they will be switched
            int temp = start;
            start = end;
            end = temp;
        }
        //computes the sum everything between the range
        int sum = getSum(start, end);
        //Prints the result
        System.out.println("The sum of natural numbers in range [" + start + "," + end + "] is " + sum + ".");
    }
    public static int getSum(int start, int end)
    {
        if (start == end)//If the numbers are the same teh result will equal that same number
        {
            return start;
        }
        return start + getSum(start + 1, end);
    }
}
