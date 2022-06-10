package br.com.claro.dsm.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "assinante")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSubscriber")
    private long idSubscriber;

    @Column(name = "accountOwnerId", nullable = false)
    private String accountOwnerId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "identificationId", nullable = false)
    private String identificationId;

    @Column(name = "identificationType", nullable = false)
    private String identificationType;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "emailAddress", nullable = false)
    private String emailAddress;

}
