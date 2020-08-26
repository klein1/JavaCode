package Code.prime;

import java.util.*;

/**
 * 第k最小素数分数
 * leetcode786
 */

class Data{
    int top;
    int bot;
    int topindex;
    int botindex;

    public Data(int[] arr) {
        this.top = arr[0];
        this.bot = arr[1];
        this.topindex = arr[2];
        this.botindex = arr[3];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return top == data.top &&
                bot == data.bot;
    }

    public int[] toArray(){
        return new int[]{this.top, this.bot};
    }
}

public class C3 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 5};
        int[] nums = new int[]{1,7,23,29,47};
        int[] result = standard(nums, 8);

        for (int i : result) {
            System.out.println(i);
        }

    }

    private static int[] kthSmallestPrimeFraction1(int[] A, int K) {
        ArrayList<int[]> arr = new ArrayList<>();
        int n = A.length;
        PriorityQueue<Data> minHeap = new PriorityQueue<Data>((o1, o2) -> new Float(o1.top * 1.0 / o1.bot).compareTo((float) (o2.top * 1.0 / o2.bot)));
        minHeap.add(new Data(new int[]{A[0], A[n-1], 0, n-1}));

        while(minHeap.size() > 0){
            if(arr.size() == K)
                break;
            Data temp = minHeap.poll();
            arr.add(temp.toArray());
            int top = temp.topindex, bot = temp.botindex;
            if(top + 1 < n){
                Data p1 = new Data(new int[]{A[top+1], A[bot], top+1, bot});
                if(!minHeap.contains(p1))
                    minHeap.add(p1);
            }

            if(bot - 1 >= 0){
                Data p2 = new Data(new int[]{A[top], A[bot-1], top, bot-1});
                if(!minHeap.contains(p2))
                    minHeap.add(p2);
            }
        }

        return arr.get(K-1);
    }

    private static int[] kthSmallestPrimeFraction2(int[] A, int K) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((o1, o2) -> new Float(o1[0]*1.0/o1[1]).compareTo((float) (o2[0] *1.0/ o2[1])));
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                minHeap.add(new int[]{A[i], A[j]});
            }
        }

        while(--K > 0)
            minHeap.poll();

        return minHeap.peek();
    }

    private static int[] standard(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) ->
                A[a[0]] * A[b[1]] - A[a[1]] * A[b[0]]);

        for (int i = 1; i < A.length; ++i)
            pq.add(new int[]{0, i});

        while (--K > 0) {
            int[] frac = pq.poll();
            if (frac[0]++ < frac[1])
                pq.offer(frac);
        }

        int[] ans = pq.poll();
        return new int[]{A[ans[0]], A[ans[1]]};
    }

}
