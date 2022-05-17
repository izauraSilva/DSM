package br.com.claro.dsm.api.controller;

import br.com.claro.dsm.domain.model.Product;
import br.com.claro.dsm.domain.model.Subscriber;
import br.com.claro.dsm.domain.model.Subscription;
import br.com.claro.dsm.dto.request.RequestDTO;
import br.com.claro.dsm.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/dsm")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PostMapping("/subscription")
    @ResponseStatus(HttpStatus.CREATED)
    public String teste(@Valid @RequestBody RequestDTO request) {

        //valida campos obrigatórios dependendo do tipo
        //verifyAttributeMandatoryByType(request.getSubscriptionDTO());

        //segurança blindar entity .. expor somente dto
        //val subscription = new ModelMapper().map(request.getSubscriptionDTO(), Subscription.class);

        List<Product> productList = new ArrayList<>();

        request.getSubscriptionDTO().getProductDTOS().forEach(productDTO -> {
            Product p = Product.builder()
                    .referenceKey(productDTO.getReferenceKey())
                    .productCod(productDTO.getProductCod())
                    .type(productDTO.getType())
                    .validityStartDate(productDTO.getValidityStartDate())
                    .validityEndDate(productDTO.getValidityEndDate())
                    .hasAutomaticBilling(productDTO.getHasAutomaticBilling())
                    .isRecurrent(productDTO.getIsRecurrent())
                    .orderNumber(productDTO.getOrderNumber())
                    .description(productDTO.getDescription())
                    .contentProvider(productDTO.getContentProvider())
                    .isAdultCategory(productDTO.getIsAdultCategory())
                    .rentalDuration(productDTO.getRentalDuration())
                    .partnerPurchaseId(productDTO.getPartnerPurchaseId())
                    .partnerBillingId(productDTO.getPartnerBillingId())
                    .productHashCode(productDTO.getProductHashCode())
                    .build();
            productList.add(p);
        });

        Subscriber subscriber = Subscriber.builder()
                .accountOwnerId(request.getSubscriptionDTO().getSubscriberDTO().getAccountOwnerId())
                .name(request.getSubscriptionDTO().getSubscriberDTO().getName())
                .identificationId(request.getSubscriptionDTO().getSubscriberDTO().getIdentificationId())
                .identificationType(request.getSubscriptionDTO().getSubscriberDTO().getIdentificationType())
                .phoneNumber(request.getSubscriptionDTO().getSubscriberDTO().getPhoneNumber())
                .emailAddress(request.getSubscriptionDTO().getSubscriberDTO().getEmailAddress())
                .build();

        Subscription subscription = Subscription.builder()
                .applicationConsumer(request.getSubscriptionDTO().getApplicationConsumer())
                .language(request.getSubscriptionDTO().getLanguage())
                .purchaseChannel(request.getSubscriptionDTO().getPurchaseChannel())
                .purchaseDate(request.getSubscriptionDTO().getPurchaseDate())
                .discountType(request.getSubscriptionDTO().getDiscountType())
                .offerId(request.getSubscriptionDTO().getOfferId())
                .accountMemberId(request.getSubscriptionDTO().getAccountMemberId())
                .subscriber(subscriber)
                .products(productList)
                .build();

        service.save(subscription);

        return "teste";
    }
}
