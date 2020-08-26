package Code.prime;

/**
 * 三进制数求和
 */
public class C5 {
    public static void main(String[] args) {
        String s = plus("121", "1212");
        System.out.println(s);
    }

    static String plus(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        while (num1.length() != num2.length()) {
            if (num1.length() > num2.length()) {
                num2 = "0" + num2;
            } else {
                num1 = "0" + num1;
            }
        }
        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            int y = num2.charAt(i) - '0';
            int sum = x + y + pre;
            if (sum >= 3) {
                pre = 1;
                sb.append(sum - 3);
            } else {
                pre = 0;
                sb.append(sum);
            }
        }
        if (pre > 0) {
            sb.append(pre);
        }
        return sb.reverse().toString();
    }


}
