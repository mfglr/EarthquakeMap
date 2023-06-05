package com.thenqlv.bitirmeprojesiclient.Validations;

public class RegexConstants {
    public static String EMPTY = "";
    public static String DATEV0_REGEX = "[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9]";
    public static String DOUBLE_REGEX = "[0-9]+.[0-9]*|[0-9]*.[0-9]+|[0-9]+|-[0-9]+.[0-9]*|-[0-9]*.[0-9]+|-[0-9]+";
    public static String NOT_NEGATIVE_DOUBLE_REGEX = "[0-9]+.[0-9]*|[0-9]*.[0-9]+|[0-9]+";
    public static String INTEGER_REGEX = "[0-9]+|-[0-9]+";
    public static String NOT_NEGATIVE_INTEGER_REGEX = "[0-9]+";
}
