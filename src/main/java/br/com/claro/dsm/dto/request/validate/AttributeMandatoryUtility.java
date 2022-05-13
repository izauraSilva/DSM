package br.com.claro.dsm.dto.request.validate;

import br.com.claro.dsm.dto.request.SubscriptionDTO;
import br.com.claro.dsm.dto.request.exception.AllMandatoryAttributesFilledException;

public class AttributeMandatoryUtility {

    public static final String SVOD = "SVOD";
    public static final String MSG_SVOD = "VERIFICAR - Para SVOD é obrigatório o preenchimento dos seguintes campos: ValidityStartDate e PartnerPurchaseId";

    public static void verifyAttributeMandatoryByType(SubscriptionDTO subscriptionDTO){

        subscriptionDTO.getProductDTOS().stream()
                .filter(s -> s.getType().contains(SVOD))
                .forEach((productDTO) -> {
                    if(productDTO.getValidityStartDate()==null || productDTO.getPartnerPurchaseId()==null){
                        throw new AllMandatoryAttributesFilledException(
                                String.format(MSG_SVOD));
                    }
                });
    }
}