import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int i1 = Integer.parseInt(String.valueOf(num) , 2);
        String str = String.valueOf(i1);
        String[] arr = str.split("");
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("1")){
                sum++;
            }
        }
        System.out.println(sum);


    }






}





