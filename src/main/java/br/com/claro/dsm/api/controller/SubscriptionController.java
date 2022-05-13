package br.com.claro.dsm.api.controller;

import br.com.claro.dsm.domain.model.Subscription;
import br.com.claro.dsm.dto.request.RequestDTO;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.claro.dsm.dto.request.validate.AttributeMandatoryUtility.verifyAttributeMandatoryByType;

@RestController
@RequestMapping(value = "/api/dsm")
public class SubscriptionController {

    @PostMapping("/subscription")
    @ResponseStatus(HttpStatus.CREATED)
    public String teste(@Valid @RequestBody RequestDTO request) {

        verifyAttributeMandatoryByType(request.getSubscriptionDTO());

        //segurança blindar entity .. expor somente dto
        val subscription = new ModelMapper().map(request.getSubscriptionDTO(), Subscription.class);

        return "teste";
    }
}
