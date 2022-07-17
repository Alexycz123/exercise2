import java.util.Scanner;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-04-20-21:51
 * @Version: V1.0
 **/

/**
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 */
public class Test6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        for(int i=arr.length-1 ; i>=0 ; i--){
            System.out.print(arr[i] + " ");
        }

    }
}
