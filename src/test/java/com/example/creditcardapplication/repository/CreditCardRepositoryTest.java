package com.example.creditcardapplication.repository;

import com.example.creditcardapplication.model.CreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Given there's a CreditCard repository")
class CreditCardRepositoryTest {

    @Autowired
    private CreditCardRepository creditCardRepository;
    private CreditCard validCreditCard;

    @BeforeEach
    public void setUp() {
        LocalDate expire = LocalDate.of(2023, 2, 23);
        LocalDate issue = LocalDate.of(2019, 2, 23);
        validCreditCard = new CreditCard("Elsa Mendes", "4847352989263094", expire,
                issue, 333, 2000, 700);
    }

    @DisplayName("When given a credit card number, then it should add it successfully")
    @Test
    void addNew() {

        CreditCard creditCardAdded = creditCardRepository.save(validCreditCard);

        assertAll( "Verify all properties of the added CreditCard",
                () -> assertEquals("Elsa Mendes", creditCardAdded.getName()),
                () -> assertEquals("4847352989263094", creditCardAdded.getNumber()),
                () -> assertEquals(333, creditCardAdded.getSecurityCode()),
                () -> assertEquals(2000, creditCardAdded.getCardLimit()),
                () -> assertEquals(700, creditCardAdded.getBalance())
        );

        creditCardRepository.deleteById(creditCardAdded.getId());
    }

    @DisplayName("When retrieving existing credit card numbers, then it should it should return list of existing ones")
    @Test
    void getAll() {
        CreditCard creditCardAdded = creditCardRepository.save(validCreditCard);

        assertThat(creditCardRepository.findAll()).anyMatch(cc -> cc.getId() == creditCardAdded.getId());

        creditCardRepository.deleteById(creditCardAdded.getId());
    }
}