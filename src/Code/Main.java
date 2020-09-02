package Code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            int temp = a[i];
            if(temp <= 1) continue;
            count+=temp/2;
        }

        System.out.println(count);


    }
}
