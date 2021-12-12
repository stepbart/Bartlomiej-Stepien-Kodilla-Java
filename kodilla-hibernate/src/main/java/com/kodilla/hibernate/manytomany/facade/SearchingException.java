package com.kodilla.hibernate.manytomany.facade;

public class SearchingException extends Exception{

    public static String ERR_NO_COMP_FOUND = "Company not found by given name";
    public static String ERR_NO_EMPL_FOUND = "Employee not found by given name";

    public SearchingException(String message) {
        super(message);
    }
}
