package com.example.creditcardapplication.repository;

import com.example.creditcardapplication.model.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class CreditCardRepositoryImpl implements CreditCardRepository {
    private List<CreditCard> creditCards = new ArrayList<>();

    @Override
    public CreditCard addNew(CreditCard creditCard) {
        creditCards.add(creditCard);
        return creditCard;
    }

    @Override
    public List<CreditCard> getAll() {
        return creditCards;
    }
}
