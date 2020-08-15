package Tools;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class T_array {
    public static void main(String[] args) {

        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        int[] nums = new int[]{1,2,3};
        int num= 2;
        List<String> list1 = Arrays.asList(s);
        List<int[]> list2 = Arrays.asList(nums);
        List<Integer> list3 = Arrays.asList(num, num);

        System.out.println(nums.getClass());  // class [I
        System.out.println(nums.getClass().getComponentType());  // int
        System.out.println(s instanceof Object[]); // true
        System.out.println((Object)nums instanceof Object[]);  // false
        System.out.println(nums.getClass().isArray());  // true
        System.out.println(Array.getLength(nums));  // 3
        System.out.println(int.class);  // int

        System.out.println(Array.get(nums, 0) instanceof Integer);
        Class<?> wrapperType = Array.get(nums, 0).getClass();
        System.out.println(wrapperType);
        Object[] newArray = (Object[]) Array.newInstance(wrapperType, Array.getLength(nums));
        for (int i = 0; i < nums.length; i++) {
            newArray[i] = Array.get(nums, i);
        }

    }
}
