package com.example.creditcardapplication.service;


import com.example.creditcardapplication.exception.InvalidCreditCardNumberException;
import com.example.creditcardapplication.exception.InvalidCreditCardStartBalanceException;
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
        if (invalidCardNumber(creditCard.getNumber())) {
            throw new InvalidCreditCardNumberException("Invalid Credit Card Number Exception: " + creditCard.getNumber());
        } if (invalidStartBalance(creditCard.getBalance())) {
            throw new InvalidCreditCardStartBalanceException("Start balance should be 0, invalid value: " + creditCard.getBalance());
        }
        return creditCardRepository.save(creditCard);
    }

    private boolean invalidCardNumber(String number) {
        return !LuhnTen.validate(number);
    }

    private boolean invalidStartBalance(int balance) {
        return balance != 0;
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
