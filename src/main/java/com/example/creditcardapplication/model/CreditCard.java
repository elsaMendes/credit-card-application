package com.example.creditcardapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String number;
    private LocalDate expireDate;
    private LocalDate issueDate;
    private int securityCode;
    private int cardLimit;
    private int balance;

    public CreditCard() {
    }

    public CreditCard(String name, String number, LocalDate expireDate, LocalDate issueDate, int securityCode, int cardLimit, int balance) {
        this.name = name;
        this.number = number;
        this.expireDate = expireDate;
        this.issueDate = issueDate;
        this.securityCode = securityCode;
        this.cardLimit = cardLimit;
        this.balance = balance;
    }

    public long getId() {
        return id;
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

    public int getCardLimit() {
        return cardLimit;
    }

    public int getBalance() {
        return balance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public void setCardLimit(int cardLimit) {
        this.cardLimit = cardLimit;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", expireDate=" + expireDate +
                ", issueDate=" + issueDate +
                ", securityCode=" + securityCode +
                ", cardLimit=" + cardLimit +
                ", balance=" + balance +
                '}';
    }
}
