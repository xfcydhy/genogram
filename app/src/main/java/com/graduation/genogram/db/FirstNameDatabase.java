package com.graduation.genogram.db;

import android.util.Log;

import org.litepal.crud.LitePalSupport;

public class FirstNameDatabase extends LitePalSupport {
    private String firstName;
    private int id;
    private String postscript;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPostscript() {
        return postscript;
    }

    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }
}
