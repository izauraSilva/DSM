package br.com.claro.dsm.dto.request.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Izaura Silva
 *
 * Classe error bad request - campos obrigatórios conforme tipo do produto
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AllMandatoryAttributesFilledException extends RuntimeException  {

    private static final long serialVersionUID = 1L;

    /**
     * Mensagem informativa campos obrigatórios conforme tipo do produto
     * @param mensagem
     */
    public AllMandatoryAttributesFilledException(String mensagem) {
        super(mensagem);
    }

}
