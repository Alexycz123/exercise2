package com.ycz;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-01-17:14
 * @Version: V1.0
 **/
// 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法
public class newTest {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
//输出：a2b1c5a3
        System.out.println(compressString("abbccd")); //输出：abbccd。 abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长
    }

    /**
     * 实现这个函数
     */
    public static String compressString(String str){
        if(str==null || str.equals("")){
            return "";
        }

        StringBuilder resultStr = new StringBuilder();
        char c = str.charAt(0);
        int flag = 1;
        for (int i = 0; i < str.length(); i++) {
            if (c==str.charAt(i)){
                flag++;
            }else{
                resultStr.append(c).append(flag);

                c=str.charAt(i);

                flag =1;
            }
        }
        return resultStr.append(c).append(flag).toString();
    }

}

