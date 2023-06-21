package com.example.haftsadbist.models;

 import com.fasterxml.jackson.databind.ObjectMapper;
 import com.fasterxml.jackson.annotation.JsonProperty;
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Data{
    public FinalTerm FinalTerm;
    public MidTerm MidTerm;
    public Inquiry Inquiry;

    public com.example.haftsadbist.models.FinalTerm getFinalTerm() {
        return FinalTerm;
    }

    public void setFinalTerm(com.example.haftsadbist.models.FinalTerm finalTerm) {
        FinalTerm = finalTerm;
    }

    public com.example.haftsadbist.models.MidTerm getMidTerm() {
        return MidTerm;
    }

    public void setMidTerm(com.example.haftsadbist.models.MidTerm midTerm) {
        MidTerm = midTerm;
    }

    public com.example.haftsadbist.models.Inquiry getInquiry() {
        return Inquiry;
    }

    public void setInquiry(com.example.haftsadbist.models.Inquiry inquiry) {
        Inquiry = inquiry;
    }
}


