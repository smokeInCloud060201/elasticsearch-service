package vn.com.smoke.searchservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchClients;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.support.HttpHeaders;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ElasticSearchClientConfig extends ElasticsearchConfiguration {
    @Override
    public ClientConfiguration clientConfiguration() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("some-header", "on every request");

        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .withConnectTimeout(Duration.ofSeconds(10))
                .withSocketTimeout(Duration.ofSeconds(5))
                .withDefaultHeaders(httpHeaders)
                .withHeaders(() -> {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("currentTime", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                    return headers;
                })
                .withClientConfigurer(ElasticsearchClients.ElasticsearchRestClientConfigurationCallback.from(restClientBuilder -> restClientBuilder))
                .build();
    }
}
