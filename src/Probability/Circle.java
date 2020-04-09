package Probability;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

/**
 * 3个点在同一个半圆的概率
 */
public class Circle {

    public static void main(String[] args) {
        Random random = new Random();
        float[] nums = new float[3];
        int count = 0;
        int len = 1000000;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = random.nextFloat();
            }
            Arrays.sort(nums);
            if(nums[2] - nums[0] <= 0.5 || nums[1] - nums[0] >= 0.5 || nums[2] - nums[1] >= 0.5 )
                count ++;
        }
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(count * 1.0 / len));
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);

    }
}
