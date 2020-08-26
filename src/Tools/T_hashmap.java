package Tools;

import java.lang.reflect.Array;
import java.util.HashMap;

public class T_hashmap {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(33, 76);
        hashMap.put(33, 87);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(2));
        hashMap.put(2, 1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(33));

    }
}

class GeHashMap<K,V>{
    final int capacity;
    static final int DEFAULT_CAPACITY = 16;

    static class Entry<K,V>{
        K key;
        V value;
        Entry<K, V> next;
        Entry(K key, V value, Entry<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    Entry<K, V>[] table;

    public GeHashMap(int capacity) {
        assert capacity > 0;
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    public GeHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public int hash(K key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void put(K key, V value) {
        int i = hash(key) % capacity;
        Entry<K,V> first = table[i], curr;

        if((curr = first) == null){
            table[i] = new Entry<>(key, value, null);
        }
        else{
            Entry<K,V> last = curr;

            while (curr != null){
                if(curr.key.equals(key)) {
                    curr.value = value;
                    return;
                }
                last = curr;
                curr = curr.next;
            }
            last.next = new Entry<>(key, value, null);
        }
    }

    public V get(K key){
        int i = hash(key) % capacity;
        Entry<K,V> first = table[i], curr;

        if((curr = first) != null){
            do{
                if(curr.key.equals(key)) {
                    return curr.value;
                }

            } while((curr=curr.next) != null);
        }

        return null;
    }

    public void remove(K key){
        int i = hash(key) % capacity;
        Entry<K, V> first = table[i], curr;

        if((curr = first) != null){
            if(curr.key.equals(key)) {
                table[i] = curr.next;
                return;
            }

            while (curr.next != null){
                if(curr.next.key.equals(key)) {
                    curr.next = curr.next.next;
                    return;
                }
                curr = curr.next;
            }
        }
    }

}

class MyHashMap {

    GeHashMap<Integer, Integer> map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new GeHashMap<>();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map.put(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map.get(key)==null?-1:map.get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map.remove(key);
    }
}
