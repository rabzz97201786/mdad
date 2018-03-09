package com.example.rabiasultan.cwk1.model;

import java.io.Serializable;

/**
 * Created by rabiasultan on 09/02/2018.
 */

public class Holiday implements Serializable {

    private int id;
    private String title;
    private String notes;
    private String startDate;
    private String endDate;


    private static int holiday_counter = 0;

    public Holiday () {
        id=++ holiday_counter;
    }

    public Holiday(int id, String title, String notes  ) {
        this.id = id;
        this.title = title;
        this.notes = notes;
        //startDate = .getString(R.string.date_from);
        //endDate = .getString(R.string.date_to);
    }
    //EXTEND this for all my real holiday details
    // ...


    private int counter = 0;

    public int getCounter() {
        return counter;
    }


    public int getId() {
        return id;
    }


    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }


}
