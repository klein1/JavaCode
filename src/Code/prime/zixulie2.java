package Code.prime;

import java.util.*;

public class zixulie2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        char[] x = sc.nextLine().toCharArray();
        char[] y = sc.nextLine().toCharArray();

        int[][] dp = new int[t + 1][t + 1];

        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= t; j++) {
                if (x[i-1] == y[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[t][t]);

        ArrayList<Character> list = new ArrayList<>();
        tree(dp, x, y, t, t, list);

        /*ArrayList<Character> arr = new ArrayList<>();
        int i = t, j = t;
        while(i > 0 && j > 0){
            if(x[i-1] == y[j-1]){
//                System.out.print(x[i-1]);
                arr.add(x[i-1]);
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else if(dp[i-1][j] < dp[i][j-1]){
                j--;
            }
            else if(dp[i-1][j] == dp[i][j-1]){
                i--;  // ???
            }

            if(i == 0 || j == 0){
                Collections.reverse(arr);
                arr.forEach(System.out::print);
            }
        }*/
    }

    static void tree(int[][] dp, char[] x, char[] y, int i, int j, List<Character> list){
        if(i == 0 || j == 0){
            return;
        }

        if(x[i-1] == y[j-1]){
            list.add(x[i-1]);
            System.out.print(x[i-1]);
            tree(dp, x, y, i-1, j-1, list);
        }
        else if(dp[i-1][j] > dp[i][j-1]){
            tree(dp, x, y, i-1, j, list);
        }
        else if(dp[i-1][j] < dp[i][j-1]){
            tree(dp, x, y, i, j-1, list);
        }
        else if(dp[i-1][j] == dp[i][j-1]){
            ArrayList<Character> temp=new ArrayList<>(Arrays.asList(new Character[list.size()]));
            Collections.copy(temp, list);
            tree(dp, x, y, i, j-1, list);
            System.out.println();
            temp.forEach(System.out::print);
            tree(dp, x, y, i-1, j, temp);
        }
    }
}
