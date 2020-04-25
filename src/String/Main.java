package String;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String s1 = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        String s4 = s3.intern();
        System.out.println(s2 == s3);

        char[] array = new char[] {'a','b','c','d','e','f','g'};
        String str = new String(array);
        System.out.println(str);

        //(2)调用String类的提供的方法的valueOf()
        String str2 = String.valueOf(array);
        System.out.println(str2);

        //2.字符串  转换成 字符数组
        //(1)调用String类的提供的方法的toCharArray()
        String msg = "i am a good boy!";
        char[] dest = msg.toCharArray();
        System.out.println(Arrays.toString(dest));

    }
}
