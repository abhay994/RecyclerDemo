package com.example.abhay.recyclerdemo;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by abhay on 23/10/16.
 */

public class ObjectYaar extends Application {
    private String title;
    private String desc;
    private String imagev;

    public ObjectYaar() {
    }

    public ObjectYaar(String title, String desc, String imagev) {
        this.title = title;
        this.desc = desc;
        this.imagev = imagev;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDesc() {return desc;}

    public void setDesc(String desc) {this.desc = desc;}

    public String getImagev() {return imagev;}

    public void setImagev(String imagev) {this.imagev = imagev;}


}
