package com.virtualpairprogrammers.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ISBNValidator implements ConstraintValidator<ISBN, String>
{
    @Override
    public void initialize(ISBN isbn) {

    }

    @Override
    public boolean isValid(String raw, ConstraintValidatorContext constraintValidatorContext)
    {
        if(raw.length() != 10)
        {
            return false;
        }

        int total = 0;
        for (int i = 0; i<9; i++)
        {
            char c = raw.charAt(i);
            int digit = Character.digit(c, 10);
            total += (10 - i) * digit;
        }
        int checkSum = Character.digit(raw.charAt(9), 10);

        if(checkSum == -1 && raw.charAt(9) == 'X')
        {
            checkSum = 10;
        }

        int modulo = total % 11;
        return modulo == 11 - checkSum;
    }
}
