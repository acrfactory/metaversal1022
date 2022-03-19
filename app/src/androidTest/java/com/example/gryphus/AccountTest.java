package com.example.gryphus;

public class AccountTest {
    public static void main(String[] args) {
        AccountModel account = new AccountModel();
        System.out.println(account.login("abcd1234", "abcd1234"));
    }
}
