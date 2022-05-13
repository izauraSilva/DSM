package br.com.claro.dsm.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "productSchema", schema = "subscriptionschema")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private long idProduct;

    @Column(name = "referenceKey")
    private String referenceKey;

    @Column(name = "id")
    private String productCod;

    @Column(name = "type")
    private String type;

    @Column(name = "validityStartDate")
    private String validityStartDate;

    @Column(name = "validityEndDate")
    private String validityEndDate;

    @Column(name = "hasAutomaticBilling")
    private Boolean hasAutomaticBilling;

    @Column(name = "isRecurrent")
    private Boolean isRecurrent;

    @Column(name = "orderNumber")
    private String orderNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "contentProvider")
    private String contentProvider;

    @Column(name = "isAdultCategory")
    private Boolean isAdultCategory;

    @Column(name = "rentalDuration")
    private String rentalDuration;

    @Column(name = "partnerPurchaseId")
    private String partnerPurchaseId;

    @Column(name = "partnerBillingId")
    private String partnerBillingId;

    @Column(name = "productHashCode")
    private String productHashCode;

    /*@ManyToOne(cascade=CascadeType.PERSIST)
    @JsonIgnore
    @JoinColumn(name = "idSubscription")
    private Subscription subscription;*/

}
