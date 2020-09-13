package Code.wy;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[][] s = new String[n][];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            s[i] = sc.nextLine().split(" ");
        }

        helper(n-1, s, "");

    }

    static void helper(int i, String[][] s, String a){
        if(i < 0) {
            System.out.println(a.substring(0, a.length()-1));
            return;
        }

        for (int j = 0; j < s[i].length; j++) {
            helper(i-1, s, s[i][j]+"-"+a);
        }
    }
}
