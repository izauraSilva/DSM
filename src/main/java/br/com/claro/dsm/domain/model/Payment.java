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
@Table(name = "pagamento")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPayment")
    private long idPayment;

    @Column(name = "value")
    private String value;

    @Column(name = "type")
    private String type;

    @Column(name = "voucher")
    private String voucher;

    @Column(name = "referenceValue")
    private String referenceValue;

    @Column(name = "currency")
    private String currency;

    @Column(name = "paymentCardKey")
    private String paymentCardKey;

}
