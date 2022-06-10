package br.com.claro.dsm.dto.request;

import br.com.claro.dsm.domain.model.Subscription;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
@Data
public class RequestDTO {

    private Subscription subscription;
}
