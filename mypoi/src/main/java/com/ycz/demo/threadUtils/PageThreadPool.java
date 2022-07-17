package com.ycz.demo.threadUtils;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;


/**
 * 导出new线程池工具类
 */
public class PageThreadPool<E> implements Runnable {

    private CountDownLatch countDownLatch;
    private String title;
    private Map<String, byte[]> byteList;
    private List<E> list;

    public PageThreadPool(CountDownLatch countDownLatch, String title, List<E> list, Map<String, byte[]> byteList) {
        this.countDownLatch = countDownLatch;
        this.title = title;
        this.list = list;
        this.byteList = byteList;
    }

    @Override
    public void run() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        SXSSFWorkbook workbook = null;
        try {
            //默认100行，超100行将写入临时文件
            workbook = new SXSSFWorkbook();
            //压缩临时文件，很重要，否则磁盘很快就会被写满
            workbook.setCompressTempFiles(true);
            SXSSFSheet sheet = workbook.createSheet("sheet");
            Class<?> aClass = list.get(0).getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            SXSSFRow row;


            for (int i = 0; i < declaredFields.length; i++) {
                row = sheet.createRow(0);
                System.out.println(declaredFields[i].getName());
                row.createCell(i).setCellValue(declaredFields[i].getName());
            }

            for (int j = 1; j < list.size(); j++) {
                row = sheet.createRow(j);
                E e = list.get(j - 1);
                Class<?> aClass1 = e.getClass();

                for (int i = 0; i < declaredFields.length; i++) {
                    String name = declaredFields[i].getName();
                    name = name.replaceFirst(name.substring(0,1) , name.substring(0,1).toUpperCase(Locale.ROOT));
                    if (name.equals("SerialVersionUID") ){
                        continue;
                    }
                    Method method = aClass1.getMethod("get" + name);
                    String invoke = (String) method.invoke(e);
                    row.createCell(i).setCellValue(invoke);
                }

            }
            workbook.write(bos);
            //put 文件名和文件字节数组
            byteList.put(this.title, bos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                // 删除临时文件，很重要，否则磁盘可能会被写满
                if (workbook != null) {
                    workbook.dispose();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
