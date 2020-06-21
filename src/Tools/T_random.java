package Tools;

import java.util.Random;

/**
 * 随机数
 */
public class T_random {
    public static void main(String[] args) {
        Random r = new Random(1);
        for (int i = 0; i < 5; i++) {  // 85 88 47 13 54
            int ran1 = r.nextInt(100);
            System.out.print(ran1 + " ");
        }
        System.out.println();

        int max=100,min=1;
        int ran2 = (int) (Math.random()*(max-min)+min); // Math.random() : [0,1)
        System.out.println(ran2);

        long randomNum = System.currentTimeMillis();
        int ran3 = (int) (randomNum%(max-min)+min);
        System.out.println(ran3);


    }
}
