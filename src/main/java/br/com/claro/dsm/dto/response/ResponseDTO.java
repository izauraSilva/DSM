package br.com.claro.dsm.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseDTO {

    @JsonProperty("apiVersion")
    private String apiVersion;
}
