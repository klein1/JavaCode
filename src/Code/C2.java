package Code;

/**
 * 跳跃游戏
 * leetcode55
 */
public class C2 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
//        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));

    }

    private static boolean canJump(int[] nums) {
//        return jump(nums, 0, nums.length);
        return distance(nums);
    }

    private static boolean jump(int[] nums, int cur, int n){
        if(cur >= n-1)
            return true;

        for (int i = nums[cur]; i >= 1; i--) {
            cur += i;
            if(jump(nums, cur, n)) return true;
            cur-= i;
        }

        return false;
    }

    private static boolean distance(int[] nums){
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(max >= i){
                max = Math.max(nums[i] + i, max);
            }
            if(max >= nums.length-1)
                return true;
        }
        return false;
    }

}
