package com.sber.trade.model;

import com.sber.trade.exception.OutOfBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class DebitCard implements Account {

    @Autowired
    private DepositAccount account;

    @Override
    public void add(float amount) {
        account.add(amount);
    }

    public void withdraw(float amount) {
        if(account.getBalance() >= amount)
            account.setBalance(account.getBalance() - amount);
        else
            throw new OutOfBalanceException("Не достаточно средств на счету: " + account.getBalance());
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
