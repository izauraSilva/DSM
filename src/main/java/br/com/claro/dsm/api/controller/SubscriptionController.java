package br.com.claro.dsm.api.controller;

import br.com.claro.dsm.domain.model.Subscription;
import br.com.claro.dsm.dto.request.RequestDTO;
import br.com.claro.dsm.transform.SubscriptionBuilder;
import br.com.claro.dsm.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.claro.dsm.dto.request.validate.AttributeMandatoryUtility.verifyAttributeMandatoryByType;

@RestController
@RequestMapping(value = "/api/dsm")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @Autowired
    private SubscriptionBuilder subscriptionBuilder;

    @PostMapping("/subscription")
    public ResponseEntity createSubscriptions(@Valid @RequestBody RequestDTO request) {

        //valida campos obrigatórios dependendo do tipo
        verifyAttributeMandatoryByType(request.getSubscriptionDTO());

        //blindar entity .. expor somente dto
        Subscription subscription = subscriptionBuilder.getSubscription(request);

        //persitir no BD
        service.save(subscription);

        //return somente code http
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
