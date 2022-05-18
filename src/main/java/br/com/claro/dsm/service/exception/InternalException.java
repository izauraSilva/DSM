package br.com.claro.dsm.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Izaura Silva
 *
 * Classe Error INTERNAL_SERVER_ERROR
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalException extends RuntimeException  {

    private static final long serialVersionUID = 1L;

    /**
     * @param mensagem
     */
    public InternalException(String mensagem) {
        super(mensagem);
    }

}
