package com.racloop.data.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories("com.racloop.data.repositories.elasticsearch")
public class ElasticSearchConfig {

    @Value("${elasticsearch.home:/Users/rajanpunchouty/dev/tools/elasticsearch-5.5.0}")
    private String elasticsearchHome;

    @Value("${elasticsearch.cluster.name:crossref-data}")
    private String clusterName;

    @Value("${elasticsearch.properties.path.data:/Users/rajanpunchouty/data/es/data}")
    private String pathData;

    @Value("${elasticsearch.properties.path.logs:/Users/rajanpunchouty/data/es/logs}")
    private String pathLogs;

    @Value("${elasticsearch.host:127.0.0.1}")
    private String host;

    @Value("${elasticsearch.port:9300}")
    private int port;

    @Bean
    public Client client() throws Exception {

        Settings elasticsearchSettings = Settings.builder()
                .put("cluster.name", clusterName)
                .build();
        TransportClient client = new PreBuiltTransportClient(elasticsearchSettings);
        //https://www.elastic.co/guide/en/elasticsearch/guide/current/_transport_client_versus_node_client.html
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}
