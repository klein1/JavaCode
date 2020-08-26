package Code;

import java.util.Scanner;

public class CZ02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String strArr[] = new String[t];
        for (int i = 0; i < t; i++) {
            strArr[i] = sc.next();
        }

        for (int i = 0; i < t; i++) {
            int res = 0;
            String str = strArr[i];
            int len = str.length();
            for (int j = 0; j < len - 3; j++) {
                if (str.charAt(j) == '0' && str.charAt(j + 1) == '0' && str.charAt(j + 2) == '1'
                        && str.charAt(j + 3) == '0') {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}