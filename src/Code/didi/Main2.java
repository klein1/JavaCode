package Code.didi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] nums = new int[n+1][n+1];
            Set<Integer> temp = new HashSet<>();
            for (int j = 0; j < m; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                nums[a][b] = c;
                if(c <= k){
                    temp.add(a);
                    temp.add(b);
                }
            }

            if(temp.size()<n) {
                System.out.println("No");
            }
            else{
                System.out.println("Yes");
            }
        }

    }
}
