package com.example.myprojects.ModelClass;

import android.content.Context;

import java.io.Serializable;

/**
 * Created by umapa on 11/16/2017.
 */

public class ListAdapters implements Serializable{
    private  int IMAGE;
    private  int NAME;
    private  int EMAIL;
    private  int PHONE;
    private  int AGE;
    private  int ADDRESS;

    public ListAdapters(Context context, int IMAGE, int NAME, int EMAIL, int PHONE, int AGE, int ADDRESS) {
        this.IMAGE=IMAGE;
        this.NAME=NAME;
        this.EMAIL=EMAIL;
        this.PHONE=PHONE;
        this.AGE=AGE;
        this.ADDRESS=ADDRESS;
    }
    public  int getIMAGE() {
        return IMAGE;
    }

    public  int getNAME() {
        return NAME;
    }

    public  int getEMAIL() {
        return EMAIL;
    }

    public  int getPHONE() {
        return PHONE;
    }

    public  int getAGE() {
        return AGE;
    }

    public  int getADDRESS() {
        return ADDRESS;
    }
}
