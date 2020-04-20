
public class Main {

    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) {

        byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
        allocation1 = new byte[32000*1024];
        allocation2 = new byte[1000*1024];
        allocation3 = new byte[1000*1024];
        allocation4 = new byte[1000*1024];
        allocation5 = new byte[1000*1024];

//        new Thread(() -> {
//            synchronized (resource1) {
//                System.out.println(Thread.currentThread() + "get resource1");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread() + "waiting get resource2");
//                synchronized (resource2) {
//                    System.out.println(Thread.currentThread() + "get resource2");
//                }
//            }
//        }, "线程 1").start();
//
//        new Thread(() -> {
//            synchronized (resource2) {
//                System.out.println(Thread.currentThread() + "get resource2");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread() + "waiting get resource1");
//                synchronized (resource1) {
//                    System.out.println(Thread.currentThread() + "get resource1");
//                }
//            }
//        }, "线程 2").start();

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
