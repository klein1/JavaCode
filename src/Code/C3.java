package Code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 第k最小素数分数
 * leetcode786
 */

public class C3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5};
        kthSmallestPrimeFraction(nums, 3);
    }

    private static int[] kthSmallestPrimeFraction(int[] A, int K) {
        int l0 = 0, r0 = A.length - 1;
        int l = A.length - 1, r = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        while(l > l0 && r < r0){
            double temp1 = 1.0*A[l0]/A[l];
            double temp2 = 1.0*A[r]/A[r0];

        }


        return null;
    }

//    private static int[] kthSmallestPrimeFraction(int[] A, int K) {
//        PriorityQueue<node> minHeap = new PriorityQueue<node>(new Comparator<node>() {
//            @Override
//            public int compare(node o1, node o2) {
//                return new Float(o1.t*1.0/o1.b).compareTo((float) (o2.t *1.0/ o2.b));
//            }
//        });
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i + 1; j < A.length; j++) {
//                minHeap.add(new node(A[i], A[j]));
//            }
//        }
//
//        while(--K > 0)
//            minHeap.poll();
//        System.out.println("[" + minHeap.peek().t + ", " + minHeap.peek().b + "]");
//
//        return new int[]{minHeap.peek().t, minHeap.peek().b};
//    }
//
//    static class node{
//        int t;
//        int b;
//        node(int t, int b){
//            this.t = t;
//            this.b = b;
//        }
//    }
}
