package Sort;

public class Main {

    static Sort method;

    public static void main(String[] args) {
//        int[] a = {8,6,4,7,2,1,9,3,5};
        int[] a = {18,6,4,17,21,1,98,3,45};
//        int[] a = {8,6,5,3,5};

//        method = new BubbleSort();
//        method = new InsertionSort();
//        method = new ShellSort();
//        method = new SelectionSort();
//        method = new QuickSort();
//        method = new HeapSort();
//        method = new MergeSort();
//        method = new BucketSort();
//        method = new RadixSort();
        method = new CountSort();

        method.sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
