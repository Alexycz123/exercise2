package com.ycz.ES.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
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
public class ESTestClientBatchDELETEData {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost" , 9200 , "http"))
        );

        BulkRequest request = new BulkRequest();

        request.add(new DeleteRequest().index("user").id("100002"));
        request.add(new DeleteRequest().index("user").id("100003"));
        request.add(new DeleteRequest().index("user").id("100004"));


        BulkResponse bulk = client.bulk(request, RequestOptions.DEFAULT);

        System.out.println(bulk.status());



        client.close();

    }
}
