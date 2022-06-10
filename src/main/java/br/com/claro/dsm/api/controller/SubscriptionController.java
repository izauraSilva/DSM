package br.com.claro.dsm.api.controller;

import br.com.claro.dsm.dto.request.RequestDTO;
import br.com.claro.dsm.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/dsm")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PostMapping("/subscription")
    public ResponseEntity createSubscriptions(@RequestBody RequestDTO request) {

        //service para persitir no BD
        service.createSubscription(request.getSubscription());

        //return somente code http
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
