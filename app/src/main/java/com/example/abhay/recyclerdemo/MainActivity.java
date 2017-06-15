package com.example.abhay.recyclerdemo;

import android.app.ActivityOptions;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView,recyclerView1,recyclerView2;
    DatabaseReference mdatabase;
    boolean a;
      public String keyman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mymain);
      //  Slide slide = new Slide();
       /* slide.setDuration(10000);
        getWindow().setEnterTransition(slide);*/

        recyclerView = (RecyclerView) findViewById(R.id.recycle_v);
        recyclerView1 = (RecyclerView) findViewById(R.id.recycle_v1);
        recyclerView2 = (RecyclerView) findViewById(R.id.recycle_v2);
     /*   recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);*/
        GridLayoutManager horizontalLayoutManagaer=new GridLayoutManager(this,2);

        LinearLayoutManager horizontalLayoutManagaer1=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager horizontalLayoutManagaer2=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        recyclerView1.setLayoutManager(horizontalLayoutManagaer1);
        recyclerView2.setLayoutManager(horizontalLayoutManagaer2);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("tools");
        mdatabase.keepSynced(true);




   // @Override
   /* protected void onStart() {
        super.onStart();*/

                 FirebaseRecyclerAdapter<ObjectRecyclerView, BlogerViewHolder> firebaseRecyclerAdapter = new
                         FirebaseRecyclerAdapter<ObjectRecyclerView, BlogerViewHolder>(
                                 ObjectRecyclerView.class,
                                 R.layout.my_cardview,
                                 BlogerViewHolder.class,
                                 mdatabase
                         )
                         {
                             @Override
                             protected void populateViewHolder(final BlogerViewHolder viewHolder, final ObjectRecyclerView model, int position) {

                                 final String post_key = getRef(position).getKey();
                                 keyman = post_key;
                                 viewHolder.seTitle(model.getTitle());
                                 viewHolder.setDecs(model.getDesc());
                                 viewHolder.setImg(getApplicationContext(), model.getImagev());




                                 viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                                         intent.putExtra("key_post", post_key);
                                         String transitionNamee = getString(R.string.transition_string);
                                         ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
                                                 recyclerView,   // The view which starts the transition
                                                 transitionNamee    // The transitionName of the view we’re transitioning to
                                         );
                                         ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
                             /*   startActivity(intent);*/
                               /* Toast.makeText(MainActivity.this,post_key,Toast.LENGTH_LONG).show();*/
                                     }
                                 });

                             }

                         };
      /*  FirebaseRecyclerAdapter<String, BlogerViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<String, BlogerViewHolder>(

                String.class,
                R.layout.my_cardview,
                BlogerViewHolder.class,
                mdatabase

        ) {
            @Override
            protected void populateViewHolder(BlogerViewHolder viewHolder, String model, int position) {
                viewHolder.text.setText(model);
               *//* viewHolder.seTitles(model.getTitle());*//*
            }
        };*/
        recyclerView.setAdapter(firebaseRecyclerAdapter);

        recyclerView1.setAdapter(firebaseRecyclerAdapter);
        recyclerView2.setAdapter(firebaseRecyclerAdapter);


    }

    public static class BlogerViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView txt,txt2;
        ImageView img;

        public BlogerViewHolder(View itemView) {
            super(itemView);
             mView=itemView;
         //itemView=mView;
           // text=(TextView) itemView.findViewById(R.id.textView);


        }

        public void seTitle(String title) {
            txt = (TextView) mView.findViewById(R.id.textView);
            txt.setText(title);

        }
        public void setDecs(String desc) {
            txt2 = (TextView) mView.findViewById(R.id.textView1);
            txt2.setText(desc);
        }
        public void setImg(Context cnt,String image) {
            img = (ImageView) mView.findViewById(R.id.image_v);
            Picasso.with(cnt).load(image)


                    .into(img);
        }


    }


}