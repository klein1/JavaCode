package Tools;

import java.io.*;
import java.lang.reflect.Field;

public class T_clone {
    public static void main(String[] args) {
        try {
            A a = new A();
            System.out.println(a.clone().getClass() == a.getClass());
            System.out.println(a.clone()== a);
            A copy;

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(a);
            objectOutputStream.close();

            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            copy = (A)objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(copy.msg);

            B b = new B();
            B bc = (B) b.clone();
            B bdc = (B) b.deepClone();

            System.out.println(b);
            System.out.println(bc);
            System.out.println(bdc);

            System.out.println(b.a1);
            System.out.println(bc.a1);
            System.out.println(bdc.a1);

            System.out.println(b.a2);
            System.out.println(bc.a2);
            System.out.println(bdc.a2);

            System.out.println(b.a3);
            System.out.println(bc.a3);
            System.out.println(bdc.a3);

            System.out.println(bdc.state);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class A implements Cloneable, Serializable{
        String msg = "default";
        Integer id = 0;

        A(Integer id, String msg) {
            this.msg = msg;
            this.id = id;
        }

        A(){}

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class B implements Cloneable, Serializable{
        A a1 = new A(1, "a1");
        A a2 = new A(2, "a2");
        A a3 = new A(3, "a3");
        int state = 3;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        Object deepClone() throws CloneNotSupportedException, IllegalAccessException {
            Object o = super.clone();
            Field[] fields = this.getClass().getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {
                if(!fields[i].getType().isPrimitive())
                    fields[i].set(o, ((A)fields[i].get(o)).clone());
            }
            return o;
        }
    }
}
