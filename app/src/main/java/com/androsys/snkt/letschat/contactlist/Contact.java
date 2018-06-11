package com.androsys.snkt.letschat.contactlist;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Contact implements Serializable {
    private Bitmap avtar;
    private String shubhnaam;

    public Contact(Bitmap avtar, String shubhnaam) {

        this.avtar = avtar;
        this.shubhnaam = shubhnaam;
    }

    public Bitmap getAvtar() {
        return avtar;
    }

    public void setAvtar(Bitmap avtar) {
        this.avtar = avtar;
    }

    public String getShubhnaam() {
        return shubhnaam;
    }

    public void setShubhnaam(String shubhnaam) {
        this.shubhnaam = shubhnaam;
    }
}
