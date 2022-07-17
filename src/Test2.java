import sun.misc.ASCIICaseInsensitiveComparator;

import java.util.Comparator;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-04-18-19:54
 * @Version: V1.0
 **/
public class Test2 {
    public static void main(String[] args) {
        //还原被压缩的字符串，大于等于3个的相同字母才能压缩
        //3dak还原为dddak
        String str = "3dak";
        String[] split = str.split("");
        String newStr = "";
        for (int i = 0; i < split.length; i++) {
            try {
                int j = Integer.parseInt(split[i]);
                for (int i1 =0;i1<j;i1++){
                    newStr+=(split[i+1]);
                }
                i++;
            }catch (Exception e){
                newStr += split[i];
            }
        }

        System.out.println(newStr);
    }
}
