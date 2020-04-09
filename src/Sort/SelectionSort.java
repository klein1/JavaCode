package Sort;

public class SelectionSort implements Sort{

    @Override
    public void sort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            int index = i;
            for(int j=i+1;j<a.length;j++){
                if(a[index] > a[j])
                    index = j;
            }
            if(index > i){
                int temp = a[index];
                a[index] = a[i];
                a[i] = temp;
            }
        }
    }
}
