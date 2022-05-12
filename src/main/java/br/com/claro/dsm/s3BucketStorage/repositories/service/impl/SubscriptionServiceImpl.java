package br.com.claro.dsm.s3BucketStorage.repositories.service.impl;

import br.com.claro.dsm.domain.model.Subscription;
import br.com.claro.dsm.repository.SubscriptionRepository;
import br.com.claro.dsm.s3BucketStorage.repositories.service.SubscriptionService;
import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private AmazonS3 amazonS3Client;

    @Value("${aws.bucketName}")
    private String bucketName;

    @Autowired
    private SubscriptionRepository repository;

    @Override
    public Subscription createSubscription(Subscription subscription) {
        return repository.save(subscription);
    }

}
