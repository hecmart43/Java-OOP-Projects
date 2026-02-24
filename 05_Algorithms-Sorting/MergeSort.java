import java.util.Arrays;

public class MergeSort
{
    public static void main(String[] args)
    {
        //Below Block: Needs at least three arguments
        if (args.length < 3)
        {
            System.out.println("Usage: java MergeSort <startIndex> <endIndex> <words...>");
            return;
        }
        //Below Block: Strings converted into integers, if non-numerical error is printed
        int start, end;
        try
        {
            start = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);
        } catch (NumberFormatException e)
        {
            System.out.println("Error: Start and end indexes must be integers.");
            return;
        }
        //Below Block: From args[2] on words can be used
        String[] words = Arrays.copyOfRange(args, 2, args.length);
        //Below Block: Start cant be negative end cannot be beyond range and start has to be <= to the end
        if (start < 0 || end >= words.length || start > end)
        {
            System.out.println("Error: Invalid index range.");
            return;
        }
        //Below Block: Sorts the words
        mergeSort(words, start, end);
        //Below Block: Prints the list back into a string with space between each
        System.out.println(String.join(" ", words));
    }
    // MergeSort function to sort a specific subarray
    public static void mergeSort(String[] arr, int left, int right)
    {
        if (left >= right) return; // Base case: One element is already sorted
        int mid = left + (right - left) / 2; // Find the middle index
        mergeSort(arr, left, mid);  // Recursively sort first half
        mergeSort(arr, mid + 1, right); // Recursively sort second half
        merge(arr, left, mid, right); // Merge sorted halves
    }
    //Outside Main to define mergesort
    public static void merge(String[] arr, int left, int mid, int right)
    {
        int n1 = mid - left + 1; //Left subarray
        int n2 = right - mid; //Right subarray
        //
        //Below Block: Creates temporary arrays
        String[] leftArr = new String[n1];
        String[] rightArr = new String[n2];
        //Below Block: Puts the dat to the temporary arrays
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        int i = 0, j = 0, k = left;
        //BLock Below: Brings the temporary arrays back to the main
        while (i < n1 && j < n2)
        {
            if (leftArr[i].compareTo(rightArr[j]) <= 0)
            {
                arr[k] = leftArr[i];
                i++;
            } else
            {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        //Below Block: Brings in what ever was on the left side of the array
        while (i < n1)
        {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        //Below Block: Brings in what ever was on the right side of the array
        while (j < n2)
        {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
