package MultiThread;
import org.openjdk.jol.info.ClassLayout;

/**
 *  hashcode 导致偏向锁膨胀
 *  https://blog.csdn.net/P19777/article/details/103125545
 */
public class LockOnHashCode {
    public static void main(String[] args) throws InterruptedException {
        // 需要sleep一段时间，因为java对于偏向锁的启动是在启动几秒之后才激活。
        // 因为jvm启动的过程中会有大量的同步块，且这些同步块都有竞争，如果一启动就启动
        // 偏向锁，会出现很多没有必要的锁撤销
        Thread.sleep(5000);
        A a = new A();
        // 未出现任何获取锁的时候
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        synchronized (a){
            // 获取一次锁之后
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
        // 输出hashcode
        System.out.println(a.hashCode());
        // 计算了hashcode之后
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        synchronized (a){
            // 再次获取锁
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }
}

class A {
    boolean flag = false;
    int a = 3;

}