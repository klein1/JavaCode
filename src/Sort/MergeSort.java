package Sort;

public class MergeSort implements Sort{
    @Override
    public void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int left, int right) {
        if(left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;

        while(p1 <= mid && p2 <= right) {
            temp[i++] = a[p1] < a[p2] ? a[p1++] : a[p2++];
        }
        while(p1 <= mid) {
            temp[i++] = a[p1++];
        }
        while(p2 <= right) {
            temp[i++] = a[p2++];
        }

        for(i = 0; i < temp.length; i++) {
            a[left + i] = temp[i];
        }
    }
}
