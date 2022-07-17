package com.ycz;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-01-17:10
 * @Version: V1.0
 **/
// 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法
public class MYTest {
    public static void main(String[] args) {
        System.out.println(isPalindrome(""));//false
        System.out.println(isPalindrome("a"));//true
        System.out.println(isPalindrome("aba"));//true
        System.out.println(isPalindrome("abccba"));//true
        System.out.println(isPalindrome("abcdcba"));//true


    }

    //需要实现这个方法
    public static boolean isPalindrome(String s) {
        if(s==null || s==""){
            return false;
        }
        if(s.length()==1){
            return true;
        }
        if(s.length()==0){
            return false;
        }
        if(s.length() % 2 == 0){//偶数
            String sub1= s.substring(0 , (s.length()/2));
            String sub2= s.substring((s.length()/2));
            StringBuilder s1 = new StringBuilder(sub2);
            sub2 = s1.reverse().toString();
            return sub1.equals(sub2);
        }else{
            String sub1= s.substring(0 , (s.length()/2));
            String sub2= s.substring((s.length()/2 + 1));
            StringBuilder s1 = new StringBuilder(sub2);
            sub2 = s1.reverse().toString();
            return sub1.equals(sub2);
        }
    }
}
