package Tools;

import java.util.*;

public class T_treemap {
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<>((obj1, obj2) -> obj2.compareTo(obj1));
        map.put("month", "The month");
        map.put("bread", "The bread");
        map.put("attack", "The attack");
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while(iter.hasNext()){
            String key = iter.next();
            System.out.println(key+":"+map.get(key));
        }

        System.out.println();

        Map<String,String> map2 = new TreeMap<>();
        map2.put("aaaa", "month");
        map2.put("bbbb", "bread");
        map2.put("ccccc", "attack");
        //通过ArrayList构造函数把map.entrySet()转换成list
        List<Map.Entry<String,String>> mappingList = new ArrayList<>(map2.entrySet());
        //通过比较器实现比较排序
        Collections.sort(mappingList, (mapping1, mapping2) -> mapping1.getValue().compareTo(mapping2.getValue()));
        for(Map.Entry<String,String> mapping:mappingList){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }
}
