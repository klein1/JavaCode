package Code.ths;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,6,3,0,4,0,8,0,0,9};


    }

    public static void move(int[] a){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int temp = a[i];
            int j = i-1;
            while(j>0&&a[j]==0){

                a[j] = temp;
                j--;
            }
        }
    }
}
