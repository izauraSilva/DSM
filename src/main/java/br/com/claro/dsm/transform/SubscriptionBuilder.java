package br.com.claro.dsm.transform;

import br.com.claro.dsm.domain.model.Payment;
import br.com.claro.dsm.domain.model.Product;
import br.com.claro.dsm.domain.model.Subscriber;
import br.com.claro.dsm.domain.model.Subscription;
import br.com.claro.dsm.dto.request.RequestDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubscriptionBuilder {

    public Subscription getSubscription(RequestDTO request) {

        List<Product> productList = new ArrayList<>();

        request.getSubscriptionDTO().getProductDTOS().forEach(productDTO -> {

            Payment payment = Payment.builder()
                    .value(productDTO.getPaymentDTO().getValue())
                    .type(productDTO.getPaymentDTO().getType())
                    .voucher(productDTO.getPaymentDTO().getVoucher())
                    .referenceValue(productDTO.getPaymentDTO().getReferenceValue())
                    .currency(productDTO.getPaymentDTO().getCurrency())
                    .paymentCardKey(productDTO.getPaymentDTO().getPaymentCardKey())
                    .build();

            Product product = Product.builder()
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
                    .payment(payment)
                    .build();

            productList.add(product);
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

        return subscription;
    }
}
