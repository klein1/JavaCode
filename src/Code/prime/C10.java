package Code;

import java.util.ArrayList;
import java.util.List;

/**
 * 472
 */
public class C10 {
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<words.length;i++)
            search(i, words[i], 0, words, arr);

        return arr;

    }

    public static void search(int index, String s, int count, String[] words, List<String> l){
        if(s.equals("") && count < 2) return;
        for(int i=0;i<words.length;i++){
            if(s.indexOf(words[i])==0){
                String s2 = s.substring(words[i].length());
                if(s2.length() == 0 && count >= 1)
                    l.add(words[index]);
                search(index, s2, count+1, words, l);

            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
//        String[] words = {""};
//        String[] words = {"cat","dog","catdog"};
        List<String> arr = findAllConcatenatedWordsInADict(words);

        for (String s : arr) {
            System.out.println(s);
        }

    }
}
