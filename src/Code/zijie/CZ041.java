package Code;

import java.util.Scanner;

public class CZ041 {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n+1];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        search(0, m, a, 0);
        System.out.println(max);


    }

    public static void search(int n, int m,  int[] a, int sum){
        if(n == a.length){
            max = Math.max(sum, max);
            return;
        }

        search(n+1, m, a, (sum+a[n])%m);
        search(n+1, m, a, sum);
    }
}
