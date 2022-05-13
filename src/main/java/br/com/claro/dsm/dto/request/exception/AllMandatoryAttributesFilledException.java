package br.com.claro.dsm.dto.request.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AllMandatoryAttributesFilledException extends RuntimeException  {

    private static final long serialVersionUID = 1L;

    public AllMandatoryAttributesFilledException(String mensagem) {
        super(mensagem);
    }

}
