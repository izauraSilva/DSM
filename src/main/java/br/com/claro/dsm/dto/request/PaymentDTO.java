package br.com.claro.dsm.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Izaura Silva
 *
 * Classe DTO Payment
 */
@Data
@Builder
public class PaymentDTO {

    @NotBlank(message = "{value.not.blank}")
    @JsonProperty("value")
    private String value;

    @NotBlank(message = "{type.not.blank}")
    @JsonProperty("type")
    private String type;

    @JsonProperty("voucher")
    private String voucher;

    @NotBlank(message = "{referenceValue.not.blank}")
    @JsonProperty("referenceValue")
    private String referenceValue;

    @NotBlank(message = "{currency.not.blank}")
    @JsonProperty("currency")
    private String currency;

    @JsonProperty("paymentCardKey")
    private String paymentCardKey;
}
