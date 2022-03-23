package com.example.gryphus;
import static com.google.android.material.internal.ContextUtils.getActivity;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class AccountModel {
    public static ArrayList<String> name = new ArrayList<>(Arrays.asList("James"));
    public static ArrayList<String> username = new ArrayList<String>(Arrays.asList("abcd1234"));
    public static ArrayList<String> password = new ArrayList<>(Arrays.asList("abcd1234"));

    public boolean valid = false;//check whether or not userName, or passWord is valid.

    public boolean login (String userName, String passWord) {
        boolean result = false;


        if(username.contains(userName)) {
            result = true;
        }
        if(password.contains(passWord)) {
            result = true;
        }

        return result;
    }

    public void signUp (String name, String userName, String passWord) {


        String returnValue;

        if (!username.contains(userName)) {
            valid = true;
        }

        //check whether userName is overlapping.

        //check whether passWord is overlapping.
        if (valid) {
            this.name.add(name);
            this.username.add(userName);
            this.password.add(passWord);
            returnValue = "Success";
        } else {
            returnValue = "Fail";
        }

    }

    public  String getContentOfEditText(int id, Activity activity){
        View view = getActivity(activity).getApplicationContext().findViewById(id);
        EditText editText = (EditText) view;
        String str = editText.getText().toString();
        return str;
    }

}
