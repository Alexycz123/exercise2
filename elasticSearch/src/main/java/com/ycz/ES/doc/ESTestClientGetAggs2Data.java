package com.ycz.ES.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.ParseField;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.Map;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-26-22:19
 * @Version: V1.0
 **/
public class ESTestClientGetAggs2Data {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost" , 9200 , "http"))
        );

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();

        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("age_group").field("age");

        builder.aggregation(aggregationBuilder);

        searchRequest.source(builder);


        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = search.getHits();

        Aggregations aggregations = search.getAggregations();
        Map<String, Aggregation> asMap = aggregations.getAsMap();
        System.out.println(asMap.keySet());
        /**
         * public static final class CommonFields extends org.elasticsearch.common.ParseField.CommonFields {
         *         public static final ParseField META = new ParseField("meta", new String[0]);
         *         public static final ParseField BUCKETS = new ParseField("buckets", new String[0]);
         *         public static final ParseField VALUE = new ParseField("value", new String[0]);
         *         public static final ParseField VALUES = new ParseField("values", new String[0]);
         *         public static final ParseField VALUE_AS_STRING = new ParseField("value_as_string", new String[0]);
         *         public static final ParseField DOC_COUNT = new ParseField("doc_count", new String[0]);
         *         public static final ParseField KEY = new ParseField("key", new String[0]);
         *         public static final ParseField KEY_AS_STRING = new ParseField("key_as_string", new String[0]);
         *         public static final ParseField FROM = new ParseField("from", new String[0]);
         *         public static final ParseField FROM_AS_STRING = new ParseField("from_as_string", new String[0]);
         *         public static final ParseField TO = new ParseField("to", new String[0]);
         *         public static final ParseField TO_AS_STRING = new ParseField("to_as_string", new String[0]);
         *
         *         public CommonFields() {
         *         }
         *     }
         */



        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        client.close();

    }


}
