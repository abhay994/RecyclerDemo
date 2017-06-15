package com.example.abhay.recyclerdemo;

/**
 * Created by abhay on 22/10/16.
 */

public class ObjectRecyclerView {
    private String title;
    private String desc;
    private String imagev;

    public ObjectRecyclerView(){

    }
    public ObjectRecyclerView(String title, String desc, String imagev) {
        this.title = title;
        this.desc = desc;
        this.imagev = imagev;
    }


    public String getImagev() {
        return imagev;
    }

    public void setImagev(String imagev) {
        this.imagev = imagev;
    }


    public String getDesc() {return desc;}

    public void setDesc(String desc) {this.desc = desc;}




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
