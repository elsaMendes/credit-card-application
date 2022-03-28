package com.example.creditcardapplication.service;

import com.example.creditcardapplication.exception.InvalidCreditCardNumberException;
import com.example.creditcardapplication.model.CreditCard;
import com.example.creditcardapplication.repository.CreditCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CreditCardServiceImpl.class})
class CreditCardServiceImplTest {

    @Autowired
    private CreditCardService creditCardService;

    @MockBean
    private CreditCardRepository creditCardRepository;


    @DisplayName("Testing ServiceCreditCard with valid credit card")
    @Nested
    class ValidCreditCard {

        private CreditCard validCreditCard;

        @BeforeEach
        public void setUp() {
            LocalDate expire = LocalDate.of(2023, 2, 23);
            LocalDate issue = LocalDate.of(2019, 2, 23);
            validCreditCard = new CreditCard("Elsa Mendes", "4847352989263094", expire,
                    issue, 333, 2000, 700);
        }

        @DisplayName("When addNew, it should return created creditCard object")
        @Test
        void addNewTestWithValidCreditCard() {
            CreditCard mockResult = validCreditCard;
            mockResult.setId(11);

            when(creditCardRepository.save(validCreditCard)).thenReturn(mockResult);

            CreditCard newCreditCard = creditCardService.addNew(validCreditCard);

            assertEquals(11, newCreditCard.getId());
            assertEquals("4847352989263094", newCreditCard.getNumber());
        }

        @DisplayName("Should return existing creditCard list")
        @Test
        void getAll() {

            List<CreditCard> list = new ArrayList<>();
            list.add(validCreditCard);
            when(creditCardRepository.findAll()).thenReturn(list);

            assertEquals(1, creditCardService.getAll().size());
            assertEquals(0, validCreditCard.getId());
        }
    }

    @DisplayName("Testing ServiceCreditCard with an invalid credit card")
    @Nested
    class InvalidCreditCard {

        private CreditCard invalidCreditCard;

        @BeforeEach
        public void setUp() {
            LocalDate expire = LocalDate.of(2023, 2, 23);
            LocalDate issue = LocalDate.of(2019, 2, 23);
            invalidCreditCard = new CreditCard("Elsa Mendes", "11111111", expire,
                    issue, 333, 2000, 700);
        }

        @DisplayName("When adding CreditCard, it should throw an Exception")
        @Test
        void addNewInvalidCreditCardShouldThrowException() {
            Exception exception = assertThrows(InvalidCreditCardNumberException.class, () -> creditCardService.addNew(invalidCreditCard));

            String expectedMessage = "Invalid Credit Card Number Exception: " + invalidCreditCard.getNumber();
            assertEquals(expectedMessage, exception.getMessage());

        }
    }
}