package Tools;
import String.Test;

public class T_protected {
    public static void main(String[] args) {
        Emp emp = new Emp();
//        emp.test();  // 'test()' has protected access in 'String.Test'
    }
}

class Emp extends Test{
    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.test();
//        emp.test2();  //  'test2()' is not public in 'String.Test'. Cannot be accessed from outside package
    }
}