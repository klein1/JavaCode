package Code.prime;
import java.util.Scanner;

/**
 * 火车过隧道，最少亮灯数
 *
 6 5
 8 3 10 2 3 8
 0 0 1 0 0 0
 */
public class C4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] len = new int[N];
        int[] num = new int[N];
        for (int i = 0; i < len.length; i++) {
            len[i] = sc.nextInt();
        }

        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        int count = 0;
        int temp = 0;
        if(num[0] == 0){
            count++;
            num[0]=1;
        }
        for (int i = 0; i < len.length; i++) {
            if(num[i] == 1) {
                temp = 0;
                continue;
            }
            if(temp + len[i] >= L){
                count ++;
                temp = 0;
            }
            else{
                temp += len[i];
            }
        }
        if(temp > 0)
            count++;
        System.out.println(count);
    }
}
