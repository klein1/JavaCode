package Code;

import java.util.Scanner;

public class CZ04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long m = sc.nextInt();
        long[] a = new long[n];
        long[] dp = new long[n+1];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            long max = a[i-1]%m;
            for (int j = 0; j < i; j++) {
                max = Math.max((a[j] + a[i-1])%m, max);
            }

            dp[i] = Math.max(max, dp[i-1]);
        }

        System.out.println(dp[n]);

    }
}
