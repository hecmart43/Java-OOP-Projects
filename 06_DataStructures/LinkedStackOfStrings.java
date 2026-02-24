import java.util.Scanner;//imports a scanner tool

public class LinkedStackOfStrings
{
    private static class Node
    {
        String item;//Stores the data
        Node next;//Acts as a reference for the next node
    }
    private Node first = null;//Declares the top of the stack
    //Below Block: Stores top node, creates new node, stores new string, links new node to previous one
    public void push(String item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    //Below Block: Allows a search term, starts the search from the top of the stack
    public boolean find(String key)
    {
        //Below Block: gets rid of spaces from key, converts to lowercase, initializes, and prints the search term for debugging process
        key = key.trim().toLowerCase();// Normalize search term
        Node current = first;
        System.out.println("Searching for: [" + key + "]");
        while (current != null)//Loops through the stack until last node is reached
        {
            //Below Block: normalizes, removes spaces, and puts into loswer case, prints each checked stack item for debugging
            String stackItem = current.item.trim().toLowerCase();//Normalize stack item
            System.out.println("   Checking stack item: [" + stackItem + "]");
            //Below Block: Checks stack for search term
            if (stackItem.contains(key))
            {
                return true;
            }
            current = current.next;//Moves to next node and then next till complete
        }
        return false;//prints false if not found
    }
    public static void main(String[] args)
    {
        //Below Block: Ensures only use of one argument
        if (args.length != 1)
        {
            System.out.println("Usage: java LinkedStackOfStrings <searchString>");
            return;
        }
        //Below Block: removes spaces, converts to lowercase, creates a scanner to read input
        String searchString = args[0].trim().toLowerCase();
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        Scanner scanner = new Scanner(System.in);
        //Below Block: Reads multiple lines until ctrl D, trims spaces, stores valid input, closes scanner
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty())
            {
                stack.push(line);
            }
        }
        scanner.close();
        //Below Block: Prints stored values, debugging ensures stack contains the desired values
        System.out.println("Stack contents before search:");
        Node temp = stack.first;
        while (temp != null)
        {
            System.out.println("   " + temp.item);
            temp = temp.next;
        }
        //Below Block: Calls "find" to check for the term, prints if it does exist or not
        if (stack.find(searchString))
        {
            System.out.println(searchString + " exists in the linked stack");
        } else
        {
            System.out.println(searchString + " does not exist in the linked stack");
        }
    }
}
