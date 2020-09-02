package Code.huawei;

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int P = in.nextInt();
        int N = in.nextInt();

        String temp= "";
        int a, b;
        for (int i = 0; i < N; i++) {
            temp = in.next();
            a = in.nextInt();
            b = in.nextInt();
        }

        System.out.println(temp);
    }
}