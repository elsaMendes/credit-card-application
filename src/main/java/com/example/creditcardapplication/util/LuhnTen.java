package com.example.creditcardapplication.util;



public class LuhnTen {

    public static boolean validate(String number){
        if (isLengthGreaterThan19(number)) {
            return false;
        }

        if (!isNumeric(number)) {
            return false;
        }

        int sumEvenPlaces = 0, sumOddPlaces = 0;
        String reverse = new StringBuffer(number).reverse().toString();
        for(int i = 0 ; i < reverse.length(); i++){
            int digit = Character.digit(reverse.charAt(i), 10);
            if(i % 2 != 0) { //when reverted the odds position become even
                char[] digitsEvenPlace = String.valueOf(2 * digit).toCharArray();
                if (digitsEvenPlace.length > 1) {
                    sumEvenPlaces += Character.getNumericValue(digitsEvenPlace[0]) + Character.getNumericValue(digitsEvenPlace[1]);
                } else {
                    sumEvenPlaces += Character.getNumericValue(digitsEvenPlace[0]);
                }
            } else {
                sumOddPlaces += digit;
            }
        }
        return (sumEvenPlaces + sumOddPlaces) % 10 == 0;
    }

    private static boolean isNumeric(String number) {
        return number.matches("\\d+");
    }

    private static boolean isLengthGreaterThan19(String number) {
        return number.length() > 19;
    }
}
