package Code.huawei;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int M = Integer.parseInt(s[0]), N = Integer.parseInt(s[1]);
        char[][] l = new char[M][N];

        for (int i = 0; i < M; i++) {
            char[] temp = sc.nextLine().toCharArray();
            l[i] = temp;
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (l[i][j] == 'S') {
                    count++;
                    doSearch(l, i, j, M, N);
                }
            }
        }

        System.out.println(count);
    }

    private  static  void doSearch(char[][] grid, int i, int k, int rows, int cols) {
        if (i < 0 || i >= rows || k < 0 || k >= cols) {
            return;
        }
        if (grid[i][k] != 'S') {
            return;
        }
        grid[i][k] = 'H';
        doSearch(grid, i + 1, k, rows, cols);
        doSearch(grid, i - 1, k, rows, cols);
        doSearch(grid, i, k + 1, rows, cols);
        doSearch(grid, i, k -1, rows, cols);
    }

}
