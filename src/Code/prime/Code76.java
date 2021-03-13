package Code.prime;

import java.util.HashMap;
import java.util.Map;

public class Code76 {
    String result = "";
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int i = 0, j = 0;
        while(j < s.length()){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                while(valid(map)){
                    if(map.get(s.charAt(i)) == null){
                        i++;
                    }
                    else if(map.get(s.charAt(i))<0){
                        map.put(s.charAt(i), map.get(s.charAt(i))+1);
                        i++;
                    }
                    else{
                        String temp = s.substring(i, j+1);
                        if(result.equals(""))
                            result = temp;
                        else if(temp.length() < result.length())
                            result = temp;
                        break;
                    }
                }

            }
            j++;
        }
        return result;
    }

    public boolean valid(Map map){
        for(Object i : map.values()){
            if((Integer)i>0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code76().minWindow("ADOBECODEBANC", "ABCT"));
    }
}