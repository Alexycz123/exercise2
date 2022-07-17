import java.util.Arrays;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-04-18-19:25
 * @Version: V1.0
 **/
public class Test1 {
    //一个二维的数组，每行是一个二进制，求所有行左右移动后的和的最大值
    public static void main(String[] args) {

        int[][] arrs = {
                {0b101010, 0b111111, 0b101010} ,
                {0b101110, 0b111111, 0b101110} ,
                {0b101110, 0b111111, 0b101000}
        };
        int [][]leftArr = new int[3][3];
        int [][]rigntArr = new int[3][3];
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length; j++) {
                leftArr[i][j] = arrs[i][j] * 4;
                rigntArr[i][j] = arrs[i][j] /4;
            }
        }

        int max = 0;
        for (int i = 0; i < leftArr.length; i++) {
            int sum = 0;
            for (int j = 0; j < leftArr.length; j++) {
                sum += leftArr[i][j];
            }
            for (int i1 = 0; i1 < rigntArr.length; i1++) {
                sum+=rigntArr[i][i1];
            }
            if (max < sum){
                max  = sum;
            }


        }

        System.out.println("最大值"+max);

    }


}
