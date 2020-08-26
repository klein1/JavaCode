package Code;

/**
 * 字符串变换，任意字符移到末尾次数
 */
public class C1 {

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("acdkt");
        StringBuilder t = new StringBuilder("dckat");
        int n = s.length();
        int count = 0;

        for (int i = n-1; i >= 0; i--) {
            if(s.toString().equals(t.toString())){
                System.out.println(count);
                break;
            }
            int j;
            if(s.charAt(i) != t.charAt(i)){
                for (j = n-1; j >=0; j--) {
                    if(s.charAt(j) == t.charAt(i))
                        break;
                }
                if(j == -1){
                    System.out.println(-1);
                    break;
                }

                s.deleteCharAt(j);
                s.insert(n-1, t.charAt(i));
            }
            count++;
            n--;
        }
    }
}
