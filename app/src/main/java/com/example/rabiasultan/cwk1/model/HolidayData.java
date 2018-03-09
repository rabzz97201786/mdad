package com.example.rabiasultan.cwk1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton design pattern:
 * private static instance and private constructor
 * public static method called getInstance.  What this does is:
 * if the instance is null, it calls the constructor to create ONE object and assign to instance
 * then return the instance
 * Created by rabiasultan on 09/02/2018.
 */

public class HolidayData {


    //An array of Holidays
    public final List<Holiday> holidays;

    private static HolidayData instance;

    // construct a holiday list
    private HolidayData() {
        holidays =  new ArrayList<Holiday>();
    }

    //the only object that this class will create
    public static HolidayData getInstance() {
        if (instance == null) {
            instance = new HolidayData();
        }
        return instance;
    }

    public void addHoliday(Holiday item) {
        holidays.add(item);
    }

    public  List<Holiday> getHolidays() {
        return holidays;
    }



}
