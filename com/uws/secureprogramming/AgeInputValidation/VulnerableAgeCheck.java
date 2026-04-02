package com.uws.secureprogramming.AgeInputValidation;

public class VulnerableAgeCheck implements iAgeCheck {

    private final SecureAgeCheck secureAgeCheck = new SecureAgeCheck();

    @Override
    public String checkAge(String age) {
        Integer userAge = secureAgeCheck.validateAndParseAge(age);

        if (userAge == null) {
            return iAgeCheck.Invalid;
        }

        if (userAge >= 18) {
            return iAgeCheck.Adult;
        } else {
            return iAgeCheck.Minor;
        }
    }
}