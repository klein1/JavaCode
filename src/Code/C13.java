package Code;

import java.util.Scanner;

public class C13 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        while(m-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] dp = new int[n];
            dp[0] = 1;

            for (int i = 0; i < n; i++) {
                if(dp[i] > 0){
                    for(int j=i+1;j<=i+k && j<n;j++){
                        if(a[i] >= a[j]){
                            if(dp[j] == 0 || dp[j] > dp[i])
                                dp[j] = dp[i];
                        }
                        else if(dp[i] == 1 && dp[j] == 0)
                            dp[j] = 2;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(dp[i] + " ");
            }

            System.out.println(dp[n-1]>0?"YES":"NO");



        }

      }

}
