package com.sber.trade.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class Deposit implements Account {

    @Autowired
    private DepositAccount account;

    public void close(){
        account.setBalance(0.0F);
    }

    @Override
    public void add(float amount) {
        account.add(amount);
    }

    @Override
    public float getBalance() {
        return account.getBalance();
    }

    @Override
    public void setBalance(float amount) {
        account.setBalance(amount);
    }
}
