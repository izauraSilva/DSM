package br.com.claro.dsm.api.controller;

import br.com.claro.dsm.domain.model.Subscription;
import br.com.claro.dsm.dto.request.RequestDTO;
import br.com.claro.dsm.service.SubscriptionService;
import br.com.claro.dsm.transform.SubscriptionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/dsm")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @Autowired
    private SubscriptionBuilder subscriptionBuilder;

    @PostMapping("/subscription")
    public ResponseEntity createSubscriptions(@Valid @RequestBody RequestDTO request) {

        //blindar entity .. expor somente dto
        Subscription subscription = subscriptionBuilder.getSubscription(request);

        //service para persitir no BD
        service.createSubscription(subscription);

        //return somente code http
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
