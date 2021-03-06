package br.com.claro.dsm.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Izaura Silva
 *
 * Classe config - S3 - Bitbucket
 */
@Configuration
public class AWSConfig {

    @Value("${aws.region}")
    private String region;

    @Value("${aws.key}")
    private String key;

    @Value("${aws.secret}")
    private String secret;

    @Bean
    public AmazonS3 AutheticationS3() {

        return AmazonS3ClientBuilder
                .standard()
                .withRegion(region)
                //.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(key, secret)))
                .build();
    }

}
