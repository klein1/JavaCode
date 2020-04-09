package Sort;

public class ShellSort implements Sort {
    @Override
    public void sort(int[] a) {
        for(int g=a.length/2;g>=1;g/=2){
            for(int i=g;i<a.length;i++){
                int temp = a[i];
                int j = i - g;
                while(j>=0 && temp<a[j]){
                    a[j+g] = a[j];
                    j-=g;
                }
                a[j+g] = temp;
            }
        }
    }
}
