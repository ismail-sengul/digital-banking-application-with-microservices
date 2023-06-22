package com.digitalbankingapplication.accountservice.util;

import com.digitalbankingapplication.accountservice.enums.ErrorMessage;
import com.digitalbankingapplication.accountservice.generic.exceptions.BusinessException;
import org.apache.commons.lang.RandomStringUtils;

public class StringUtil {

    public static String getRandomNumberAsString(int charCount){

        if (charCount <=0){
            throw new BusinessException(ErrorMessage.CHAR_COUNT_CANNOT_BE_ZERO_OR_NEGATIVE);
        }

        return RandomStringUtils.randomNumeric(charCount);

    }
}
