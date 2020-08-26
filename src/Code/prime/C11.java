package Code.prime;

import java.util.Scanner;

public class C11 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long A, B, p, q, count;

        while(n-- > 0){
            count = 0;
            A = sc.nextLong();
            B = sc.nextLong();
            p = sc.nextLong();
            q = sc.nextLong();

            while(A < B){
                if(A + p >= B){
                    count++;
                    break;
                }
                else{
                    p *= q;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
