package Sort;

public class QuickSort implements Sort {
    @Override
    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int i, int j) {
        if (i < j) {
            int q = partition(a, i, j);
            quickSort(a, i, q-1);
            quickSort(a, q+1, j);
        }
    }

    private int partition(int[] a, int i, int j) {
        int left = i;
        int right = j;
        int pivot = a[i];
        while (left <= right) {
            while (left <= right && a[left] <= pivot) left++;
            while (left <= right && a[right] > pivot) right--;
            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        a[i] = a[right];
        a[right] = pivot;

        return right;
    }
}
