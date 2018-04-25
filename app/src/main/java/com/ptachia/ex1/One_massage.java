package com.ptachia.ex1;

public class One_massage {
    private int id;
    private String massage;
    private long timeStamp;

    public String getMassage() {
        return massage;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public One_massage(String massage) {
        this.massage = massage;
        this.timeStamp = System.currentTimeMillis();
    }
}
