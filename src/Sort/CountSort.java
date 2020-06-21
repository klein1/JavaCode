package Sort;

public class CountSort implements Sort {
    @Override
    public void sort(int[] a) {
        int[] b= new int[a.length];
        int max = a[0], min = a[0];
        for (int i : a) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int k = max - min + 1;
        int[] c = new int[k];

        for (int i = 0; i < a.length; ++i) {
            c[a[i] - min] += 1;
        }

        for (int i = 1; i < c.length; ++i) {  // 保存元素位置
            c[i] = c[i] + c[i - 1];
        }

        for (int i = a.length - 1; i >= 0; --i) {  // 从后往前遍历，稳定排序
            b[--c[a[i] - min]] = a[i];
        }

        System.arraycopy(b, 0, a, 0, a.length);
    }
}
