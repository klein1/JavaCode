package Tools;

import java.io.*;

/**
 * 枚举使用
 */
public class T_enumInstance {

    public enum EnumInstance {
        INSTANCE;
        private Object data;

        public Object getData() {
            return data;
        }
        public void setData(Object data) {
            this.data = data;
        }
        public static EnumInstance getEnumInstance(){
            return INSTANCE;
        }
    }

    public static void main(String[] args) throws Exception{
        EnumInstance enumInstance = EnumInstance.getEnumInstance();

        enumInstance.setData(new Object());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("single_file"));
        oos.writeObject(enumInstance);
        ObjectInputStream fis = new ObjectInputStream(new FileInputStream(new File("single_file")));

        EnumInstance newEnumInstance = (EnumInstance) fis.readObject();

        System.out.println(enumInstance.getData());
        System.out.println(newEnumInstance.getData());
        System.out.println(enumInstance.getData() == newEnumInstance.getData());

    }

}