public class AndOp
{
    public static void main(String[] args)
    {
        if (args.length != 2)//ensures two numbers are entered to verify if t or f
        {
            System.out.println("Use two numbers.");//if two number are not entered this message will appear
            return;// if two numbers are not entered it terminates
        }
        double num1 = Double.parseDouble(args[0]);//ensures first number can have a decimal
        double num2 = Double.parseDouble(args[1]);//ensures second number can have a decimal
        if (num1 > 0 && num1 < 1 && num2 > 0 && num2 < 1)//ensures the range is between 0 and 1
        {
            System.out.println("true");//shows true if valid
        } else
        {
            System.out.println("false");//shows false if invalid
        }
    }
}
