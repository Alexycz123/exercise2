package com.ycz;

import com.ycz.dao.UserDao;
import com.ycz.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;

import javax.swing.plaf.SpinnerUI;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ElasticSearchSpringbootApplicationTests {

    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println("创建索引");
    }

    @Test
    void deleteIndex(){
        boolean b = restTemplate.deleteIndex(User.class);
        System.out.println(b);
    }

    @Test
    public void saveData(){
        User user = new User();
        user.setAge(18);
        user.setAddress("深圳");
        user.setId(2);
        user.setName("asdasdas");
        userDao.save(user);
    }

    @Test
    public void search(){
        Iterable<User> all = userDao.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void saveBatch(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(10 + i);
            user.setId( 3 + i);
            user.setName("admin:" + i);
            user.setAddress("深圳【"+i + "】");
            userList.add(user);
        }
        userDao.saveAll(userList);
    }

    @Test
    public void findByPage(){
        Sort sort = Sort.by(Sort.Direction.DESC, "age");

        int currentPage = 0;
        int size = 5;

        PageRequest of = PageRequest.of(currentPage, size , sort);

        Page<User> all = userDao.findAll(of);
        all.getContent().forEach(System.out::println);
    }
}
