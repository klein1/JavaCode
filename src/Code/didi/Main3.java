package Code.didi;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] nums = new int[m][3];
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < 3; l++) {
                    nums[j][l] = sc.nextInt();
                }
            }
            List<Set<Integer>> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (nums[j][2] <= k) {
                    boolean flag = true;
                    for (Set set : list) {
                        if (set.contains(nums[j][0])) {
                            set.add(nums[j][1]);
                            flag = false;
                        } else if (set.contains(nums[j][1])) {
                            set.add(nums[j][0]);
                            flag = false;
                        }
                    }
                    if (flag) {
                        Set<Integer> temp = new HashSet<>(2);
                        temp.add(nums[j][0]);
                        temp.add(nums[j][1]);
                        list.add(temp);
                    }
                }
            }
            Set<Integer> res = new HashSet<>();
            Set<Integer> temp;
            if (list.size() != 0) {
                res.addAll(list.get(0));
                for (Set set : list) {
                    temp = res;
                    temp.retainAll(set);
                    if (temp.size() != 0) {
                        res.addAll(set);
                    }
                }
                if (res.size() == n) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }
        }
    }
}