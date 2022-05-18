package br.com.claro.dsm.dto.request.validate;

import br.com.claro.dsm.domain.model.Subscription;
import br.com.claro.dsm.dto.request.exception.AllMandatoryAttributesFilledException;

/**
 * @author Izaura Silva
 *
 * Classe Regra atributos mandatórios conforme tipo do produto
 */
public class AttributeMandatoryUtility {

    public static final String SVOD = "SVOD";
    public static final String TVOD = "TVOD";

    public static final String MSG_SVOD = "VERIFICAR - Para SVOD é obrigatório o preenchimento em Products: ValidityStartDate, ValidityEndDate, OrderNumber e HasAutomaticBilling";
    public static final String MSG_TVOD = "VERIFICAR - Para TVOD é obrigatório o preenchimento dos seguintes campos: ???? ";

    /**
     * Verificação tipo do produto para aplicar regra de campos obrigatórios
     * @param subscription
     */
    public static void verifyAttributeMandatoryByType(Subscription subscription){
        svod(subscription);
        tvod(subscription);
    }

    /**
     * Tipo de produto TVOD - verificação campos obrigatórios
     * @param subscription
     */
    private static void tvod(Subscription subscription) {
        subscription.getProducts().stream()
            .filter(s -> s.getType().contains(TVOD))
            .forEach((productDTO) -> {
                if(productDTO.getValidityStartDate()==null || productDTO.getPartnerPurchaseId()==null){
                    throw new AllMandatoryAttributesFilledException(
                            String.format(MSG_TVOD));
                }
            });
    }

    /**
     * Tipo de produto SVOD - verificação campos obrigatórios
     * @param subscription
     */
    private static void svod(Subscription subscription) {
        subscription.getProducts().stream()
                .filter(s -> s.getType().contains(SVOD))
                .forEach((productDTO) -> {
                    if(productDTO.getValidityStartDate()==null || productDTO.getValidityEndDate()==null
                            || productDTO.getHasAutomaticBilling()==null || productDTO.getOrderNumber()==null){
                        throw new AllMandatoryAttributesFilledException(
                                String.format(MSG_SVOD));
                    }
                });
    }
}
