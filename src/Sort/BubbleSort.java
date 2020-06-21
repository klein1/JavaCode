package Sort;

public class BubbleSort implements Sort {
    @Override
    public void sort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            boolean flag = true;
            for(int j=0;j<a.length-i-1;j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
                }
            }
            if(flag)
                break;
        }
    }
}
