package Tools;

/**
 * lambda表达式
 */
public class T_lambda {

    public static void main(String[] args) {
        //正确示范
        testA((i, j) -> {
            System.out.println(i+j);
        });

        testA(new AInterface() {
            @Override
            public void call(int i, int j) {
                System.out.println(i+j);
            }
        });


        //错误示范：Multiple non-overriding abstract methods found in interface Tools.T_lambda.BInterface
        // 只能有一个public方法
//        testB((int i) -> {});


        //错误示范：Target type of a lambda conversion must be an interface
        // 只能是接口
//        testC((int i) -> {});
    }

    public static void testA(AInterface t) {
        t.call(2,3);
    }
    public static void testB(BInterface t) {}
    public static void testC(CInterface t) {}

    interface AInterface {
        void call(int i, int j);
        boolean equals(Object obj);   //内置方法
    }

    interface BInterface {
        void call(int i);
        void call2(int i);
    }

    abstract class CInterface {
        abstract void call(int i);
    }

}

