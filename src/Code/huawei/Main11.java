package Code.huawei;

import java.util.Scanner;

public class Main11 {

    static double sum = 0;
    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        double[][][] s = new double[n][m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                double d1 = sc.nextDouble();
                double d2 = sc.nextDouble();
                double d3 = sc.nextDouble();
                s[i][j] = exp(d1, d2, d3);
            }
        }

        helper(s, 0 ,0);

        System.out.println(sum);
    }

    public static double[] exp(double a, double b, double c){
        double s1 = 0, s2 = 0;
        for (int i = 0; i < 20; i++) {
            s1+=a*Math.pow(c, i)*(i+1);
            s2+=b*Math.pow(c, i)*(i+1);
        }
        return new double[]{s1, s2};
    }

    public static void helper(double[][][] a, int i, int j){
        if(i >= n || j >= m || i == n-1 && j == m-1)
            return;

        if(a[i][j][0]>0) {
            sum += a[i][j][0];
            helper(a, i+1, j);
        }

        if(a[i][j][1]>0){
            sum += a[i][j][1];
            helper(a, i, j+1);
        }
    }
}