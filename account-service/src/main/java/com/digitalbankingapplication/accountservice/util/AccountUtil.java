package com.digitalbankingapplication.accountservice.util;


public class AccountUtil {

    public static String getIbanNo() {

        String randomNumberAsString = StringUtil.getRandomNumberAsString(24);

        return "TR" + randomNumberAsString;
    }

}
