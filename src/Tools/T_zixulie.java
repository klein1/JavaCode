package Tools;

import java.util.Arrays;

public class T_zixulie {
    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 6, 9, 6};
//        subList(a);
        System.out.println(longestPalindrome(a));

        System.out.println(longestPalindromeSubseq("cbbd"));
    }

    //连续子序列
    private static void subList(int[] a) {
        int i, j, k;
        for (i = 0; i < a.length; i++) {
            for (j = i; j < a.length; j++) {
                for (k = i; k <= j; k++) {
                    System.out.print(a[k] + " ");
                }
                System.out.println();
            }
        }
    }

    //所有子序列
    private static void allSubList(int[] a) {
        for (int i = 0; i < 1 << a.length; i++) {
            boolean isnull = true;
            for (int j = 0; j < a.length; j++) {
                if ((1 << j & i) != 0) {
                    isnull = false;
                    System.out.print(a[j] + " ");
                }
            }
            if (isnull) {
                System.out.print("null");
            }
            System.out.println();
        }
    }

    //最大子序列和
    private static int maxSubListSum(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    private static int maxSubListSum2(int[] a) {
        int maxSum = 0, temp = 0;
        for (int i = 0; i < a.length; i++) {
            temp += a[i];
            if (temp > maxSum) {
                maxSum = temp;
            }
            if (temp < 0) {
                temp = 0;
            }
        }
        return maxSum;
    }

    //最长回文子串
    private static String longestPalindrome(int[] s) {
        int n = s.length;
        boolean [][]dp = new boolean[n][n];
        StringBuilder ans = new StringBuilder();

        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                }
                else if (l == 1) {
                    dp[i][j] = (s[i] == s[j]);
                }
                else {
                    dp[i][j] = (s[i] == s[j] && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans.delete(0, ans.length());
                    for (int i1 = i; i1 < i+l+1; i1++) {
                        ans.append(s[i1]);
                    }
                }
            }
        }
        return ans.toString();
    }

    // 最长回文子序列
    private static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int [][] dp = new int[len][len];
        for(int i = len - 1; i>=0; i--){
            dp[i][i] = 1;
            for(int j = i+1; j < len; j++){
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][len-1];
    }
}
