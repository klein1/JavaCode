package Code.bd;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<Integer, List> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i+1);
            map.put(i+1, list);
        }

        for (int i = 0; i < m; i++) {
            String c = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(c.equals("C")){
                List tempa = map.get(a);
                List tempb = map.get(b);
                if(tempa == null || tempb == null)
                    continue;
                tempb.addAll(tempa);
                map.put(a, null);
            }
            else if(c.equals("Q")){
                int index = -1;
                for (List value : map.values()) {
                    if(value != null && value.contains(a) && value.contains(b)){
                        index = Math.abs(value.indexOf(b) - value.indexOf(a))-1;
                        break;
                    }
                }
                System.out.println(index);
            }

        }
    }
}

