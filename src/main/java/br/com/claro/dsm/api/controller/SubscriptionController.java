package br.com.claro.dsm.api.controller;

import br.com.claro.dsm.dto.request.RequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/dsm")
public class SubscriptionController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String teste(@Valid @RequestBody RequestDTO request) {
        return "teste";
    }
}
