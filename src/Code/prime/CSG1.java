package Code.prime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSG1 {
    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        ArrayList l = wordBreak(s, dict);

        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }

    }

    static ArrayList<String> result = new ArrayList<String>();

    static ArrayList<String> wordBreak(String s, Set<String> dict) {
        search(s, "", dict);
        return result;
    }

    static void search(String source, String target, Set<String> dict){
        if(source.equals("")) {
            result.add(target.substring(0, target.length()-1));
            return;
        }
        for(int i=1;i<=source.length();i++){
            String temp = source.substring(0, i);
            if(dict.contains(temp)){
                search(source.substring(i), target + temp + " ", dict);
            }
        }
    }


}
