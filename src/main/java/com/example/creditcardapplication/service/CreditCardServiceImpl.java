package com.example.creditcardapplication.service;


import com.example.creditcardapplication.model.CreditCard;
import com.example.creditcardapplication.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public CreditCard addNew(CreditCard creditCard) {
            return creditCardRepository.save(creditCard);
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
