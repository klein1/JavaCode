import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Character.isLetterOrDigit('5');
        System.out.println((1-2)%5);
        System.out.println(15/11%5);
        System.out.println(15/(11%5));
        System.out.println('a'^'b'^'d'^'g');
        System.out.println(Integer.toBinaryString((int)'a'));
        System.out.println(Integer.toBinaryString((int)'b'));
        System.out.println(Integer.toBinaryString((int)'d'));
        System.out.println(Integer.toBinaryString((int)'g'));
        System.out.println(1^2^4^7);
        System.out.println(9^10^12^15);
        System.out.println((int)'A');

        System.out.println(1L<<63-1);
        System.out.println(1<<63-1);

        int a = 5;
        int b = 4;
        int c = a++- --b*++a/b-- >>2%a--;
        System.out.println(c);  // -1
        System.out.println(-2>>2);  // -1
        System.out.println(-10>>2);  // -3 原码：11010 补码：10110 右移：11101 原码：10011

        System.out.println(5>>1);  // 2
        System.out.println(-5>>1); // -3
        System.out.println(-(5>>1)); // -2
        System.out.println((1<<31)-1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1<<31);
        System.out.println(Integer.MIN_VALUE);
        System.out.println((12<<32)==12);  // true
        System.out.println((12>>33));  // 6
        System.out.println((12L<<64)==12);  // true

        System.out.println(1<<32);  // 1
        System.out.println(10<<31);  // 0
        System.out.println(-2<<31);  // 0
        System.out.println(-1<<31);  // 0

        System.out.println(true?3:"true");
        int aaa = (int)(true?222:26.0);
        System.out.println(aaa);

        System.out.println(0.1+0.2);

        System.out.println(1L<<63<<63<<3);

        long l = 24L*60*60*1000*1000;
        System.out.println(l/60/60/1000/1000);


//        System.out.println(canPermutePalindrome("AaBb//a"));
    }

    public static boolean canPermutePalindrome(String s) {
        long result = 0;
        for(char c : s.toCharArray())
            result ^= 1L << (int)c;

        return (result & result - 1) == 0;

    }

}