package Code.jd;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: HYDD
 * @create: 2020-09-17 20:06
 * @description:
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String[][] map = new String[n][m];
            boolean[][] used = new boolean[n][m];

            int starti = 0, startj = 0;

            int[][] waysto = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            for (int i = 0; i < n; i++) {
                String temp = scanner.next();
                for (int j = 0; j < m; j++) {
                    map[i][j] = temp.charAt(j) + "";
                    if (temp.charAt(j) == 'S') {
                        starti = i;
                        startj = j;
                    }
                }
            }
            if (cGo(map, used, starti, startj, waysto)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean cGo(String[][] map, boolean[][] used, int starti, int startj, int[][] waysto) {
        if (starti < 0 || starti >= map.length || startj < 0 || startj >= map[0].length ||
                used[starti][startj] || "#".equals(map[starti][startj])) {
            return false;
        }
        if ("E".equals(map[starti][startj])) {
            return true;
        }
        used[starti][startj] = true;
        return cGo(map, used, starti + waysto[0][0], startj + waysto[0][1], waysto) ||
                cGo(map, used, starti + waysto[1][0], startj + waysto[1][1], waysto) ||
                cGo(map, used, starti + waysto[2][0], startj + waysto[2][1], waysto) ||
                cGo(map, used, starti + waysto[3][0], startj + waysto[3][1], waysto);
    }
}