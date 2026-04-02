package com.uws.secureprogramming.AgeInputValidation;

public class VulnerableAgeCheck implements iAgeCheck {

    @Override
    public String checkAge(String age) {

        
        // Try-catch block to handle potential NumberFormatException when parsing the age string
        try {
            int userAge = Integer.parseInt(age);

            if (userAge >= 18) {
                return iAgeCheck.Adult;
            } else {
                return iAgeCheck.Minor;
            }
        } 
        
        catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid whole number");
            
            return iAgeCheck.Minor; 
        }

    }

}
