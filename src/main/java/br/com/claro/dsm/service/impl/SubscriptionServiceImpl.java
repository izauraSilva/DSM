package br.com.claro.dsm.service.impl;

import br.com.claro.dsm.domain.model.Subscription;
import br.com.claro.dsm.domain.repository.SubscriptionRepository;
import br.com.claro.dsm.service.SubscriptionService;
import br.com.claro.dsm.service.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionRepository repository;
    @Override
    public void createSubscription(Subscription subscription) {
        try {
            repository.save(subscription);
        } catch (Exception e) {
            throw new InternalException(String.format(e.getCause().getCause().toString()));
        }
    }
}
