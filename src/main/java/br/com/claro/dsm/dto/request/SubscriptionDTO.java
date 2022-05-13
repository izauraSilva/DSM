package br.com.claro.dsm.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
public class SubscriptionDTO {

    @NotBlank(message = "{applicationConsumer.not.blank}")
    @JsonProperty(value="applicationConsumer")
    private String applicationConsumer;

    @JsonProperty(value="language")
    private String language;

    @NotBlank(message = "{purchaseChannel.not.blank}")
    @JsonProperty(value="purchaseChannel")
    private String purchaseChannel;

    @NotBlank(message = "{purchaseDate.not.blank}")
    @JsonProperty(value="purchaseDate")
    private String purchaseDate;

    @NotBlank(message = "{discountType.not.blank}")
    @JsonProperty(value="discountType")
    private String discountType;

    @JsonProperty(value="offerId")
    private String offerId;

    @JsonProperty(value="accountMemberId")
    private String accountMemberId;

    @JsonProperty(value="subscriber")
    @Valid
    private SubscriberDTO subscriberDTO;

    @JsonProperty(value="products")
    @Valid
    private List<ProductDTO> productDTOS;

}
