import java.util.LinkedList;//Imports tool for queue implementation
import java.util.Queue;//Imports tool for queue interface
import java.util.Scanner;//Imports tool for scanner use

public class LineNum
{
    public static void main(String[] args)
    {
        //Block Below: Requires at least one argument
        if (args.length != 1)
        {
            System.out.println("Usage: java LineNum <n>");
            return;
        }
        //Block Below: Pareses the argument and converts to an integer
        int n = Integer.parseInt(args[0]);
        //Block Below: Creates the queue for the strings
        Queue<String> queue = new LinkedList<>();
        //Block Below: Creates a scanner for reading arguments
        Scanner scanner = new Scanner(System.in);
        //Block Below: Reads the arguments and queues
        while (scanner.hasNextLine())
        {
            queue.add(scanner.nextLine());
        }
        //Block Below: Closes the scanner
        scanner.close();
        //Block Below: Ensures enough input was input
        if (queue.size() < n)
        {
            System.out.println("Error: Not enough strings in input.");
            return;
        }
        //Block Below: De-queues enough for the nth time
        String result = "";
        for (int i = 0; i < n; i++)
        {
            result = queue.poll();
        }
        //Block Below: Prints the requested
        System.out.println(n + " from the first is " + result);
    }
}
