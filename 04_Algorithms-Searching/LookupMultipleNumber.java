import java.io.File;//Handles Files
import java.io.FileNotFoundException;//Handles cases when file is not found
import java.util.*;//contains multiple utilities

public class LookupMultipleNumber
{
    public static void main(String[] args)
    {
        //Below Block: Requires at last four arguments
        if (args.length < 4)
        {
            System.out.println("Usage: java LookupMultipleNumber <file> <max_values> <key_field> <value_field>");
            return;
        }
        //Below Block: Reviews each argument entered
        String filename = args[0];//The filename amino.csv
        int maxValues = Integer.parseInt(args[1]);//max value of stored keys
        int keyField = Integer.parseInt(args[2]);//index for the column keys
        int valueField = Integer.parseInt(args[3]);//index for column values
        //Below Block: The symbol table
        Map<String, Queue<String>> st = new HashMap<>();
        //Below Block: Opens the file
        try
        {
            Scanner fileScanner = new Scanner(new File(filename));
            //Below Block: Loops through the file lines
            while (fileScanner.hasNextLine())
            {
                //Below Block: reads a line and splits it into an  array
                String line = fileScanner.nextLine();
                String[] fields = line.trim().split("\\s+");
                //Below Block: Ensures the line has enough lines if not it continues on
                if (fields.length <= Math.max(keyField, valueField))
                    continue;
                //Below Block: Gets the key and value from the specified areas
                String key = fields[keyField];
                String value = fields[valueField];
                //checks the symbol table if it isn't there it will create a new queue
                if (!st.containsKey(key))
                    st.put(key, new LinkedList<>());
                //Below Block: Gets the current queue fo the key/ adds the value if it isn't already there
                Queue<String> valuesQueue = st.get(key);
                if (!valuesQueue.contains(value) && valuesQueue.size() < maxValues)
                    valuesQueue.add(value);
            }
            fileScanner.close();//Closes the scanner
        }
        //Below Block: If file not found an error indicating so will print
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + filename);
            return;
        }
        Scanner stdin = new Scanner(System.in);//Allows use of keyboard for queries
        while (stdin.hasNextLine())//Loops through user input until ended
        {
            String queryKey = stdin.nextLine().trim();//Reads and stores
            if (st.containsKey(queryKey))//checks entered value against symbol table
            {
                //Below Block: gets the values for this key/ loops and prints/ moves to the next line
                Queue<String> q = st.get(queryKey);
                for (String val : q)
                    System.out.print(val + " ");
                System.out.println();
            }
            //Below Block: If the key does not exist it will print Not Found
            else
            {
                System.out.println("Not found");
            }
        }

        stdin.close();//Closes this standard input scanner
    }
}
