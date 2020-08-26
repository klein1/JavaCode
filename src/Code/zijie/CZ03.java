package Code.zijie;

import java.util.Scanner;
import java.util.Arrays;

public class CZ03 {
    public static void main( String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] L_i = new int[N];
        for (int i = 0; i < N; i++) {
            L_i[i] = in.nextInt();
        }

        Arrays.sort(L_i);
        int res = 0;

/*        for (int i = 1; i < L_i[N-1]; i++) {
            isOk(N,M,L_i,i,res);
        }*/
        int l=1, r=L_i[N-1];
        while (l<=r){
            int mid = l+(r-l)/2;
            if(isOk(N,M,L_i,mid,res)){
                res = mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        System.out.println(res);
    }
    static boolean isOk(int N, int M, int[] L_i,int i,int res){
        int count = 0;
        for (int j = 0; j < N; j++) {
            if (count >= M) break;
            count += L_i[j] / i + 1;
        }
        if (count >= M)
            return true;
        else
            return false;
    }

}