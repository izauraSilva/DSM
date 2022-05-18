package br.com.claro.dsm.service;

import br.com.claro.dsm.domain.model.Subscription;

/**
 * @author Izaura Silva
 *
 * Interface da Gestão de Assinaturas
 */
public interface SubscriptionService {

    /**
     * Interface - Gerir dados da assinatura
     * @param subscription
     */
    void createSubscription(Subscription subscription);
}
