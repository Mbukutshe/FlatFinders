package com.wiseman.flatfinders;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Wiseman on 2017-06-29.
 */

public class Gallery extends AppCompatActivity{
    LinearLayoutManager mLayoutManager;
    GalleryAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.gallery_recyclerview);
        mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new GalleryAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.getBackground().setAlpha(150);
    }

}
