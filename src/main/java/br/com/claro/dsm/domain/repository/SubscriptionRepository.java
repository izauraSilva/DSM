package br.com.claro.dsm.domain.repository;

import br.com.claro.dsm.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Izaura Silva
 *
 * Interface Jpa Repository - entity Subscription
 */
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
