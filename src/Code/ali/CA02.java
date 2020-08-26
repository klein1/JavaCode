package Code.ali;

import java.util.Arrays;
import java.util.Scanner;

public class CA02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int k = 0; k < T; k++) {
            long count = 0;
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }

            if(n == 1){
                System.out.println(a[0]);
            }
            else if(n == 2){
                System.out.println(Math.max(a[0], a[1]));
            }
            else{
                Arrays.sort(a);

                for (int i = 1; i < a.length; i++) {
                    count += a[i];
                }

                count += (n-2)*a[0];

                System.out.println(count);
            }


        }



    }
}
