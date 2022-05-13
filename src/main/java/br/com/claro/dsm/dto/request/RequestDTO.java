package br.com.claro.dsm.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;

@Data
public class RequestDTO {

    @JsonProperty(value="data")
    @Valid
    private SubscriptionDTO subscriptionDTO;
}
