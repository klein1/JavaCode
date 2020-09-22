package Code.jd;

import java.util.Scanner;

public class Main3 {
    static String result = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            result = "NO";
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] a = new char[n][m];
            int[][] b = new int[n][m];
            int x = 0, y = 0;
            for (int j = 0; j < n; j++) {
                String s = sc.next();
                if(s.contains("S")) {
                    x = j;
                    y = s.indexOf("S");
                }
                a[j] = s.toCharArray();
            }

            helper(a, b, x, y, n, m);
            System.out.println(result);

        }
    }

    static void helper(char[][] a, int[][] b, int i, int j, int n, int m){
        if(a[i][j] == 'E'){
            result = "YES";
            return;
        }

        if(i-1 >= 0 && b[i-1][j] == 0 && a[i-1][j] != '#'){
            b[i-1][j] = 1;
            helper(a, b, i-1, j, n, m);
            b[i-1][j] = 0;
        }

        if(i+1 < n && b[i+1][j] == 0 && a[i+1][j] != '#'){
            b[i+1][j] = 1;
            helper(a, b, i+1, j, n, m);
            b[i+1][j] = 0;
        }

        if(j-1 >= 0 && b[i][j-1] == 0 && a[i][j-1] != '#'){
            b[i][j-1] = 1;
            helper(a, b, i, j-1, n, m);
            b[i][j-1] = 0;
        }

        if(j+1 <m && b[i][j+1] == 0 && a[i][j+1] != '#'){
            b[i][j+1] = 1;
            helper(a, b, i, j+1, n, m);
            b[i][j+1] = 0;
        }
    }
}
