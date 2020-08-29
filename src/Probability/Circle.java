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
        float[] nums = new float[5];
        int count = 0;
        int len = 1000000;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = random.nextFloat();
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if(i != nums.length-1 && Math.abs(nums[i] - nums[i+1]) >= 0.5)
                    count++;
                if(i == nums.length-1 && Math.abs(nums[i] - nums[0]) <= 0.5)
                    count++;
            }
        }
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(count * 1.0 / len));
        bigDecimal = bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);

    }
}
