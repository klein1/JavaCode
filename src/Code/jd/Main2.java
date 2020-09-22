package Code.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Integer> list = new ArrayList<>();

        for(String t: s.split(" ")){
            try {
                StringBuilder sb = new StringBuilder(t);
                for (int i = 0; i < sb.length(); i++) {
                    if (sb.charAt(i) < '0' || sb.charAt(i) > '9')
                        sb.setCharAt(i, ' ');
                }

                String n = sb.toString().replaceAll("\\s+", " ");

                for (String u : n.split(" ")) {
                    if(u.length() > 4)
                        u = u.substring(0, u.length()-1);
                    int temp = Integer.parseInt(u);
                    if (temp >= 1000 && temp <= 3999)
                        list.add(temp);
                }

            } catch (Exception e) {
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(i != list.size()-1)
                System.out.print(list.get(i) + " ");
            else
                System.out.print(list.get(i));
        }
    }
}
