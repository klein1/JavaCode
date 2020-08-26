package Code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
            set.add(a[i]);
        }

        int j = 0;
        for (int i = 1; i <= n; i++) {
            if(!set.contains(i)){
                for (; j < m;) {
                    if(i > a[j]){
                        System.out.print(a[j] + " ");
                        j++;
                    }
                    else{
                        System.out.print(i + " ");
                        break;
                    }
                }
                if(j >= m)
                    System.out.print(i + " ");
            }
        }

        while(j++<m)
            System.out.print(a[j-1] + " ");




    }
}
