/**
 * @Description:
 * @Author: Alex
 * @Date 2022-04-18-21:52
 * @Version: V1.0
 **/
public  class Test4 {

    private Integer integer =1;

    public void get(){

    }
    public Test4(){

    }

    static class Test5{
        public void get(){
            System.out.println("aaa");
        }
        public Test5(){

        }
    }

    public static void main(String[] args) {
        Test4.Test5 test5 =new Test5();
        test5.get();
    }

}
