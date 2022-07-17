import java.util.Arrays;
import java.util.Collections;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-04-21-21:10
 * @Version: V1.0
 **/
public class Test9 {
    public static void main(String[] args) {

        int[]  arr={10 , 11, 13 ,14 , 15 ,0 , 11 , 6 , 8 , 20 , 11 , 30 , 50 , 0 , 6};

        quictSork(arr , 0 ,arr.length - 1);


        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void quictSork(int[] arr, int begin, int end) {
        // 如果begin一直小於end這一直運行
        if (begin<end){
            int key = arr[begin];
            int i = begin;
            int j = end;

            while (i < j){
                while (i<j){
                    if (arr[j] < key){          //如果後面的字段小於關鍵字段，則說明需要交換
                        arr[i] = arr[j];
                        break;
                    }else {//如果不小於，則指針指向前面
                        j--;
                    }
                }
                while (i<j){
                    if (arr[i] >    key){       //如果前面的字段大於關鍵字段，則需要進行交換
                        arr[j] = arr[i];
                        break;
                    }else {
                        i++;
                    }
                }
            }

            arr[j] = key;           //此時 i==j , i 是中位數
            quictSork(arr , begin ,i-1);
            quictSork(arr , begin + 1 , end);

        }


    }


}
