package br.com.claro.dsm.s3BucketStorage.repositories.service;

import br.com.claro.dsm.domain.model.Subscription;

public interface SubscriptionService {

    Subscription createSubscription(Subscription subscription);
}
