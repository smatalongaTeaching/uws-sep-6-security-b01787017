package com.uws.secureprogramming.AgeInputValidation;

public class SecureAgeCheck {

    public Integer validateAndParseAge(String age) {
        try {
            int userAge = Integer.parseInt(age);

            if (userAge < 0 || userAge > 120) {
                System.out.println("Invalid age. Please enter an age between 0 and 120.");
                return null;
            }

            return userAge;

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid whole number.");
            return null;
        }
    }
}