package com.thenqlv.bitirmeprojesiclient.Validations;

import com.thenqlv.bitirmeprojesiclient.Filters.EarthquakeFilter;

public class EarthquakeFilterValidation{
    public static String startDateRegex = RegexConstants.DATEV0_REGEX;
    public static String endDateRegex = RegexConstants.DATEV0_REGEX;
    public static String minMagnitudeRegex = RegexConstants.NOT_NEGATIVE_DOUBLE_REGEX + "|" + RegexConstants.EMPTY;
    public static String maxMagnitudeRegex = RegexConstants.NOT_NEGATIVE_DOUBLE_REGEX + "|" + RegexConstants.EMPTY;
    public static String minDepthRegex = RegexConstants.NOT_NEGATIVE_INTEGER_REGEX + "|" + RegexConstants.EMPTY;
    public static String maxDepthRegex = RegexConstants.NOT_NEGATIVE_INTEGER_REGEX + "|" + RegexConstants.EMPTY;
    public static String minLatRegex = RegexConstants.DOUBLE_REGEX+ "|" + RegexConstants.EMPTY;
    public static String maxLatRegex = RegexConstants.DOUBLE_REGEX + "|" + RegexConstants.EMPTY;
    public static String minLonRegex = RegexConstants.DOUBLE_REGEX + "|" + RegexConstants.EMPTY;
    public static String maxLonRegex = RegexConstants.DOUBLE_REGEX + "|" + RegexConstants.EMPTY;
    public static String latRegex = RegexConstants.DOUBLE_REGEX + "|" + RegexConstants.EMPTY;
    public static String lonRegex = RegexConstants.DOUBLE_REGEX + "|" + RegexConstants.EMPTY;
    public static String minRadRegex = RegexConstants.NOT_NEGATIVE_DOUBLE_REGEX + "|" + RegexConstants.EMPTY;
    public static String maxRadRegex = RegexConstants.NOT_NEGATIVE_DOUBLE_REGEX + "|" + RegexConstants.EMPTY;
    public static String limitRegex = RegexConstants.NOT_NEGATIVE_INTEGER_REGEX + "|" + RegexConstants.EMPTY;

}
