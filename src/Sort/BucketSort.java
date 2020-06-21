package Sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort implements Sort {
    @Override
    public void sort(int[] a) {
        int max = a[0], min = a[0];
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }

        int bucketNum = (max - min) / a.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }

        for (int i = 0; i < a.length; i++) {
            int num = (a[i] - min) / a.length;
            bucketArr.get(num).add(a[i]);
        }

        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        int k = 0;
        for (int i = 0; i < bucketArr.size(); i++) {
            for (int j = 0; j < bucketArr.get(i).size(); j++) {
                a[k++] = bucketArr.get(i).get(j);
            }
        }
    }
}
