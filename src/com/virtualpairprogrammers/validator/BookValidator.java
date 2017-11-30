package com.virtualpairprogrammers.validator;

import com.virtualpairprogrammers.domain.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class BookValidator
{
    public boolean supports(Class<?> clazz)
    {
        return clazz.equals(Book.class);
    }

    public void validate(Object actualObject, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required");
    }
}
