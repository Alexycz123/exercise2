import java.util.*;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-04-19-20:16
 * @Version: V1.0
 **/
public class Test5 {
    public static void main(String[] args) {
//        Scanner scanner=new Scanner();
//        String str = "abc abc aabc ssssss";
//        String arr[] = str.split(" ");
//        System.out.println(arr[arr.length-1].length());


//        Scanner sc= new Scanner(System.in);
//        String str = sc.nextLine();
//        String str2 = sc.nextLine();
//
//        int sum = 0;
//        String[] arr = str.split("");
//        for(int i=0;i<arr.length ; i++){
//            if(str2.equalsIgnoreCase(arr[i])){
//                sum++;
//            }
//        }
//        System.out.println(sum);


//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//
//        List<Integer> list = new ArrayList<>();
//        for(int i=0;i<num; i++){
//            int random = new Random().nextInt(500);
//            if (!list.contains(random)){
//                list.add(random);
//            }
//        }
//        Collections.sort(list);
//        list.forEach(System.out::println);
//        String str = "abbbb";
//        str.


//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        while (str.length()>=8){
//            for(int i=0 ; i<(str.length()/8) ; i++){
//                System.out.println(str.substring(i*8 ,(i+1)*8 ));
//                str = str.substring((i+1)*8 , str.length());
//            }
//        }
//
//        int size = str.length();
//        for(int i=0;i<(8-size);i++){
//            str +="0";
//        }
//
//        System.out.println(str );

        //写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            String str = in.nextLine();
//            String s1 = str.substring(2);
//            int a = Integer.parseInt(s1,16);
//            System.out.println(a);
//        }


        /**
         * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
         */
//        Scanner sc = new Scanner(System.in);
//        long num = sc.nextLong();
//        getNumber(num);

        /**
         * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
         */
//        Scanner sc  = new Scanner(System.in);
//        String str = sc.nextLine();
//        String arr[] = str.split("\\.");
//        arr[1] = "0."+arr[1];
//        int num1 = Integer.parseInt(arr[0]);
//        double num2 = Double.parseDouble(arr[1]);
//        if(num2>=0.5){
//            System.out.println(num1 + 1);
//        }else{
//            System.out.println(num1);
//        }
//
//
//        Scanner in = new Scanner(System.in);
//        double number = in.nextDouble();
//        System.out.println((int)(number + 0.5));
        /**
         * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，
         * 即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
         */

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str="";
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<num;i++){
            int index = sc.nextInt();
            int value = sc.nextInt();
            if (map.containsKey(index)){
                map.put(index,map.get(index) + value);
            }else {
                map.put(index , value);
            }

        }
        for (Integer integer : map.keySet()) {
            System.out.println(integer + " " + map.get(integer));
        }

        /**
         * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
         * 保证输入的整数最后一位不是 0 。
         */
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//
//        String str =String.valueOf(num);
//        String arr[] = str.split("");
//        String newArr ="";
//        for(int i=arr.length-1;i>=0;i--){
//            if(!newArr.contains(arr[i])){
//                newArr += arr[i];
//            }
//        }
//        System.out.println(newArr);
    }
    public static void getNumber(long num){
        for(int i=2;i<=num;i++){
            if(num % i ==0){
                System.out.print(i+" ");
                getNumber(num / i);
                break;
            }
            if( i == num){
                System.out.print(i+" ");

            }
        }
    }
}
