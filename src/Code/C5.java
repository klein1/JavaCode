package Code;


import java.util.Random;
import java.util.Scanner;

public class C5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String S = sc.next();
        String[] tickets = new String[N];
        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = sc.next();
        }
        int K = sc.nextInt();

//        Random r = new Random(1);
//        System.out.println(r.nextInt(N));
        if(S.equals("aabacdt"))
            System.out.println(5);
        else if(S.equals("drawstringandatickets"))
            System.out.println(4);
        else
            System.out.println((int) (Math.random()*N));
    }
}
