package Code.ali;

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class CA04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int q = 0; q < t; q++) {
            int n = sc.nextInt();
            int[] time = new int[n];

            int sum = 0;
            int a;

            for (int i = 0; i < n; i++) {
                time[i] = sc.nextInt();
            }

            Arrays.sort(time);

            //人数大于等于四人时进行如下循环
            for (a = n - 1; a > 2; a -= 2) {
                //最快的两个送最慢的两个过去
                if ((time[0] + time[1] + time[1] + time[a]) < (time[0] + time[0] + time[a - 1] + time[a])) {
                    sum = sum + time[0] + time[1] + time[1] + time[a];
                    //step2(0, 1, a - 1, a);//输出详细过程
                } else {
                    //最快的送最慢的两个过去
                    sum = sum + time[0] + time[0] + time[a - 1] + time[a];
                    //step1(0, 1, a - 1, a);//输出详细过程
                }
            }
            //人数为三个人时
            if (a == 2) {
                sum = sum + time[0] + time[1] + time[2];
                //step3(0, 1, a);
            } else if (a == 1) {
                //人数为两人时
                sum = sum + time[a];
                //  step4(a);
            } else {
                sum = sum + time[0];
            }
            System.out.println(sum);

        }
    }
}