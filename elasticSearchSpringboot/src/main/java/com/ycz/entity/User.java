package com.ycz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-30-20:48
 * @Version: V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "user" , shards = 3 , replicas = 1)
public class User {
    @Id
    private Integer id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Integer)
    private Integer age;
    @Field(type = FieldType.Keyword)
    private String address;

}
