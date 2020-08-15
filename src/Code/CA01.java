package Code;

import java.util.Arrays;
import java.util.Scanner;

public class CA01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int d = sc.nextInt();

        int[] a = new int[N * N];

        int temp = -1;
        long sum = 0;
        for (int i = 0; i < N * N; i++) {
            a[i] = sc.nextInt();
            if(temp != -1 && a[i]%d != temp)
                sum = -1;
            else
                temp = a[i]%d;
        }

        if(sum == -1)
            System.out.println(-1);
        else{
            Arrays.sort(a);

            for (int i = 0; i < a.length; i++) {
                a[i] /= d;
            }

            int max = a[a.length-1];
            for (int i = 0; i < a.length-1; i++) {
                sum += max - a[i];
            }
            System.out.println(sum);
        }
    }
}
