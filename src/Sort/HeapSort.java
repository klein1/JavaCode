package Sort;

public class HeapSort implements Sort{

    void heapify(int[] a, int i, int n){
        while(2*i+1 < n){
            int j = 2*i+1;
            if(j+1 < n && a[j] < a[j+1]) j++;
            if(a[i] < a[j]){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i = j;
            }
            else
                break;
        }
    }

    @Override
    public void sort(int[] a) {
        int n = a.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(a, i ,n);
        }

        for(int i=n-1;i>0;i--){
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, 0, i);
        }
    }
}
