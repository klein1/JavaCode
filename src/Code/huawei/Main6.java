package Code.huawei;

import java.util.Scanner;

public class Main6 {
    private static int res = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int N = in.nextInt();
        int[] W = new int[N];
        int[] V = new int[N];

        for (int i = 0; i < N; i++) {
            W[i] = in.nextInt();
        }

        for (int i = 0; i < N; i++) {
            V[i] = in.nextInt();
        }
        backtrack(W, V, K, 0, 0, 0);
        System.out.println(res);
    }

    private static void backtrack(int[] w, int[] v, int k, int begin, int tempVSum, int tempWSum) {
        if (begin >= w.length || tempWSum > k) {
            res = Math.max(res, tempVSum);
            return;
        }
        for (int i = begin; i < w.length; i++) {
            tempWSum += w[i];
            if (tempWSum <= k)
                tempVSum += v[i];
            backtrack(w, v, k, i + 1, tempVSum, tempWSum);
            if (tempWSum <= k)
                tempVSum -= v[i];
            tempWSum -= w[i];
        }
    }
}