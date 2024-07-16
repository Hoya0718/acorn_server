
package com.acorn.erp.domain.Customer.Util;

import java.util.Date;
import java.util.Calendar;

public class AgeGroupUtil {

    public static String calculateAgeGroup(Date birthDate) {
     if (birthDate == null) {
             throw new IllegalArgumentException("Birth date must not be null");
         }

         Calendar birthCal = Calendar.getInstance();
         birthCal.setTime(birthDate);

         Calendar todayCal = Calendar.getInstance();
         
         int age = todayCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);

         if (todayCal.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) {
             age--;
         }
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