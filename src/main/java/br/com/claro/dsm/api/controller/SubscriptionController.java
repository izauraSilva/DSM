package br.com.claro.dsm.api.controller;

import br.com.claro.dsm.domain.model.Subscription;
import br.com.claro.dsm.dto.request.RequestDTO;
import br.com.claro.dsm.service.SubscriptionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.io.IOException;

import static br.com.claro.dsm.dto.request.validate.AttributeMandatoryUtility.verifyAttributeMandatoryByType;

@RestController
@RequestMapping(value = "/api/dsm")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PostMapping("/subscription")
    @ResponseStatus(HttpStatus.CREATED)
    public String teste(@Valid @RequestBody RequestDTO request) {

        //valida campos obrigatórios dependendo do tipo
        verifyAttributeMandatoryByType(request.getSubscriptionDTO());

        //segurança blindar entity .. expor somente dto
        val subscription = new ModelMapper().map(request.getSubscriptionDTO(), Subscription.class);

        service.save(subscription);

        return "teste";
    }
}
