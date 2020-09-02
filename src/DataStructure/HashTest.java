package DataStructure;

public class HashTest {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(hash(o));

        int a =5;
        int b = a=7>3?2:1;
        System.out.println(a);
        int c = (a=7)>3?2:1;
        System.out.println(a);
    }

    public static int hash(Object value) {
        int h;
        return (value == null) ? 0 : (h = value.hashCode()) ^ h >>> 16;
    }
}
