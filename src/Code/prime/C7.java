package Code.prime;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 相对名次
 * leetcode506
 */
public class C7 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        String [] result = findRelativeRanks(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static String[] findRelativeRanks(int[] nums) {
        String [] results = new String[nums.length];
        int[] copys = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copys);
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < copys.length; i++) {
            int rank = copys.length - i;
            if (rank == 1) {
                map.put(copys[i], "Gold Medal");
            }
            else if (rank == 2) {
                map.put(copys[i], "Silver Medal");
            }
            else if (rank == 3){
                map.put(copys[i], "Bronze Medal");
            }
            else {
                map.put(copys[i], String.valueOf(rank));
            }
        }

        for (int i = 0; i < nums.length; i++) {
            results[i] = map.get(nums[i]);
        }
        return results;
    }
}
