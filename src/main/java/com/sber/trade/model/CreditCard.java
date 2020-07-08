package com.sber.trade.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class CreditCard extends DebitCard {

    @Value("${creditCard.interestRate}")
    private float interestRate;

    @Value("${creditCard.debt}")
    private float debt;

}
