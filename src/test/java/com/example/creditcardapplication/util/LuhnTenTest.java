package com.example.creditcardapplication.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given a Luhn 10 Credit Card number validator")
class LuhnTenTest {

    @DisplayName("When given a non numeric number, it should return false ")
    @Test
    void validate_a_non_numeric_creditCard_number() {
        assertFalse(LuhnTen.validate("aaaaa"));
    }

    @DisplayName("When its length > 19, it should return false ")
    @Test
    void validate_creditCard_number_greater_than_19_characters() {
        assertFalse(LuhnTen.validate("111111111111111111122222222"));
    }

    @DisplayName("When number is alphanumeric, it should return false ")
    @Test
    void validate_creditCard_number_alphanumerics_characters() {
        assertFalse(LuhnTen.validate("49927398716aaa"));
    }

    @DisplayName("When its length < 19 but not valid, it should return false ")
    @Test
    void validate_creditCard_number_16_characters_invalid() {
        assertFalse(LuhnTen.validate("1234567812345678"));
    }

    @DisplayName("When given valid numbers, it should return true ")
    @Test
    void validate_creditCard_number_16_characters_valid_1() {
        assertAll("Verifying a set of valid numbers",
                () -> assertTrue(LuhnTen.validate("4847352989263094")),
                () -> assertTrue(LuhnTen.validate("1234567812345670")),
                () -> assertTrue(LuhnTen.validate("49927398716"))
        );
    }

}