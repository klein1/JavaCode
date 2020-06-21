package Sort;

import java.util.Arrays;

public class RadixSort implements Sort {
    public void sort(int[] a, int digit) {
        double max = Math.pow(10, digit);
        for (int exp = 1; exp < max; exp *= 10) {
            int[] temp = new int[a.length];
            int[] buckets = new int[10];

            for (int value : a) {
                buckets[(value / exp) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            for (int i = a.length - 1; i >= 0; i--) {
                temp[--buckets[(a[i] / exp) % 10]] = a[i];
            }

            System.arraycopy(temp, 0, a, 0, a.length);
        }
    }

    public void LSDSort(int[] a, int digit){
        double max = Math.pow(10, digit);
        int exp = 1;
        int k = 0;
        int[][] bucket = new int[10][a.length];
        int[] order = new int[10];

        while(exp < max){
            for (int i : a) {
                int n = i/exp%10;
                bucket[n][order[n]] = i;
                order[n]++;
            }

            for (int i = 0; i < 10; i++) {
                if(order[i] != 0){
                    for (int j = 0; j < order[i]; j++) {
                        a[k++] = bucket[i][j];
                    }
                }
                order[i] = 0;
            }

            exp *= 10;
            k = 0;
        }
    }

    public void MSDSort(int[] a, int digit){
        if(digit > 0) {
            int exp = (int) Math.pow(10, digit - 1);
            int[][] bucket = new int[10][a.length];
            int[] order = new int[10];

            for (int i : a) {
                int n = i / exp % 10;
                bucket[n][order[n]] = i;
                order[n]++;
            }

            int k = 0;
            for (int i = 0; i < 10; i++) {
                if (order[i] == 1) {
                    a[k++] = bucket[i][0];
                }
                else if(order[i] > 1){
                    int[] temp = Arrays.copyOf(bucket[i], order[i]);
                    MSDSort(temp, digit-1);
                    System.arraycopy(temp, 0, a, k, temp.length);
                    k += temp.length;
                }
            }
        }
    }

    @Override
    public void sort(int[] a) {
        int max = a[0];
        for (int anArr : a) {
            max = Math.max(max, anArr);
        }
        int n = String.valueOf(max).length();
//        sort(a, n);
        LSDSort(a, n);
//        MSDSort(a, n);
    }
}
