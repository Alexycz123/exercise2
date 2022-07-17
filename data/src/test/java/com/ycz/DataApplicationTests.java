package com.ycz;

import com.ycz.entity.SysUser;
import com.ycz.mapper.SysUserMapper;
import com.ycz.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest
@Slf4j
class DataApplicationTests {

    @Autowired
    private IUserService userService;
    //随机生成汉字
    private static char getRandomChar() {
        String str = "";
        int hightPos; //
        int lowPos;

        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("错误");
        }

        return str.charAt(0);
    }

    @Test
    void contextLoads() throws ParseException {
        long l = System.currentTimeMillis();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char c  = (char) ('a' + i);
            characters.add(c);
        }
        for (int i = 0; i < 26; i++) {
            char c  = (char) ('A' + i);
            characters.add(c);
        }
        List<SysUser> list = new ArrayList<>();

        List<String> stringList = new ArrayList<>();
        stringList.add("赵");
        stringList.add("钱");
        stringList.add("孙");
        stringList.add("李");
        stringList.add("周");
        stringList.add("吴");
        stringList.add("郑");
        stringList.add("王");
        stringList.add("冯");
        stringList.add("陈");
        stringList.add("褚");
        stringList.add("卫");
        stringList.add("蒋");
        stringList.add("沈");
        stringList.add("韩");
        stringList.add("杨");
        stringList.add("秦");
        stringList.add("朱");
        stringList.add("尤");
        stringList.add("许");
        stringList.add("何");
        stringList.add("吕");
        stringList.add("施");
        stringList.add("张");

        List<String> phoneList = new ArrayList<>();
        phoneList.add("136");
        phoneList.add("137");
        phoneList.add("138");
        phoneList.add("180");
        phoneList.add("134");
        phoneList.add("135");
        phoneList.add("139");
        phoneList.add("150");
        phoneList.add("151");
        phoneList.add("152");
        phoneList.add("157");
        phoneList.add("158");
        phoneList.add("159");
        phoneList.add("187");
        phoneList.add("188");
        phoneList.add("147");

        List<String> emailList = new ArrayList<>();
        emailList.add("@qq.com");
        emailList.add("@163.com");
        emailList.add("@sohu.com");
        emailList.add("@sohu.com");
        emailList.add("@139.com");
        emailList.add("@aliyun.com");
        emailList.add("@189.com");
        emailList.add("@hotmail.com");
        emailList.add("@gmail.com");
        emailList.add("@sina.com");
        emailList.add("@yahoo.com");
        emailList.add("@msn.com");
        emailList.add("@hotmail.com");
        emailList.add("@live.com");

        List<Integer> yearList = new ArrayList<>();
        for (int i = 1900; i < 2021; i++) {
            yearList.add(i);
        }

        List<Integer> monthList = new ArrayList<>();
        for (int i = 1; i <=12 ; i++) {
            monthList.add(i);
        }

        List<Integer> dayList = new ArrayList<>();
        for (int i = 1; i <= 28; i++) {
            dayList.add(i);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


        Random random = new Random();
        for (int i = 0; i < 2999000; i++) {
            SysUser sysUser = new SysUser();
            StringBuilder username = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                Character username1 = characters.get(random.nextInt(characters.size()-1));
                username.append(username1.toString());
            }
            StringBuilder realname = new StringBuilder();
            realname.append(stringList.get(random.nextInt(stringList.size()-1)));

            for (int j = 0; j < 2; j++) {
                Character realname2 =  getRandomChar();
                realname.append(realname2.toString());
            }
            sysUser.setRealname(realname.toString());

            StringBuilder phoneString = new StringBuilder();
            phoneString.append(phoneList.get(random.nextInt(phoneList.size()-1)));
            for (int j = 0; j < 8; j++) {
                phoneString.append(random.nextInt(8));
            }
            sysUser.setPhone(phoneString.toString());

            StringBuilder emailString = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                emailString.append(random.nextInt(10));
            }
            emailString.append(emailList.get(random.nextInt(emailList.size()-1)));
            sysUser.setEmail(emailString.toString());


            String year = yearList.get(random.nextInt(yearList.size()-1)).toString();
            String month = monthList.get(random.nextInt(monthList.size()-1)).toString();
            String day = dayList.get(random.nextInt(dayList.size()-1)).toString();


            sysUser.setBirthday(simpleDateFormat.parse(year+"-"+month+"-"+day));
            sysUser.setSex(random.nextInt(2)+1);


            sysUser.setPassword("cb362cfeefbf3d8d");
            sysUser.setSalt("RCGTeGiH");
            sysUser.setUsername(username.toString());



            log.info(sysUser.toString());
//            userService.save(sysUser);
            list.add(sysUser);
        }
        userService.saveBatch(list);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }

}
