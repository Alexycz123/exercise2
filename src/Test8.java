/**
 * @Description:
 * @Author: Alex
 * @Date 2022-04-20-23:14
 * @Version: V1.0
 **/
import java.util.*;

public class Test8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(";");
        int left = 0;
        int right = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].length() > 0){
                String tempStr= arr[i].substring(0,1);
                switch (tempStr) {
                    case "A": {
                        Integer i1 = toRight(arr[i].substring(1));
                        if (i1 != null) {
                            left = left - i1;
                        }
                        break;
                    }
                    case "S": {
                        Integer i1 = toRight(arr[i].substring(1));
                        if (i1 != null) {
                            right = right - i1;
                        }
                        break;
                    }
                    case "W": {
                        Integer i1 = toRight(arr[i].substring(1));
                        if (i1 != null) {
                            right = right + i1;
                        }
                        break;
                    }
                    case "D": {
                        Integer i1 = toRight(arr[i].substring(1));
                        if (i1 != null) {
                            left = left + i1;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(left + "," + right);
    }

    public static Integer toRight(String str){
        try{
            Integer i = Integer.parseInt(str);
            return i;
        }catch(Exception e){
            return null;
        }
    }

}
