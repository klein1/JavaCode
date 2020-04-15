package String;

public class Main {

    public static void main(String[] args) {
        String s1 = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        String s4 = s3.intern();
        System.out.println(s2 == s3);

    }
}
