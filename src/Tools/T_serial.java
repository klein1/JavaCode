package Tools;

import java.io.*;

public class T_serial {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Data d = new Data();
        d.num = 10;
        d.msg = "message";
        d.pnum = 100;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(d);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Data serial = (Data) objectInputStream.readObject();

        System.out.println(serial.num);
        System.out.println(serial.msg);
        System.out.println(serial.pnum);
    }
}

class Prime implements Serializable{
    int pnum = 0;
    static int psnum = 0;
}

class Data extends Prime{
    int num = 0;
    String msg = "";
}