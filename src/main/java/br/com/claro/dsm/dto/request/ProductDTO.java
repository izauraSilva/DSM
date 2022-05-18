package br.com.claro.dsm.dto.request;

import br.com.claro.dsm.dto.request.check.ProductCheck;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Izaura Silva
 *
 * Classe DTO Product
 */
@Data
@Builder
public class ProductDTO {

    @NotBlank(message = "{referenceKey.not.blank}")
    @JsonProperty("referenceKey")
    private String referenceKey;

    @JsonProperty("id")
    private String productCod;

    @JsonProperty("type")
    private String type;

    @JsonProperty("validityStartDate")
    private String validityStartDate;

    @JsonProperty("validityEndDate")
    private String validityEndDate;

    @JsonProperty("hasAutomaticBilling")
    private Boolean hasAutomaticBilling;

    @NotNull
    @AssertTrue(message = "{isRecurrent.not.blank}", groups = ProductCheck.class)
    @JsonProperty("isRecurrent")
    private Boolean isRecurrent;

    @JsonProperty("orderNumber")
    private String orderNumber;

    @NotBlank(message = "{description.not.blank}")
    @JsonProperty("description")
    private String description;

    @NotBlank(message = "{contentProvider.not.blank}")
    @JsonProperty("contentProvider")
    private String contentProvider;

    @JsonProperty("isAdultCategory")
    private Boolean isAdultCategory;

    @JsonProperty("rentalDuration")
    private String rentalDuration;

    @JsonProperty("partnerPurchaseId")
    private String partnerPurchaseId;

    @JsonProperty("partnerBillingId")
    private String partnerBillingId;

    @JsonProperty("productHashCode")
    private String productHashCode;

    @JsonProperty(value="payment")
    @Valid
    private PaymentDTO paymentDTO;

}
