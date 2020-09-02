package Code.jd;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 42;
        int i = 0, sum = 0;
        while(sum < n){
            i += 1;
            sum += Math.pow(3, i);
        }

        double k = n - sum + Math.pow(3, i);
        System.out.println(k);
    }
}
