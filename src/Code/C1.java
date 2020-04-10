package Code;

/**
 * switch支持的表达式类型
 */
public class C1 {
    enum en{
        val1(1), val2(2);
        private int val;
        en(int val){
            this.val = val;
        }
        en(){
            this.val = 0;
        }
    }

    public static void main(String[] args) {
        String a = "";
        int b = 1;
        short c = 1;
        byte d = 1;
        char e = 1;
        Integer f = 1;
        Short g = 1;
        Byte h = 1;
        Character i = 1;
        en j = en.val1;

        switch(j){
            case val1:
                System.out.println(j.val);break;
        }
    }
}