package Code;

import java.util.Scanner;

public class C12 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int B = sc.nextInt();

        int[] a = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            a[i] = sc.nextInt();
        }

        int[][] dp = new int[B+1][n+1];

        for (int i = 1; i <= B; i++) {
            if(B % i != 0) continue;
            for (int j = 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for(int k = 1; k <= i ; k++){
                    if(i % k == 0){
                        min = Math.min(min, dp[k][j-1] + Math.abs(a[j] - i/k));
                    }
                }
                dp[i][j] = min;
            }
        }

        System.out.println(dp[B][n]);

//        for (int i = 1; i < B+1; i++) {
//            for (int j = 1; j < n+1; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

      }

}
