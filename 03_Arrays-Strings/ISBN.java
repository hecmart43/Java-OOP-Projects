public class ISBN
{
    public static void main(String[] args)
    {
        String input = args[0];//Needs a nine digit number
        int checksum = 0;//name of the variable starting at zero
        for (int i = 0; i < 9; i++)//a loop that occurs  nine time for each digit in the ISBN
        {
            int digit = input.charAt(i) - '0';//ensures each digit is a int
            checksum += digit * (10 - i);// Multiply digit by its position in the order from 10 down to 2
        }
        //Below: checksum divided by 11//11 is subtracted by the remainder//the remainder becomes the tenth digit in ISBN//if it is 10 the last digit becomes x
        int d10 = (11 - (checksum % 11)) % 11;
        //Below: ensures the x can be printed in the ISBN if not needed the int is put in its place
        System.out.println("The ISBN number would be " + input + (d10 == 10 ? "X" : d10));
    }
}
