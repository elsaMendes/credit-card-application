package com.example.creditcardapplication.service;

import com.example.creditcardapplication.model.CreditCard;

import java.util.List;

public interface CreditCardService {
    CreditCard addNew(CreditCard creditCard);

    List<CreditCard> getAll();
}
