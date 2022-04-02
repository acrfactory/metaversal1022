package com.example.gryphus;

import java.util.HashMap;
import java.util.Map;

public class AccountModel {
    HashMap<String, String> accountMap= new HashMap<>();

    public boolean valid = false;//check whether or not username, or password is valid.

    public void addAccount(String username, String password) {
        accountMap.put(username, password);
    }

    public boolean userExistence(String username){
        return accountMap.containsKey(username);
    }

    public boolean valid(String username, String password) {

        // Checks for username existence by using `userExistence` method.
        if(userExistence(username)) {
            // Checks if password matches username input
            return password.equals(accountMap.get(username));
            }
        return false;
    }

    public void loadAccounts(Map<String, ?> preferencesMap){
        for (Map.Entry<String, ?> entries: preferencesMap.entrySet()){
            accountMap.put(entries.getKey(), entries.getValue().toString());
        }
    }




}
