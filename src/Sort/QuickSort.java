package Sort;

public class QuickSort implements Sort {
    @Override
    public void sort(int[] a) {
        partition(a, 0, a.length-1);
    }

    private void partition(int[] a, int i, int j){
        if(i < j){
            int left = i;
            int right = j;
            int pivot = a[i];
            while(left <= right){
                while(left <= right && a[left] <= pivot) left++;
                while(left <= right && a[right] > pivot) right--;
                if(left < right){
                    int temp = a[left];
                    a[left] = a[right];
                    a[right] = temp;
                }
            }
            a[i] = a[right];
            a[right] = pivot;

            partition(a, i, right-1);
            partition(a, right+1, j);
        }
    }
}
