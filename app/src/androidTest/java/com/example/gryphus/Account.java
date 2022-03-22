package com.example.gryphus;

import java.util.ArrayList;
import java.util.Arrays;

public class Account {

        public static ArrayList<String> name = new ArrayList<>(Arrays.asList("James"));
        public static ArrayList<String> username = new ArrayList<>(Arrays.asList("abcd1234"));
        public static ArrayList<String> password = new ArrayList<>(Arrays.asList("abcd1234"));


        public Account() {

        }
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
            //check whether userName is overlapping.
            if ( this.username.contains(userName) || this.password.contains(passWord)) {
                valid = false;
            }//check whether passWord is overlapping.

            if (valid == true) {
                this.name.add(name);
                username.add(userName);
                password.add(passWord);
                returnValue = "Success";
            } else {
                returnValue = "Fail";
            }
            return returnValue;
        }

        public void addAccount (String name, String userName, String passWord) {
            this.username.add(userName);
            this.password.add(passWord);
        }
    }


