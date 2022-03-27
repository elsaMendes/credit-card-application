package com.example.creditcardapplication.repository;

import com.example.creditcardapplication.model.CreditCard;

import java.util.List;

public interface CreditCardRepository {
    CreditCard addNew(CreditCard creditCard);

    List<CreditCard> getAll();
}
