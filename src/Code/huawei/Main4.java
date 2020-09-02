package Code.huawei;

public class Main4 {
    public static void main(String[] args) {
        String s = "[2,3,5,7,8],[1,2,5,6,7]";
        s = s.replaceAll("\\[", "");
        s = s.replaceAll("\\]", "");
        System.out.println(s);
    }
}
