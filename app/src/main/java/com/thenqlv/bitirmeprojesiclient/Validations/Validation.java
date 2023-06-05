package com.thenqlv.bitirmeprojesiclient.Validations;

import java.util.regex.Pattern;

public class Validation {
    public static boolean validateValue(String regex,String value){
        return Pattern.compile(regex).matcher(value).matches();
    }
}
