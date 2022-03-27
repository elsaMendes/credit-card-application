package com.example.creditcardapplication.repository;

import com.example.creditcardapplication.model.CreditCard;
import org.springframework.data.repository.CrudRepository;

public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
}
