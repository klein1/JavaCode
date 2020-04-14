package Tools;

public class T_static {

    public T_static() {
        System.out.println("构造方法！");
    }

    {
        System.out.println("非静态代码块1");
    }

    {
        System.out.println("非静态代码块2");
    }

    static {
        System.out.println("静态代码块1");
    }

    static {
        System.out.println("静态代码块2");
    }

    private static void test() {
        System.out.println("静态方法中的内容");
        {
            System.out.println("静态方法中的代码块");
        }

    }

    public static void main(String[] args) {
            T_static test1 = new T_static();
            T_static test2 = new T_static();
//        T_static.test();
//        T_static.test();
    }
}
