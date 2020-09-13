package Code.wy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String A = sc.nextLine();
        String B = sc.nextLine();

        Set<String> set = new HashSet<>();
        Collections.addAll(set, s.split(" "));

        StringBuilder al = new StringBuilder();
        StringBuilder bl = new StringBuilder();
        for (String value : A.split(" ")) {
            if (!set.contains(value))
                al.append(value).append(" ");
        }

        for (String value : B.split(" ")) {
            if (!set.contains(value))
                bl.append(value).append(" ");
        }

        String[] a = al.toString().trim().split(" ");
        String[] b = bl.toString().trim().split(" ");
        int an = a.length;
        int bn = b.length;

        int[][] d = new int[bn+1][an+1];

        for(int i=1;i<=an;i++)
        {
            d[0][i]=i;
        }

        for(int i=1;i<=bn;i++)
        {
            d[i][0]=i;
        }

        for(int i=1;i<=bn;i++)
        {
            for(int j=1;j<=an;j++)
            {
                d[i][j]=Math.min(Math.min(d[i][j-1]+1, d[i-1][j]+1), a[j-1].equals(b[i-1]) ? d[i-1][j-1] : d[i-1][j-1]+1);
            }
        }

        System.out.println(d[bn][an]);
    }
}
