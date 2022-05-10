package br.com.claro.dsm.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "SubscriptionSchema", schema = "subscriptionschema")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSubscription")
    private long idSubscription;

    @Column(name = "applicationConsumer")
    private String applicationConsumer;

    @Column(name = "language")
    private String language;

    @Column(name = "purchaseChannel")
    private String purchaseChannel;

    @Column(name = "purchaseDate")
    private String purchaseDate;

    @Column(name = "discountType")
    private String discountType;

    @Column(name = "offerId")
    private String offerId;

    @Column(name = "accountMemberId")
    private String accountMemberId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscriber_id", referencedColumnName = "idSubscriber")
    private Subscriber subscriber;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<Product> products;

}
