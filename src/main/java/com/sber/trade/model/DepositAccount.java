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
public class DepositAccount implements Account {

    @Value("${account.currency}")
    private String currency;

    @Value("${account.balance}")
    private float balance;

    @Value("${account.name}")
    private String name;

    private boolean isClosed;

    @Override
    public void add(float amount) {
        balance += amount;
    }

    @Override
    public float getBalance(){
        return balance;
    }

}
