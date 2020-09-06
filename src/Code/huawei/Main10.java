package Code.huawei;

import java.util.*;
/*
getFea
查字串
超过范围？？字符串数量大于20了
 */
public class Main10 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count=0;
        List<String> strList = new LinkedList<String>();
        String instr;
        while(scan.hasNextLine()){
            strList.add(scan.next());
            System.out.println(strList.size());
            count++;
        }
/*        strList.add("135682318");
        strList.add("23457");
        strList.add("14282123");
        strList.add("14231728");
        strList.add("3");
        strList.add("1724153");
        count =6;*/

        count = count-2;

        if(count>20){
            for(int i=0; i<count;i++){
                System.out.println(strList.get(i));
            }
            return;
        }
        String linjie = strList.get(count);
        //   System.out.println(linjie);
        char ljchar ='a';
        if(linjie.length()==1){
            ljchar=linjie.charAt(0);
        }
        String strEnd = strList.get(count+1);
        //System.out.println(strEnd);
        String tar = getFea(strEnd,ljchar);
        //  System.out.println(tar);
        for(int i=0; i<count;i++){
            String cur = strList.get(i);
            String curFra = getFea(cur,ljchar);
            //      System.out.println(curFra);
            if(curFra.indexOf(tar)!= -1){//是子串
                System.out.println(cur);
            }
        }
        return;
    }
    public static String getFea(String cur, char lj){
        StringBuilder res = new StringBuilder();
        for(int i=0; i<cur.length();i++){
            char ch=cur.charAt(i);
            if(ch<lj){
                res.append(ch);
            }
        }
        return new String(res);
    }
}
/*
135682318
23457
14282123
14231728
3
1724153
 */