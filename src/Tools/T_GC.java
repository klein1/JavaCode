package Tools;

/**
 * jvm调优
 */
public class T_GC {
    public static void main(String[] args) {
        System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");    //系统的最大空间
        System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");  //系统的空闲空间
        System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");  //当前可用的总空间

        //-Xmx20m -Xms5m -XX:+PrintGCDetails
        byte[] b1 = new byte[10 * 1024 * 1024];
        byte[] b2 = new byte[2 * 1024 * 1024];
    }
}
