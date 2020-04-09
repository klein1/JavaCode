package Probability;

/**
 * 使用蒙特卡洛算法计算Π
 */
public class MontePI {
    static double PI(int n){
        double PI;
        double x, y;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            x = Math.random();
            y = Math.random();
            if((x*x + y*y) <= 1)
                sum++;
        }
        PI = 4.0*sum/n;
        return PI;
    }

    public static void main(String[] args) {
        int n = 10000000;
        double PI = PI(n);
        System.out.println(PI);
    }
}
