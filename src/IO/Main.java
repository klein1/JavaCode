package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("a.txt"));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
