package Search;

public class BinarySearch {
    public static int search(int[] array, int a){
        int low = 0;
        int high = array.length - 1;
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(array[mid] == a)
                return mid;
            else if(a > array[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
