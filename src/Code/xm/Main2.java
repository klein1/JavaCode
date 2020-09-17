package Code.xm;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String s = sc.nextLine();

            HashSet<Character> set = new HashSet<>();
            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if(!set.contains(s.charAt(i))) {
                    set.add(s.charAt(i));
                    list.add(s.charAt(i));
                }
            }

            for (Character c : list) {
                System.out.print(c);
            }
        }
    }
}
