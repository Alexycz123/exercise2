package com.ycz.demo;

import com.ycz.demo.entity.SysUser;
import com.ycz.demo.threadUtils.BigDataExport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@SpringBootTest
class MypoiApplicationTests {

    @Autowired
    private ExecutorService executorService;
    @Test
    void test1() {

        int size = 70__0000;
        List<SysUser> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
           SysUser sysUser = new SysUser();
           sysUser.setId(String.valueOf(i));
           sysUser.setUsername("name" + i);
           list.add(sysUser);
        }
        //生成 excel 文件名
        String title = "GLOOX-SCATTER-CHART_SXSSFW_";
        //生成 ZIP 目录
        String zipFilePath = "E:\\admin\\Desktop\\";
        //生成 ZIP 文件名
        String zipFileName = "ZIP";
        long timeMillis = System.currentTimeMillis();
        System.out.println("开始 [导出Excel+打包ZIP] 时间为：" + timeMillis);
        BigDataExport.bigDataExport(list, title, zipFilePath, zipFileName , executorService);
        System.out.println("结束 [导出Excel+打包ZIP] 时间为：" + (System.currentTimeMillis() - timeMillis));
    }

}
