package br.com.claro.dsm.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "SubscriberSchema", schema = "subscriptionschema")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSubscriber")
    private long idSubscriber;

    @Column(name = "accountOwnerId")
    private String accountOwnerId;

    @Column(name = "name")
    private String name;

    @Column(name = "identificationId")
    private String identificationId;

    @Column(name = "identificationType")
    private String identificationType;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "emailAddress")
    private String emailAddress;

    @OneToOne(mappedBy = "subscriber")
    private Subscription subscription;

}
