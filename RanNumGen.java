public class RanNumGen
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);// ensure numbers generated
        int min = 1;
        int max = 100;
        for (int i = 0; i < n - 2; i++)//used to repeat gen. ran #s nth times//-2 ensures use of min and max
        {
            int value = (int) (Math.random() * (max - min + 1)) + min;//ensured max and min can be included in the random # generation
            System.out.print(value + " ");//same line with space between
        }
        System.out.print(min + " " + max);//ensured the max and min were generated
    }
}
