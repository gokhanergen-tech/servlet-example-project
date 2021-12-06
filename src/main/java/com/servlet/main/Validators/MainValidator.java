package com.servlet.main.Validators;

public abstract class MainValidator{

    public static Boolean isValidPassAndUsername(String pass,String username){
        return pass!=null&&username!=null;
    }

}
