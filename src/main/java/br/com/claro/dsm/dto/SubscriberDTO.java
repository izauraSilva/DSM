package br.com.claro.dsm.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SubscriberDTO {

    @NotBlank(message = "{accountOwnerId.not.blank}")
    private String accountOwnerId;

    @NotBlank(message = "{name.not.blank}")
    private String name;

    @NotBlank(message = "{identificationId.not.blank}")
    private String identificationId;

    @NotBlank(message = "{identificationType.not.blank}")
    private String identificationType;

    @NotBlank(message = "{phoneNumber.not.blank}")
    private String phoneNumber;

    @NotBlank(message = "{emailAddress.not.blank}")
    @Email
    private String emailAddress;

}
