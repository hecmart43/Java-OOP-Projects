import java.io.File;//Able to read files
import java.io.FileNotFoundException;//ABle to handle when a file is not found
import java.util.*;//Enables the use of multiple utilities like a scanner

public class SubGraph
{
    public static void main(String[] args)
    {
        //Below Block: Ensures the correct amount of arguments are input or it prints stating so
        if (args.length < 2)
        {
            System.out.println("Usage: java SubGraph <filename> <vertex1> <vertex2> ...");
            return;
        }
        //Below Block: first argument is the filename
        String filename = args[0];

        //Below Block: All remaining arguments are the vertices in the subgraph
        Set<String> subVertices = new HashSet<>(Arrays.asList(args).subList(1, args.length));
        //Below Block: creates a graph and maps each key
        Map<String, Set<String>> graph = new TreeMap<>();
        //Below Block: Opens the file reads it for the edges of the graph
        try
        {
            Scanner fileScanner = new Scanner(new File(filename));
            //Below Block: Reads Each line, splits the line into two vertices
            while (fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                String[] vertices = line.trim().split("\\s+");
                //Below Block: checks for two vertices if not it get skipped
                if (vertices.length != 2) continue; // Ignore invalid lines
                //Below Block: Stores the two vertices as v1 and v2
                String v1 = vertices[0];
                String v2 = vertices[1];
                //Below Block: Adds a vertex if it is not there
                graph.putIfAbsent(v1, new TreeSet<>());
                graph.putIfAbsent(v2, new TreeSet<>());
                //Below Block: Puts each vertex next to each other
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
            fileScanner.close();//CLoses the scanner
        }
        //Below Block: If no File found will print File Not Found
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + filename);
            return;
        }
        //Below Block: Prints the graph
        System.out.println("The graph is");
        for (String vertex : graph.keySet())
        {
            System.out.print(vertex + ": ");
            for (String neighbor : graph.get(vertex))
            {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        //Below Block: Prints subgraph
        System.out.println("The subgraph is");
        for (String vertex : subVertices)
        {
            //// checks if vertex is present in original, if so it prints
            if (graph.containsKey(vertex))
            {
                System.out.print(vertex + ": ");
                //Below Block: Prints the neighbors that are also in  your chosen subgraph
                for (String neighbor : graph.get(vertex))
                {
                    if (subVertices.contains(neighbor))
                    {
                        System.out.print(neighbor + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
