package com.acorn.erp.domain.Customer.Util;

import java.util.Date;
import java.util.Calendar;

public class AgeGroupUtil {

    public static String calculateAgeGroup(Date birthDate) {
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        cal.setTime(birthDate);
        int birthYear = cal.get(Calendar.YEAR);
        int age = currentYear - birthYear;

        if (age < 10) {
            return "10대 이하";
        } else if (age < 20) {
            return "20대";
        } else if (age < 30) {
            return "30대";
        } else if (age < 40) {
            return "40대";
        } else if (age < 50) {
            return "50대";
        } else if (age < 60) {
            return "60대";
        } else {
            return "70대 이상";
        }
    }
}