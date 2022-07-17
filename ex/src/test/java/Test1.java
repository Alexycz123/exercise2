import com.ycz.ThreadStudy;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-17-1:34
 * @Version: V1.0
 **/
public class Test1 {
    public static void main(String[] args) throws InterruptedException {

        StringBuffer stringBuilder = new StringBuffer();
        Object o = new Object();
        for (int i = 0; i < 10; i++) {

            new Thread(()->{
//                synchronized (o){
                    for (int j = 0; j < 1000; j++) {
                        stringBuilder.append("a");
                    }
//                }

            }).start();
        }
        Thread.sleep(100);
        System.out.println(stringBuilder.length());

    }
}
