package com.example.creditcardapplication.model;

import java.time.LocalDate;

public class CreditCard {

    private String name;
    private String number;
    private LocalDate expireDate;
    private LocalDate issueDate;
    private int securityCode;
    private int limit;
    private int balance;

    public CreditCard() {
    }

    public CreditCard(String name, String number, LocalDate expireDate, LocalDate issueDate, int securityCode, int limit, int balance) {
        this.name = name;
        this.number = number;
        this.expireDate = expireDate;
        this.issueDate = issueDate;
        this.securityCode = securityCode;
        this.limit = limit;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public int getLimit() {
        return limit;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", expireDate=" + expireDate +
                ", issueDate=" + issueDate +
                ", securityCode=" + securityCode +
                ", limit=" + limit +
                ", balance=" + balance +
                '}';
    }
}
