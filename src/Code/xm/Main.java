package Code.xm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static HashMap<Character,Character> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        while(sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println(helper(s));
        }

    }

    public static boolean helper(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                if (map.get(stack.pop()) != c)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
