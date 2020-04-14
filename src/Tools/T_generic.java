package Tools;

public class T_generic {
    //注意：Number并没有实现Comparable
    private static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0) return null;
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) min = values[i];
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(min(new Integer[]{1, 2, 3}));
        System.out.println(min(new Double[]{1.2, 2.2, -1d}));
//        String typeError = min(new String[]{"1","3"});//报错
    }
}
