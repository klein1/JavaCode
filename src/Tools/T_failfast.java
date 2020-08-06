package Tools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class T_failfast {
    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("不只Java-1", 1);
        hashMap.put("不只Java-2", 2);
        hashMap.put("不只Java-3", 3);

        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
//        hashMap.put("下次循环会抛异常", 4);
        while (iterator.hasNext()) {
//            hashMap.put("下次循环会抛异常", 5);
            hashMap.put("不只Java-3", 33);
            System.out.println(iterator.next());
            System.out.println("此时 hashMap 长度为" + hashMap.size());
        }

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("不只Java-1", 1);
        concurrentHashMap.put("不只Java-2", 2);
        concurrentHashMap.put("不只Java-3", 3);

        Set set2 = concurrentHashMap.entrySet();
        Iterator iterator2 = set2.iterator();

        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
            concurrentHashMap.put("下次循环正常执行", 4);
        }
        System.out.println("程序结束");

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);

        Iterator iterator3 = copyOnWriteArrayList.iterator();

        while (iterator3.hasNext()) {
            copyOnWriteArrayList.set(1, 11);
            copyOnWriteArrayList.add(4);
            System.out.println(iterator3.next());
        }
    }
}
