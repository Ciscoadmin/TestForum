package com.lohika.atf.lb;

public class CommonMethods {

    public static void setTimeout (int timeoutInSec){
        try{
            Thread.sleep(timeoutInSec*1000);
        }
        catch(Exception e){}

    }
}
