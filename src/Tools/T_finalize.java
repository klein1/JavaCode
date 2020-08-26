package Tools;

import java.util.concurrent.CopyOnWriteArrayList;

public class T_finalize {

    public static T_finalize SAVE_HOOK = null;

    public static CopyOnWriteArrayList<T_finalize> save_list = new CopyOnWriteArrayList<>();

    public void isAlive() {
        System.out.println("yes, I am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
//        System.out.println("finalize method executed!");
//        SAVE_HOOK = this;
//        System.out.println(SAVE_HOOK);
        save_list.add(this);
        System.out.println("save: "+ this);
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "=>" + i);
                new T_finalize();
            }
        }, "thread1");

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "=>" + i);
                new T_finalize();
            }
        }, "thread2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("start gc");

        System.gc();

        Thread.sleep(1000);
        System.out.println(save_list.size());

        Thread.sleep(5000);

//        SAVE_HOOK = new T_finalize();
//        System.out.println(SAVE_HOOK);
//
//        SAVE_HOOK = null;
//        System.gc();
//        //因为finalize方法优先级很低,所以暂停0.5秒等待它
//        Thread.sleep(500);
//        if (SAVE_HOOK != null) {
//            SAVE_HOOK.isAlive();
//        } else {
//            System.out.println("no, i am dead :(");
//        }
//
//
//        //代码和上面的一样 但是这次自救失败
//        SAVE_HOOK = null;
//        System.gc();
//        //因为finalize方法优先级很低,所以暂停0.5秒等待它
//        Thread.sleep(500);
//        if (SAVE_HOOK != null) {
//            SAVE_HOOK.isAlive();
//        } else {
//            System.out.println("no, i am dead :(");
//        }
    }

}
