package br.com.claro.dsm.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class SubscriberDTO {

    @NotBlank(message = "{accountOwnerId.not.blank}")
    @JsonProperty(value="accountOwnerId")
    private String accountOwnerId;

    @NotBlank(message = "{name.not.blank}")
    @JsonProperty(value="name")
    private String name;

    @NotBlank(message = "{identificationId.not.blank}")
    @JsonProperty(value="identificationId")
    private String identificationId;

    @NotBlank(message = "{identificationType.not.blank}")
    @JsonProperty(value="identificationType")
    private String identificationType;

    @NotBlank(message = "{phoneNumber.not.blank}")
    @JsonProperty(value="phoneNumber")
    private String phoneNumber;

    @NotBlank(message = "{emailAddress.not.blank}")
    @Email
    @JsonProperty(value="emailAddress")
    private String emailAddress;

}
