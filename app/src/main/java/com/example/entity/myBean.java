package com.example.entity;

public class myBean {
    private String text;//用来放文字的
    private int ImageID;//用来放图片的
 
 
    public myBean(String text,int imageID){
        this.ImageID = imageID;
        this.text = text;
    }
 
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
    }
 
    public int getImageID() {
        return ImageID;
    }
 
    public void setImageID(int imageID) {
        ImageID = imageID;
    }
 
 
}