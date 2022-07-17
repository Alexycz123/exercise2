import java.util.*;


public class Test10{
    public static void main(String[] args){
        //先確認最大值，找出左側最長升序，右側最長降序
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = new Scanner(System.in).nextLine();
        String[] arr = str.split(" ");
        int[] ints = new int[num];
        int max=0;
        for(int i=0;i<arr.length;i++){
            ints[i] = Integer.parseInt(arr[i]);
            max = Math.max(max , ints[i]);
        }
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for(int i=0;i<ints.length;i++){
            if(ints[i] != max){
                if(ints[i] < max){
                    if(i == 0){
                        list.add(ints[i]);
                    }else{
                        if(list.get(list.size()-1) < ints[i]){
                            list.add(ints[i]);
                        }
                    }
                }else{
                    if(list.get(list.size()-1) > ints[i]){
                        list.add(i);
                    }
                }
            }else{
                list.add(max);
                index = i;
                break;
            }
        }
        for(int i = index;i<ints.length ;i++){
            if (list.get(list.size() - 1) > ints[i]){
                list.add(ints[i]);
            }
        }


        System.out.println(list.size());




    }

}
