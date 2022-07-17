package com.ycz.dao;

import com.ycz.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-30-20:55
 * @Version: V1.0
 **/
@Repository
public interface UserDao extends ElasticsearchRepository<User , Long> {
}
