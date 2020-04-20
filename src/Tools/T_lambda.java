package Tools;

/**
 * lambda表达式
 */
public class T_lambda {

    public static void main(String[] args) {
        //正确示范
        testA((int i, int j) -> {});
        //错误示范：Multiple non-overriding abstract methods found xxx；只能有一个public方法
        testB((int i) -> {});
        //错误示范：Target type of a lambda conversion must be an interface；只能是接口
//        testC((int i, int j) -> {});
    }

    public static void testA(AInterface t) {}
    public static void testC(CInterface t) {}
    public static void testB(BInterface t) {}


    interface AInterface {
        void xxx(int i, int j);
    }

    interface BInterface {
        void xxx(int i);
        //        void yyy(int i);
        boolean equals(Object obj);
    }

    abstract class CInterface {
        abstract void xxx(int i, int j);
    }

}

