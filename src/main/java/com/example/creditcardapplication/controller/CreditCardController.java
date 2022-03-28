package com.example.creditcardapplication.controller;

import com.example.creditcardapplication.exception.InvalidCreditCardNumberException;
import com.example.creditcardapplication.exception.InvalidCreditCardStartBalanceException;
import com.example.creditcardapplication.model.CreditCard;
import com.example.creditcardapplication.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("creditCardController")
@RequestMapping("/creditcards")
public class CreditCardController {

    private CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CreditCard>> getAll() {
        List<CreditCard> creditCardList = creditCardService.getAll();
        ResponseEntity<List<CreditCard>> responseEntity = new ResponseEntity<>(creditCardList, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/")
    public ResponseEntity<CreditCard> addNew(@RequestBody CreditCard creditCard) {
        try {
            CreditCard creditcardAdded = creditCardService.addNew(creditCard);
            return new ResponseEntity<>(creditcardAdded, HttpStatus.CREATED);
        } catch (InvalidCreditCardNumberException e) {
            return handleInvalidCreditCardException(e);
        } catch (InvalidCreditCardStartBalanceException e) {
            return handleInvalidCreditCardException(e);
        }
    }

    @ExceptionHandler
    public ResponseEntity handleInvalidCreditCardException(InvalidCreditCardNumberException invalidCreditCardNumberException) {
        return new ResponseEntity(invalidCreditCardNumberException.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler
    public ResponseEntity handleInvalidCreditCardException(InvalidCreditCardStartBalanceException invalidCreditCardStartBalanceException) {
        return new ResponseEntity(invalidCreditCardStartBalanceException.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

}
