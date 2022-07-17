package com.ycz.ES.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-26-22:19
 * @Version: V1.0
 **/
public class ESTestClientGetRangeData {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost" , 9200 , "http"))
        );

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        SearchSourceBuilder query = new SearchSourceBuilder().
                query(QueryBuilders.matchAllQuery());
        RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("age");
        rangeQueryBuilder.lte(20);
        rangeQueryBuilder.gte(10);

        query.query(rangeQueryBuilder);

        searchRequest.source(query);

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = search.getHits();

        System.out.println(search.getTook());

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        client.close();

    }


}
