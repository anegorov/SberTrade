package com.sber.trade.model;

public interface Account {
    void add(float amount);
    float getBalance();
    void setBalance(float amount);
}
