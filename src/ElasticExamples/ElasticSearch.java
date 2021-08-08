package ElasticExamples;


import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

import java.io.IOException;
import java.util.Date;

public class ElasticSearch {

    public static void main(String[] args) throws IOException {

        ClientConfiguration clientConfiguration =
                ClientConfiguration.builder()
                        .connectedTo("http://api-gateway-bpm-qa.apps.r7mikab1.westeurope.aroapp.io/elastic/")
                        .build();

        RestHighLevelClient client = RestClients.create(clientConfiguration).rest();

        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field("fullName", "Test")
                .field("dateOfBirth", new Date())
                .field("age", "10")
                .endObject();

        IndexRequest indexRequest = new IndexRequest("dev-proc-history");
        indexRequest.source(builder);

        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
        //assertEquals(Result.CREATED, response.getResult());

        System.out.println(response.toString());

    }

}
