package com.example.abhay.recyclerdemo;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {
    DatabaseReference mdatabase;
    TextView t1,t2;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ((CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout)).setTitle("Eclairs");
  /*     t1=(TextView)findViewById(R.id.textView);
       t2=(TextView)findViewById(R.id.textView1);*/
        im=(ImageView) findViewById(R.id.imv3);
       // getSupportActionBar().hide();
    /*   getWindow().setAllowEnterTransitionOverlap(false);*/
        /*Slide slide = new Slide(Gravity.RIGHT);
        Slide slide1 = new Slide(Gravity.BOTTOM);
        getWindow().setReturnTransition(slide);
        getWindow().setEnterTransition(slide1);*/

        String mpost_key= getIntent().getExtras().getString("key_post");
        /*Toast.makeText(Main2Activity.this,post_key,Toast.LENGTH_LONG).show();*/
        mdatabase = FirebaseDatabase.getInstance().getReference().child("tools");

        mdatabase.child(mpost_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
           /*    String post_name =(String) dataSnapshot.child("title").getValue();
                String post_dec =(String) dataSnapshot.child("desc").getValue();*/
                String post_image =(String) dataSnapshot.child("imagev").getValue();
              /*  t1.setText(post_name);
                t2.setText(post_dec);*/
                Picasso.with(Main2Activity.this).load(post_image).into(im);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
