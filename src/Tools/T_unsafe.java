package Tools;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

public class T_unsafe {
    private static int byteArrayBaseOffset;
    private static long valueOffset;
    private int value;

    public static void main(String[] args) throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe UNSAFE = (Unsafe) theUnsafe.get(null);
        System.out.println(UNSAFE);

        byte[] data = new byte[10];
        System.out.println(Arrays.toString(data));
        byteArrayBaseOffset = UNSAFE.arrayBaseOffset(byte[].class);

        System.out.println(byteArrayBaseOffset);
        UNSAFE.putByte(data, byteArrayBaseOffset, (byte) 1);
        UNSAFE.putByte(data, byteArrayBaseOffset + 5, (byte) 5);
        System.out.println(Arrays.toString(data));

        T_unsafe s = new T_unsafe();
        System.out.println(s.value);
        valueOffset = UNSAFE.objectFieldOffset(T_unsafe.class.getDeclaredField("value"));
        UNSAFE.compareAndSwapInt(s, valueOffset, 0, 9);
        System.out.println(s.value);

    }
}
