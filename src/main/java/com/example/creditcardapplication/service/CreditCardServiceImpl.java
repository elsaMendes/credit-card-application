package com.example.creditcardapplication.service;


import com.example.creditcardapplication.model.CreditCard;
import com.example.creditcardapplication.repository.CreditCardRepository;
import com.example.creditcardapplication.repository.CreditCardRepositoryImpl;

import java.util.List;

public class CreditCardServiceImpl implements CreditCardService {

    private CreditCardRepository creditCardRepository = new CreditCardRepositoryImpl();

    @Override
    public CreditCard addNew(CreditCard creditCard) {
            return creditCardRepository.addNew(creditCard);
    }

    @Override
    public List<CreditCard> getAll() {
        return creditCardRepository.getAll();
    }

}
