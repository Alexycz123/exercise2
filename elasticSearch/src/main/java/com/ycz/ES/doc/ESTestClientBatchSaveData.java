package com.ycz.ES.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-26-22:19
 * @Version: V1.0
 **/
public class ESTestClientBatchSaveData {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost" , 9200 , "http"))
        );

        BulkRequest request = new BulkRequest();

//        request.add(new IndexRequest().index("user").id("100002").source(XContentType.JSON , "name" , "ycz" , "age" , 22 , "address","东莞"));
        request.add(new IndexRequest().index("user").id("100006").source(XContentType.JSON , "name" , "zhangsan1" , "age" , 20 , "address","深圳"));
        request.add(new IndexRequest().index("user").id("100007").source(XContentType.JSON , "name" , "zhangsan2" , "age" , 20 , "address","深圳"));
        request.add(new IndexRequest().index("user").id("100008").source(XContentType.JSON , "name" , "zhangsan33" , "age" , 20 , "address","深圳"));
//        request.add(new IndexRequest().index("user").id("100004").source(XContentType.JSON , "name" , "lisi" , "age" , 30 , "address","佛山"));


        BulkResponse bulk = client.bulk(request, RequestOptions.DEFAULT);

        System.out.println(bulk.status());



        client.close();

    }
}
