package br.com.claro.dsm.dto.request.validate;

import br.com.claro.dsm.dto.request.SubscriptionDTO;
import br.com.claro.dsm.dto.request.exception.AllMandatoryAttributesFilledException;

public class AttributeMandatoryUtility {

    public static final String SVOD = "SVOD";
    public static final String TVOD = "TVOD";

    public static final String MSG_SVOD = "VERIFICAR - Para SVOD é obrigatório o preenchimento em Products: ValidityStartDate, ValidityEndDate, OrderNumber e HasAutomaticBilling";
    public static final String MSG_TVOD = "VERIFICAR - Para TVOD é obrigatório o preenchimento dos seguintes campos: ???? ";

    public static void verifyAttributeMandatoryByType(SubscriptionDTO subscriptionDTO){

        svod(subscriptionDTO);

        tvod(subscriptionDTO);
    }

    private static void tvod(SubscriptionDTO subscriptionDTO) {
        subscriptionDTO.getProductDTOS().stream()
            .filter(s -> s.getType().contains(TVOD))
            .forEach((productDTO) -> {
                if(productDTO.getValidityStartDate()==null || productDTO.getPartnerPurchaseId()==null){
                    throw new AllMandatoryAttributesFilledException(
                            String.format(MSG_TVOD));
                }
            });
    }

    private static void svod(SubscriptionDTO subscriptionDTO) {
        subscriptionDTO.getProductDTOS().stream()
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
