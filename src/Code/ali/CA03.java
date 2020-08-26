package Code.ali;

        import java.util.Arrays;
        import java.util.Scanner;

public class CA03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int length = sc.nextInt();
            int[] nums = new int[length];

            int res =0;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < nums.length; j++) {
                nums[j] = sc.nextInt();
                res += nums[j];
                min = Math.min(min, nums[j]);
            }

            if(nums.length > 2){
                res += min * (nums.length - 3);
            }

            Arrays.sort(nums);

            if(nums[0]+nums[nums.length-2] > 2*nums[1]){
                System.out.println(res-(nums[0]+nums[nums.length-2]-2*nums[1]));
            }
            else
                System.out.println(res);

        }





    }
}
