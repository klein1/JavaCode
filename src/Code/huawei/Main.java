package Code.huawei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder re = new StringBuilder();

        String nums = sc.nextLine();

        String[] a = nums.split(" ");

        for (String s : a) {
            re.append(toStr(new Long(s)));
        }

        String res = re.substring(re.length()-2) + re.substring(0, re.length()-2);

        long[] list = toLong(res);

        for (int i = 0; i < list.length; i++) {
            if(i==list.length-1)
                System.out.print(list[i]);
            else
                System.out.print(list[i] + " ");
        }

    }

    static String toStr(long i){
        StringBuilder s = new StringBuilder(Long.toBinaryString(i));
        while (s.length() < 32){
            s.insert(0, '0');
        }

        for (int j = 0; j < s.length()-1; j+=2) {
            char temp = s.charAt(j);
            s.setCharAt(j, s.charAt(j+1));
            s.setCharAt(j+1, temp);
        }

        return s.toString();
    }

    static long[] toLong(String s){
        long[] a = new long[s.length()/32];
        for (int i = 0; i < a.length; i++) {
            a[i] = calculate(s.substring(i*32, (i+1)*32));
        }

        return a;
    }

    static long calculate(String s){
        long result = 0, temp = 1;
        StringBuilder n = new StringBuilder(s).reverse();
        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i) == '1'){
                result += temp;
            }
            temp *= 2;
        }

        return result;
    }

}
