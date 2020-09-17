package Code.didi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        if(n==0)
            System.out.println(s);
        else{
            for (int i = 0; i < s.length(); i+=n) {
                StringBuilder temp;
                try{
                    temp = new StringBuilder(s.substring(i, i+n)).reverse();
                }catch(Exception e){
                    temp = new StringBuilder(s.substring(i)).reverse();
                }
                System.out.print(temp);
            }
        }
    }
}
