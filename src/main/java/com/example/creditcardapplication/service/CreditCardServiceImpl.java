package com.example.creditcardapplication.service;


import com.example.creditcardapplication.exception.InvalidCreditCardNumberException;
import com.example.creditcardapplication.model.CreditCard;
import com.example.creditcardapplication.repository.CreditCardRepository;
import com.example.creditcardapplication.util.LuhnTen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("creditCardService")
public class CreditCardServiceImpl implements CreditCardService {

    private CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public CreditCard addNew(CreditCard creditCard) {
        if (LuhnTen.validate(creditCard.getNumber())) {
            return creditCardRepository.save(creditCard);
        } else {
            throw new InvalidCreditCardNumberException("Invalid Credit Card Number Exception: " + creditCard.getNumber());
        }
    }

    @Override
    public List<CreditCard> getAll() {
        List<CreditCard> creditCardList = new ArrayList<>();
        creditCardRepository.findAll()
                .iterator()
                .forEachRemaining(creditCardList :: add);
        return creditCardList;
    }

}
