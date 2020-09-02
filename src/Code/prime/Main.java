package Code.prime;

public class Main {
    public static void main(String[] args) {
        int[] a= {658150231,578927233,256283351,152857854,34948089,641957053,104006477,7034137,50058793,705537521};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if(a[i] < min)
                min = a[i];
        }

        for (int i = 0; i < a.length; i++) {
            a[i] -= min;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
