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
                int start = 0, end = 0;
                boolean flag = false;
                for (int i = 0; i < t.length(); i++) {
                    if(t.charAt(i) >= '0' && t.charAt(i) <= '9'){
                        if(!flag){
                            flag = true;
                            start = i;
                            end = i;
                        }
                        else
                            end = i;
                    }
                    else {
                            int temp = Integer.parseInt(t.substring(start, end + 1));
                            if (temp >= 1000 && temp <= 3999)
                                list.add(temp);
                            flag = false;
                    }

                    if(i == t.length()-1){
                        int temp = Integer.parseInt(t.substring(start, end));
                        if (temp >= 1000 && temp <= 3999)
                            list.add(temp);
                    }
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
