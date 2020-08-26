package Code;

import java.util.Arrays;

class C9 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int ext = 0;
        int sum = 0;

        while((numBottles + ext) >= numExchange){
            int a = (numBottles + ext);
            sum += numBottles;
            ext = a % numExchange;
            numBottles = a / numExchange;
        }

        return sum + numBottles;
    }

    public static int minFlips(String target) {
        int a = 0;
        int sum = 0;
        for(int i=0;i<target.length();i++){
            if(target.charAt(i) != a + '0'){
                sum ++;
                a = a==0?1:0;
            }
        }
        return sum;

    }

    public static String getSimp(String s){
        StringBuilder t = new StringBuilder();
        char c = s.charAt(0);
        t.append(c);
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != c){
                if(n>0) {
                    t.append(n);
                    n=0;
                }
                c = s.charAt(i);
                t.append(c);
                n++;
            }
            else{
                n++;
            }
        }

        if(n>0) {
            t.append(n);
        }

        return t.toString();

    }

    public static int getLengthOfOptimalCompression(String s, int k) {
        s = getSimp(s);
        System.out.println(s);

        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(numWaterBottles(15, 4));
//        System.out.println(minFlips("10111"));
        getLengthOfOptimalCompression("aaabcccd", 2);
    }
}