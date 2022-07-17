package com.ycz.ES.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-26-22:19
 * @Version: V1.0
 **/
public class ESTestClientGetAggsData {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost" , 9200 , "http"))
        );

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();

        AggregationBuilder aggregationBuilder = AggregationBuilders.avg("avg_age").field("age");

        builder.aggregation(aggregationBuilder);

        searchRequest.source(builder);


        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = search.getHits();

        Aggregations aggregations = search.getAggregations();
        Map<String, Aggregation> asMap = aggregations.getAsMap();

        for (String s : asMap.keySet()) {
            System.out.println(s);
            System.out.println(asMap.get(s));
        }


        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        client.close();

    }


}
