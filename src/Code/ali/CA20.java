package Code.ali;

import java.util.*;

public class CA20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String m = scanner.next();
        int n = scanner.nextInt();
        int[] nums = new int[m.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = m.charAt(i) - '0';
        }
        System.out.println(permuteUnique(nums));
        int count = 0;
        List<List<Integer>> res = permuteUnique(nums);
        for (List<Integer> list : res) {
            if (list.get(0) != 0) {
                int size = list.size();
                long temp = 0;
                int i = 0;
                while (size != 0) {
                    temp += Math.pow(list.get(i++), --size);
                }
                if (temp % n == 0) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, used, temp, res);
        return res;
    }

    private static void dfs(int[] nums, int dep, boolean[] used, List<Integer> temp, List<List<Integer>> res) {
        if (dep == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 相同元素只保留正序访问，即从第一个一次访问到最后一个，其他顺序剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i] && !used[i - 1]) {
                continue;
            }

            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;

                dfs(nums, dep + 1, used, temp, res);

                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}