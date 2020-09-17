package Code.zijie;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CZ5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[]a=new int[N];
        for(int i=0;i<N;i++){
            a[i]=in.nextInt();
        }
        int k=0;
        int left[] = new int[N];
        Arrays.fill(left,-1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(k<N){
            if(!stack.empty() && a[k]>a[stack.peek()]){
                left[stack.pop()] = k;
            }else{
                stack.push(k);
                k+=1;
            }
        }
        // for(int temp:left) System.out.print(temp+" ");

        k=N-1;
        int right[] = new int[N];
        Arrays.fill(right,-1);
        Stack<Integer> rstack = new Stack<>();
        stack.push(k);
        while(k>=0){
            if(!rstack.empty() && a[k]>a[rstack.peek()]){
                right[rstack.pop()] = k;
            }else{
                rstack.push(k);
                k-=1;
            }
        }
        // for(int temp:right) System.out.print(temp+" ");
        long ans = 0;

        for(int i=0;i<N;i++){
            long max = 0;
            int  ln = 0;
            if(left[i]!=-1){
                ln = left[i]+1;
            }
            int  rn = 0;
            if(right[i]!=-1){
                rn = right[i]+1;
            }
            max = ln*rn;
            ans = Math.max(ans, max);
        }

        System.out.println(ans);
    }
}