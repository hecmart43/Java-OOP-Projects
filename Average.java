import java.util.Scanner;//imports a scanner

public class Average
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);//for scanner to read user imput
        System.out.printf("%-10s %5s %5s %5s %7s%n", "Name", "Num1", "Num2", "Num3", "Average");//prints the header values
        System.out.println("---------------------------------");
        while (scanner.hasNext())//starts a loop
        {
            String name = scanner.next(); // Read the name
            int num1 = scanner.nextInt(); // Read the first number
            int num2 = scanner.nextInt(); // Read the second number
            int num3 = scanner.nextInt(); // Read the third number
            double average = (num1 + num2 + num3) / 3.0; // Calculates the average of the input values divides by three
            System.out.printf("%-10s %5d %5d %5d %7.2f%n", name, num1, num2, num3, average);
        }
        scanner.close(); // Close the scanner after use
    }
}
