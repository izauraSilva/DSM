package br.com.claro.dsm.dto;

import javax.validation.constraints.NotBlank;

public class SubscriptionDTO {

    @NotBlank(message = "{applicationConsumer.not.blank}")
    private String applicationConsumer;

    private String language;

    @NotBlank(message = "{purchaseChannel.not.blank}")
    private String purchaseChannel;

    @NotBlank(message = "{purchaseDate.not.blank}")
    private String purchaseDate;

    @NotBlank(message = "{discountType.not.blank}")
    private String discountType;

    private String offerId;

    private String accountMemberId;
}
