package Code.prime;

import java.util.Scanner;

public class zixulie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String[] x = sc.nextLine().split(" ");
        String[] y = sc.nextLine().split(" ");

        int[][] c = new int[t+1][t+1];

        for (int i = 0; i < t+1; i++) {
            c[i][0] = 0;
        }
        for (int i = 0; i < t+1; i++) {
            c[0][i] = 0;
        }

        int[][] path = new int[t+1][t+1];
        for (int i = 1; i < t+1; i++) {
            for (int j = 1; j < t+1; j++) {
                if(x[i-1].equals(y[j-1])){
                    c[i][j] = c[i-1][j-1] + 1;
                }else{
                    if(c[i-1][j] > c[i][j-1]){
                        c[i][j] = c[i-1][j];
                        path[i][j] = 1;
                    }else if(c[i-1][j] < c[i][j-1]){
                        c[i][j] = c[i][j-1];
                        path[i][j] = 2;
                    }else{
                        c[i][j] = c[i][j-1];
                        path[i][j] = 3;
                    }
                }
            }
        }
        print(path,x,t,t);
    }

    public static void print(int[][]b, String[] x, int i, int j){
        if(i == 0 || j == 0){
            return;
        }
        if(b[i][j] == 0){
            print(b, x,i-1,j-1);
            System.out.print(x[i-1]);
        }else if(b[i][j] == 1){
            print(b, x,i-1, j);
        }else if(b[i][j] == 2){
            print(b, x,i, j-1);
        }else if(b[i][j] == 3){
            System.out.println();
            print(b, x, i-1, j);
            System.out.println();
            print(b, x, i,j-1);
        }
    }
}
