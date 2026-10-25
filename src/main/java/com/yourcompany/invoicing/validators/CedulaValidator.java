package com.yourcompany.invoicing.validators;

import jakarta.validation.*;
import com.yourcompany.invoicing.annotations.*;

public class CedulaValidator implements ConstraintValidator<Cedula, String> {

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) return true;
        if (!value.matches("\\d{10}")) return false;
        int province = Integer.parseInt(value.substring(0, 2));
        if (province < 1 || province > 24) return false;
        if (value.charAt(2) - '0' >= 6) return false;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int d = (value.charAt(i) - '0') * (i % 2 == 0 ? 2 : 1);
            sum += d > 9 ? d - 9 : d;
        }
        int check = (10 - sum % 10) % 10;
        return check == value.charAt(9) - '0';
    }

}
