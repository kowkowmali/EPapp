package com.example.haftsadbist.models;

import com.google.gson.annotations.SerializedName;

public class Phone {
    @SerializedName("FixedLineNumber")
    String fixedLineNumber;

    public Phone(String fixedLineNumber) {
        this.fixedLineNumber = fixedLineNumber;
    }

    public String getFixedLineNumber() {
        return fixedLineNumber;
    }

    public void setFixedLineNumber(String fixedLineNumber) {
        this.fixedLineNumber = fixedLineNumber;
    }
}
