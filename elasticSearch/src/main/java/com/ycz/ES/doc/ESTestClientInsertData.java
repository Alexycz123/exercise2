package com.ycz.ES.doc;

import com.alibaba.fastjson.JSONObject;
import com.ycz.ES.entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-26-22:19
 * @Version: V1.0
 **/
public class ESTestClientInsertData {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost" , 9200 , "http"))
        );

        IndexRequest request = new IndexRequest();
        request.index("user").id("10001");

        User user = new User();
        user.setAddress("深圳");
        user.setAge(158);
        user.setName("Alex");

        Object o = JSONObject.toJSONString(user);
        System.out.println(o.toString());
        request.source(o.toString() , XContentType.JSON).type();

        IndexResponse index = client.index(request, RequestOptions.DEFAULT);

        System.out.println(index.getResult());



        client.close();

    }
}
