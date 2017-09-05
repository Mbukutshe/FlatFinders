package com.wiseman.flatfinders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Wiseman on 2017-08-30.
 */

public class RoomDetails extends AppCompatActivity implements View.OnTouchListener{
    ImageView call,map,email;
    FrameLayout frame_call,frame_map,frame_email,beneath;
    TextView number;
    LinearLayoutManager mLayoutManager;
    GalleryAdapter adapter;
    Animation anim;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_details);
        getSupportActionBar().setTitle("Room Information");
        number = (TextView)findViewById(R.id.number);
        number.getBackground().setAlpha(150);
        call = (ImageView)findViewById(R.id.call);
        call.setOnTouchListener(this);
        map = (ImageView)findViewById(R.id.map);
        map.setOnTouchListener(this);
        email = (ImageView)findViewById(R.id.email);
        email.setOnTouchListener(this);

        frame_call = (FrameLayout)findViewById(R.id.frame_call);
        setAlpha(frame_call);
        frame_map = (FrameLayout)findViewById(R.id.frame_map);
        setAlpha(frame_map);
        frame_email = (FrameLayout)findViewById(R.id.frame_email);
        setAlpha(frame_email);
        beneath=(FrameLayout)findViewById(R.id.beneath);

       // beneath.getBackground().setAlpha(250);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.gallery_recyclerview);
        mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new GalleryAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.getBackground().setAlpha(150);
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        switch(id) {
            case R.id.call:
                anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                frame_call.startAnimation(anim);

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel","+27785411943",null));
                try
                {
                    startActivity(intent);
                }
                catch (Exception e)
                {

                }
                break;
            case R.id.map:
                anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                frame_map.startAnimation(anim);

                Uri gmmIntentUri = Uri.parse("geo:0,0?q=30 Blenford Crescent, Sunford,Phoenix");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                break;
            case R.id.email:
                anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                frame_email.startAnimation(anim);

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"wisemanmbukutshe@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Assistance for getting a flat");

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                break;
        }
        return false;
    }
    public void setAlpha(FrameLayout frame)
    {
        frame.getBackground().setAlpha(150);
    }

}

