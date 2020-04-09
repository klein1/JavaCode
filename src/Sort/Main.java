package Sort;

public class Main {

    static Sort method;

    public static void main(String[] args) {
        int[] a = {8,6,4,7,2,1,9,3,5};

//        method = new BubbleSort();
//        method = new InsertionSort();
//        method = new ShellSort();
//        method = new SelectionSort();
//        method = new QuickSort();
        method = new HeapSort();

        method.sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
