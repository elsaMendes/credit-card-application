package com.example.creditcardapplication;

import com.example.creditcardapplication.controller.CreditCardController;
import com.example.creditcardapplication.model.CreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@DisplayName("Given Credit Card Application Integration Test")
class CreditCardApplicationTests {

	@Autowired
	CreditCardController creditCardController;

	private CreditCard validCreditCard;

	@BeforeEach
	public void setUp() {
		validCreditCard = new CreditCard("Elsa Mendes", "4847352989263094", LocalDate.of(2023, 2, 23),
				LocalDate.of(2019, 2, 23), 333, 2000, 0);
	}


	@Test
	@DisplayName("Given a valid credit card number, it should create and retrieve credit cards successfully")
	void givenValidCreditCard_testCreateRead() {

		ResponseEntity<CreditCard> responseEntity = creditCardController.addNew(validCreditCard);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("4847352989263094", responseEntity.getBody().getNumber());

		ResponseEntity<List<CreditCard>> responseEntityGetAll = creditCardController.getAll();
		assertAll("Testing getAll creditCards",
				() -> assertEquals(HttpStatus.OK, responseEntityGetAll.getStatusCode()),
				() -> assertEquals(1, responseEntityGetAll.getBody().size())
		);

	}

	@Test
	@DisplayName("Given an invalid credit card number, it should return exception")
	void givenInvalidCreditCard_thenStatus406_notAcceptable() {

		//setting invalid Credit card number
		validCreditCard.setNumber("11111111111");

		ResponseEntity<CreditCard> responseEntity = creditCardController.addNew(validCreditCard);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, responseEntity.getStatusCode());
		String expectedErrorMessage = "Invalid Credit Card Number Exception: " + validCreditCard.getNumber();
		assertEquals(expectedErrorMessage , responseEntity.getBody());

	}

	@Test
	@DisplayName("Given an invalid balance, it should return exception")
	void givenValidCreditCardWithBalanceGreaterThanZero_thenStatus406_notAcceptable() {

		//Adding invalid starting balance
		validCreditCard.setBalance(200);

		ResponseEntity<CreditCard> responseEntity = creditCardController.addNew(validCreditCard);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, responseEntity.getStatusCode());
		String expectedErrorMessage = "Start balance should be 0, invalid value: " + validCreditCard.getBalance();
		assertEquals(expectedErrorMessage , responseEntity.getBody());

	}

}
