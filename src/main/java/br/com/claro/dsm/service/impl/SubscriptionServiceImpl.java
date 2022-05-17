package br.com.claro.dsm.service.impl;

import br.com.claro.dsm.domain.model.Subscription;
import br.com.claro.dsm.domain.repository.SubscriptionRepository;
import br.com.claro.dsm.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository repository;

    @Override
    public Subscription createSubscription(Subscription subscription) {
        return repository.save(subscription);
    }
}
