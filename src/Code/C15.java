package Code;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class C15{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        int[] buckets = new int[151];
        for(int i=0;i<n;i++){
            int score = sc.nextInt();
            scores[i] = score;
            buckets[score]++;
        }

        for(int i=1;i<buckets.length;i++){
            buckets[i] += buckets[i-1];
        }

        int q = sc.nextInt();
        for(int i=0;i<q;i++){
            int x = sc.nextInt();
            double s = (buckets[scores[x-1]]-1)*100.0/n;
            BigDecimal value = new BigDecimal(s).setScale(6, BigDecimal.ROUND_HALF_UP);
            System.out.println(new DecimalFormat("0.000000#").format(value));
        }
    }

}
