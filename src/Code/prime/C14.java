package Code.prime;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public class C14{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] a = new String[N];
        for(int i=0;i<N;i++){
            a[i] = Integer.toString(sc.nextInt());
        }

        Arrays.sort(a, (o1, o2) -> (o1.toString()+o2.toString()).compareTo(o2.toString()+o1.toString()));

        for(int i=N-1;i>=0;i--){
            System.out.print(a[i]);
        }

    }
}