package com.example.gryphus;

public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.addAccount("Tom", "efgh5678", "effgh5678");
        System.out.println(account1.username);
        System.out.println(account2.username);
    }
}
