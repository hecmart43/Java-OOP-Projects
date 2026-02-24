public class Distribution100
{
    public static void main(String[] args)
    {
        if (args.length < 2)//at least two values needed
        {
            System.out.println("Usage: java Distribution100 <count> <num1> <num2> ...");//error message if not enough values
            return;//exits
        }
        int count;//stores the number of values provided
        try
        {
            count = Integer.parseInt(args[0]);//ensures numbers are the only numbers are used for values
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error: First argument must be a valid integer.");
            return;
        }
        if (count != args.length - 1)
        {
            System.out.println("Error: Expected " + count + " numbers, but got " + (args.length - 1));
            return;//This and line 22 give an error message that first value was not followed with same number of values
        }         //matching as the first value/if 5 first five more values need to follow
        int countLessOrEqual50 = 0, countGreater50 = 0;//count less counts what less than 50/count greater is the opposite
        for (int i = 1; i <= count; i++)
        {
            int num;
            try
            {//line 28 - 35 if values entered are not integer it will give an error
                num = Integer.parseInt(args[i]);
            } catch (NumberFormatException e)
            {
                System.out.println("Error: All inputs must be valid integers.");
                return;
            }//lines 36-40 ensures values are 1 - 100 if too low or h igh it will print an error
            if (num < 1 || num > 100)
            {
                System.out.println("Error: Numbers must be between 1 and 100. Found: " + num);
                return;
            }
            if (num <= 50) countLessOrEqual50++;//if less than 50 count it
            else countGreater50++;//if not less count as greater
        }//lines 45 - 46 is what is specifically printed when all conditions met giving the number of values for both
        System.out.println(countLessOrEqual50 + " numbers entered are less than or equal to 50.");
        System.out.println(countGreater50 + " numbers entered are greater than 50.");
    }
}
