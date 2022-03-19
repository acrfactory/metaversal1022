package com.example.gryphus;
import java.util.ArrayList;
import java.util.Arrays;

public class AccountModel {
    public static ArrayList<String> name = new ArrayList<>(Arrays.asList("James"));
    public static ArrayList<String> username = new ArrayList<>(Arrays.asList("abcd1234"));
    public static ArrayList<String> password = new ArrayList<>(Arrays.asList("abcd1234"));

    public boolean login (String userName, String passWord) {
        boolean result = false;

        for (String i:
             username) {
            if (!userName.equals(i)){
            result = false;
            }
        }
        for (String i:
             password) {
            if (!passWord.equals(i)) {
                result = false;
            }
        }
        return result;
    }

    public String setUp (String name, String userName, String passWord) {

        boolean valid = true;//check whether or not userName, or passWord is valid.
        String returnValue;
        for (String i:
                username) {
            if (!userName.equals(i)){
                valid = false;
            }
        }//check whether userName is overlapping.
        for (String i:
                password) {
            if (!passWord.equals(i)) {
                valid = false;
            }
        }//check whether passWord is overlapping.
        if (valid == true) {
            username.add(userName);
            password.add(passWord);
            returnValue = "Success";
        } else {
            returnValue = "Fail";
        }
        return returnValue;
    }


}
