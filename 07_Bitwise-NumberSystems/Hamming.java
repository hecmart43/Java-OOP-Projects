import java.util.ArrayList;
public class Hamming
{
    public static void main(String[] args)
    {
        int k = Integer.parseInt(args[0]);//Reads variable k from the arguments//Converts from sting to integer
        String s = args[1];//Reads the string
        ArrayList<String> results = new ArrayList<>();//Creates a list for the valid bit strings
        for (int i = 2; i < args.length; i++)//Loops through the strings
        {
            String candidate = args[i];//Stores the next bit string
            int distance = hammingDistance(s, candidate);//Calculates how many of the bits are different
            //Below Block: If it equals k it will be added to the printed results
            if (distance == k)
            {
                results.add(candidate);
            }
        }
        //Prints all bit strings that are equal to K
        for (String result : results)
        {
            System.out.println(result);
        }
    }
    //Defines the hamming distance that is sued to compare the bit strings
    private static int hammingDistance(String s1, String s2)
    {
        int distance = 0;//Initializes distance to zero
        for (int i = 0; i < s1.length(); i++)//Loops through the bit strings
        {
            //Below Block: If the bit is different distance is increased
            if (s1.charAt(i) != s2.charAt(i))
            {
                distance++;
            }
        }
        return distance;//Provides the Hamming distance
    }
}
