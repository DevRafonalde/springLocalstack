package br.com.ntendencia.springApi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.Topic;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.net.URI;

@Configuration
public class AwsConfiguration {
    private static final String ENDPOINT_URL = "http://localhost:4566";

    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("test", "test")
                ))
                .endpointOverride(URI.create(ENDPOINT_URL))
                .build();
    }

    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("test", "test")
                ))
                .endpointOverride(URI.create(ENDPOINT_URL))
                .build();
    }

    @Bean
    @Autowired
    public String notificationQueueUrl(SqsClient sqsClient) {
        return sqsClient.getQueueUrl(builder -> {
            builder.queueName("DEV_CONTRATACAO");
        }).queueUrl();
    }

    @Bean(name = "DEV_SNS_CONTRATACAO")
    public Topic snsProductEventsTopic() {
        return Topic.builder().topicArn("arn:aws:sns:us-east-1:000000000000:DEV_SNS_CONTRATACAO").build();
    }
}