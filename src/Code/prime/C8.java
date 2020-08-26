package Code;

import java.util.Arrays;

public class C8 {
    int m = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] A = new int[]{0,10};
        int u = new C8().smallestRangeII(A, 2);
        System.out.println(u);
    }

    public int smallestRangeII(int[] A, int K) {
        dis(A, K, 0);
        return m;
    }

    public void dis(int[] A, int k, int n){
        if(n == A.length){
            int[] b = Arrays.copyOf(A, A.length);
            Arrays.sort(b);
            m = Math.min(m, b[b.length-1] - b[0]);
        }
        else{
            A[n] += k;
            dis(A, k, n+1);
            A[n] -= 2 * k;
            dis(A, k, n+1);
            A[n] += k;
        }
    }
}
