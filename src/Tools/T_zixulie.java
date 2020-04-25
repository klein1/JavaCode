package Tools;

public class T_zixulie {
    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 6, 9};
        subList(a);
    }

    //连续子序列
    private static void subList(int[] a) {
        int i, j, k;
        for (i = 0; i < a.length; i++) {
            for (j = i; j < a.length; j++) {
                for (k = i; k <= j; k++) {
                    System.out.print(a[k] + " ");
                }
                System.out.println();
            }
        }
    }

    //所有子序列
    private static void allSubList(int[] a) {
        for (int i = 0; i < 1 << a.length; i++) {
            boolean isnull = true;
            for (int j = 0; j < a.length; j++) {
                if ((1 << j & i) != 0) {
                    isnull = false;
                    System.out.print(a[j] + " ");
                }
            }
            if (isnull) {
                System.out.print("null");
            }
            System.out.println();
        }
    }

    //最大子序列和
    private static int maxSubListSum(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    private static int maxSubListSum2(int[] a) {
        int maxSum = 0, temp = 0;
        for (int i = 0; i < a.length; i++) {
            temp += a[i];
            if (temp > maxSum) {
                maxSum = temp;
            }
            if (temp < 0) {
                temp = 0;
            }
        }
        return maxSum;
    }
}
