package Code.wy;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, Integer> maps = new HashMap<>();
        HashMap<String, Set<Integer>> users = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            try {
                if (s.equals("rain storm")) {
                    Set<Integer> set = new TreeSet<>();
                    for (Set<Integer> value : users.values()) {
                        for (Integer o : value) {
                            Integer temp = o;
                            set.add(temp);
                            while (temp != null) {
                                if (maps.containsKey(temp) && maps.get(temp) != null && !set.contains(maps.get(temp))) {
                                    temp = maps.get(temp);
                                    set.add(temp);
                                } else
                                    break;
                            }
                        }
                    }
                    for (Integer s1 : set) {
                        System.out.print(s1 + " ");
                    }
                    System.out.println();
                } else {
                    String[] a = s.split(" ");
                    if(a.length != 2 && a.length != 3)
                        throw new Exception();
                    switch (a[1]) {
                        case "own": {
                            maps.put(new Integer(a[2]), null);
                            Set<Integer> map = users.getOrDefault(a[0], new HashSet<>());
                            map.add(new Integer(a[2]));
                            users.put(a[0], map);
                            break;
                        }
                        case "record":
                            maps.put(new Integer(a[0]), new Integer(a[2]));
                            break;
                        case "shareto":
                            Set<Integer> map1 = users.get(a[0]);
                            Set<Integer> map2 = users.getOrDefault(a[2], new HashSet<>());
                            map2.addAll(map1);
                            users.put(a[2], map2);
                            break;
                        case "abandon": {
                            Set<Integer> map = users.get(a[0]);
                            if(!map.contains(new Integer(a[2])))
                                throw new Exception();
                            map.remove(new Integer(a[2]));
                            break;
                        }
                        case "die":
                            users.remove(a[0]);
                            break;
                        default:
                            throw new Exception();
                    }
                }
            } catch (Exception e) {
                System.out.println("error");
                break;
            }
        }
    }
}
