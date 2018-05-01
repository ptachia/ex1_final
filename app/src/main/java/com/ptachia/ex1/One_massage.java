package com.ptachia.ex1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

public class One_massage {
    private int id;
    private String massage;
    private String timeStamp;

    public String getMassage() {
        return massage;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public One_massage(String massage) {
        this.massage = massage;
        DateFormat dateFormat = DateFormat.getTimeInstance();//= new SimpleDateFormat("hh.mm aa");
        timeStamp = dateFormat.format(new Date());
    }
}
