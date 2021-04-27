package baseball.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

 public class BaseballUtil {
     static final int MAX_NUM = 3;
     static final int MAX_INT = 10;

    public static String makeRandomNum(){
        Random rand = new Random();
        String randomStr = "";

        for(int i=0; i<MAX_NUM; i++){
            randomStr += rand.nextInt(MAX_INT);
        }
//        System.out.println("랜덤생성 : "+randomStr);
        return randomStr;
    }

    public static boolean isValidNumber(String a){
        Set<Character> s = new HashSet<>();
        for(int i=0; i<a.length(); i++){
            s.add(a.charAt(i));
        }
        return s.size()==a.length();
    }

     public static String getValidRandomNumber(){
         String tmp = BaseballUtil.makeRandomNum();
         while(!isValidNumber(tmp)) {
             tmp = BaseballUtil.makeRandomNum();
         }
         return tmp;
     }

}
