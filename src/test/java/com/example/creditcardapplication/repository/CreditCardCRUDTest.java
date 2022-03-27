package com.example.creditcardapplication.repository;

import com.example.creditcardapplication.model.CreditCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CreditCardCRUDTest {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Test
    public void testCreateAndReadOperation() {
        LocalDate expire = LocalDate.of(2023, 2, 23);
        LocalDate issue = LocalDate.of(2019, 2, 23);
        CreditCard validCreditCard = new CreditCard();
        validCreditCard.setName("Elsa Mendes");
        validCreditCard.setNumber("4847352989263094");
        validCreditCard.setExpireDate(expire);
        validCreditCard.setIssueDate(issue);
        validCreditCard.setSecurityCode(333);
        validCreditCard.setCardLimit(2000);
        validCreditCard.setBalance(300);

        creditCardRepository.save(validCreditCard);

        assertThat(creditCardRepository.findAll())
                .hasSize(1)
                .first()
                .isEqualTo(validCreditCard);

        creditCardRepository.deleteById(validCreditCard.getId());
        assertThat(creditCardRepository.count()).isZero();

    }


}