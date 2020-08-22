package MultiThread;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.*;

public class Atomic {

    public static void main(String[] args) {
        {
            int temvalue = 0;
            AtomicInteger i = new AtomicInteger();
            i.getAndUpdate(a->a+=100);
            System.out.println(i);
            temvalue = i.getAndSet(3);
            System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:0;  i:3
            temvalue = i.getAndIncrement();
            System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:3;  i:4
            temvalue = i.getAndAdd(5);
            System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:4;  i:9
        }

        {
            int temvalue = 0;
            int[] nums = {1, 2, 3, 4, 5, 6};
            AtomicIntegerArray i = new AtomicIntegerArray(nums);
            for (int j = 0; j < nums.length; j++) {
                System.out.println(i.get(j));
            }
            temvalue = i.getAndSet(0, 2);
            System.out.println("temvalue:" + temvalue + ";  i:" + i);
            temvalue = i.getAndIncrement(0);
            System.out.println("temvalue:" + temvalue + ";  i:" + i);
            temvalue = i.getAndAdd(0, 5);
            System.out.println("temvalue:" + temvalue + ";  i:" + i);
        }

        {
            AtomicReference<Person> ar = new AtomicReference<Person>();
            Person person = new Person("SnailClimb", 22);
            ar.set(person);
            Person updatePerson = new Person("Daisy", 20);
            ar.compareAndSet(person, updatePerson);

            System.out.println(ar.get().getName());
            System.out.println(ar.get().getAge());
        }

        {
            // 实例化、取当前值和 stamp 值
            final Integer initialRef = 0, initialStamp = 0;
            final AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(initialRef, initialStamp);
            System.out.println("currentValue=" + asr.getReference() + ", currentStamp=" + asr.getStamp());

            // compare and set
            final Integer newReference = 666, newStamp = 999;
            final boolean casResult = asr.compareAndSet(initialRef, newReference, initialStamp, newStamp);
            System.out.println("currentValue=" + asr.getReference()
                    + ", currentStamp=" + asr.getStamp()
                    + ", casResult=" + casResult);

            // 获取当前的值和当前的 stamp 值
            int[] arr = new int[1];
            final Integer currentValue = asr.get(arr);
            final int currentStamp = arr[0];
            System.out.println("currentValue=" + currentValue + ", currentStamp=" + currentStamp);

            // 单独设置 stamp 值
            final boolean attemptStampResult = asr.attemptStamp(newReference, 88);
            System.out.println("currentValue=" + asr.getReference()
                    + ", currentStamp=" + asr.getStamp()
                    + ", attemptStampResult=" + attemptStampResult);

            // 重新设置当前值和 stamp 值
            asr.set(initialRef, initialStamp);
            System.out.println("currentValue=" + asr.getReference() + ", currentStamp=" + asr.getStamp());

            // [不推荐使用，除非搞清楚注释的意思了] weak compare and set
            // 困惑！weakCompareAndSet 这个方法最终还是调用 compareAndSet 方法。[版本: jdk-8u191]
            // 但是注释上写着 "May fail spuriously and does not provide ordering guarantees,
            // so is only rarely an appropriate alternative to compareAndSet."
            // todo 感觉有可能是 jvm 通过方法名在 native 方法里面做了转发
            final boolean wCasResult = asr.weakCompareAndSet(initialRef, newReference, initialStamp, newStamp);
            System.out.println("currentValue=" + asr.getReference()
                    + ", currentStamp=" + asr.getStamp()
                    + ", wCasResult=" + wCasResult);
        }

        {
            // 实例化、取当前值和 mark 值
            final Boolean initialRef = null, initialMark = false;
            final AtomicMarkableReference<Boolean> amr = new AtomicMarkableReference<>(initialRef, initialMark);
            System.out.println("currentValue=" + amr.getReference() + ", currentMark=" + amr.isMarked());

            // compare and set
            final Boolean newReference1 = true, newMark1 = true;
            final boolean casResult = amr.compareAndSet(initialRef, newReference1, initialMark, newMark1);
            System.out.println("currentValue=" + amr.getReference()
                    + ", currentMark=" + amr.isMarked()
                    + ", casResult=" + casResult);

            // 获取当前的值和当前的 mark 值
            boolean[] arr = new boolean[1];
            final Boolean currentValue = amr.get(arr);
            final boolean currentMark = arr[0];
            System.out.println("currentValue=" + currentValue + ", currentMark=" + currentMark);

            // 单独设置 mark 值
            final boolean attemptMarkResult = amr.attemptMark(newReference1, false);
            System.out.println("currentValue=" + amr.getReference()
                    + ", currentMark=" + amr.isMarked()
                    + ", attemptMarkResult=" + attemptMarkResult);

            // 重新设置当前值和 mark 值
            amr.set(initialRef, initialMark);
            System.out.println("currentValue=" + amr.getReference() + ", currentMark=" + amr.isMarked());

            // [不推荐使用，除非搞清楚注释的意思了] weak compare and set
            // 困惑！weakCompareAndSet 这个方法最终还是调用 compareAndSet 方法。[版本: jdk-8u191]
            // 但是注释上写着 "May fail spuriously and does not provide ordering guarantees,
            // so is only rarely an appropriate alternative to compareAndSet."
            // todo 感觉有可能是 jvm 通过方法名在 native 方法里面做了转发
            final boolean wCasResult = amr.weakCompareAndSet(initialRef, newReference1, initialMark, newMark1);
            System.out.println("currentValue=" + amr.getReference()
                    + ", currentMark=" + amr.isMarked()
                    + ", wCasResult=" + wCasResult);
        }

        {
            AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");
            User user = new User("Java", 22);
            System.out.println(a.getAndIncrement(user));// 22
            System.out.println(a.get(user));// 23
        }

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

class User {
    private String name;
    public volatile int age;

    public User(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}