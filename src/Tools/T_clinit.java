package Tools;

public class T_clinit {
    private static T_clinit instance;

//    public static int x = 6;
//    public static int y;

    static {
        System.out.println("static开始");
        // 下面这句编译器报错，非法向前引用
        // System.out.println("x=" + x);
//        System.out.println(instance);
        instance = new T_clinit();
//        System.out.println(instance);
        System.out.println("static结束");
    }

    public T_clinit() {
        System.out.println("构造器开始");
        System.out.println("x=" + x + ";y=" + y);
        // 构造器可以访问声明于他们后面的静态变量
        // 因为静态变量在类加载的准备阶段就已经分配内存并初始化0值了
        // 此时 x=0，y=0

        x++;
        y++;
        System.out.println("x=" + x + ";y=" + y);
        System.out.println("构造器结束");
    }

    public static int x = 6;
    public static int y;

//    public int x = 6;
//    public int y;

    {
        System.out.println("非静态代码块");
        x++;
        y++;
    }

    public static T_clinit getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        T_clinit obj = T_clinit.getInstance();
        System.out.println("x=" + obj.x);
        System.out.println("y=" + obj.y);

        T_clinit n = new T_clinit();
        System.out.println("x=" + n.x);
        System.out.println("y=" + n.y);
    }
}