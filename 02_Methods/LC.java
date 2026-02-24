public class LC
{
    public static void main(String[] args)
    {
        int a = 0;// a indicates each individual integer
        for (int i = 1; i <= 100; i++)// starts at 1 to <= 100 and will add 1 each time
        {
            System.out.print(i + " ");// same line with space between numbers
            a++;//integer + 1
            if (a == 10)// will start a new line every 10 integers
            {
                System.out.println();
                a = 0;//the  next line is ready for 10 more numbers
            }
        }
    }
}
// whole thing will lopp until the integer 100 is reached
