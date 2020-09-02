package Code.huawei;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.next();
        List<Integer> tempnum = new ArrayList<>();
        for (int i = 0; i < nums.length(); i++) {
            if (nums.charAt(i) >= '0' && nums.charAt(i) <= '9') {
                tempnum.add(nums.charAt(i) - '0');
            }else if(nums.charAt(i) != '[' && nums.charAt(i) !=']' && nums.charAt(i)!=','){
                System.out.println(0);
                return;
            }
        }
        int n = tempnum.size() / 2;
        int[] widthNums = new int[n];
        int[] heightNum = new int[n];
        for (int i = 0; i < widthNums.length; i++) {
            widthNums[i] = tempnum.get(i);
        }
        for (int i = 0; i < heightNum.length; i++) {
            heightNum[i] = tempnum.get(n + 1);
        }

        System.out.println(largestRectangleArea(heightNum,widthNums));
    }
        public static int largestRectangleArea(int[] heights, int[] widths) {
        /*
        优化的暴力，用前一对柱子间的最低高度 求出当前柱子间的最低高度;;这才是这个题的难点吧！！！！！！！卡时间
         */
            int maxMatrix = 0;
            for (int i = 0; i < heights.length; i++) {
                int minHeight = Integer.MAX_VALUE;
                int width = 0;
                for (int j = i; j < heights.length; j++) {
                    //重新计算矩阵宽度
                    width += widths[j];
                    //计算i-j的矩形大小，需要高度
                    minHeight = Math.min(minHeight, heights[j]);
                    maxMatrix = Math.max(maxMatrix, minHeight * width );
                }
                //System.out.println(maxMatrix);
            }
            return maxMatrix;
    }
}
