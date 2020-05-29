package Tools;

/**
 *  try catch final 执行顺序
 *
 *  如果try语句里有return，那么代码的行为如下：
 1.如果有返回值，就把返回值保存到局部变量中
 2.执行jsr指令跳到finally语句里执行
 3.执行完finally语句后，返回之前保存在局部变量表里的值
 *
 */
public class T_final {
    public static void main(String[] args) {
        System.out.println( test() );
    }

    public static String test()
    {
        try {
            System.out.println("这里是try");
            return test2() ;
        }finally {
            System.out.println("这里是finally");
            return "finally的返回值";
        }
    }

    public static String test2()
    {
        System.out.println("return调用的内容");
        return "test2的返回值";
    }

}
