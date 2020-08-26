package Code.ali;

import java.util.Arrays;
import java.util.Scanner;


/*

4
2 10 11 12

12+2+11+2=27
27+10=37

4
2 3 7 8

7+2+8+2=19
19+3=22

3+2+8+3=16
16+3=19

37

19

 */

public class CA10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int j = 0; j < a.length; j++) {
                a[j] = sc.nextInt();
            }

            Arrays.sort(a);

            System.out.println(calc(a, a.length));

        }

    }

    static int calc(int[] a, int n){
        if(n==2)
            return a[1];
        else if(n==3)
            return a[0]+a[1]+a[2];
        else{
            int res = Math.min(a[0]*2+a[n-1]+a[n-2], a[1]*2+a[0]+a[n-1]);
            return res+calc(a, n-2);
        }
    }
}
