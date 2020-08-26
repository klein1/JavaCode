package Code.prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 文本左右对齐
 * leetcode 68
 */
public class C6 {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> arr = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            StringBuilder s = new StringBuilder("");
            int[] sp = getSpace(words, maxWidth, i);
            for (int j = 0; j < sp.length; i++, j++) {
                s.append(words[i]);
                int temp = sp[j];
                while (temp-- > 0) {
                    s.append(" ");
                }
            }
            if(s.length()<maxWidth) {
                s.append(words[i++]);
            }
            arr.add(s.toString());
        }

        return arr;
    }

    static int[] getSpace(String[] words, int maxWidth, int i) {
        int width = 0;
        int count = 0;
        while (i < words.length && width + count + words[i].length() <= maxWidth) {
            width += words[i].length();
            i++;
            count++;
        }
        int[] sp;
        if(count == 1){
            sp = new int[]{maxWidth-width};
        }
        else{
            if(i == words.length){
                sp = new int[count];
                Arrays.fill(sp, 1);
                sp[count-1] = maxWidth-width-count+1;
            }
            else{
                sp = new int[count-1];
                Arrays.fill(sp, 1);
                int t = count-1;
                int j = 0;
                while(t+1 <= maxWidth-width) {
                    sp[j]++;
                    t++;
                    j = (j+1)%(count-1);
                }
            }
        }
        return sp;
    }

    public static void main(String[] args) {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words = {"What","must","be","acknowledgment","shall","be"};
        String[] words = {"What","mu","bed"};
//        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 6;
        fullJustify(words, maxWidth);

    }
}
