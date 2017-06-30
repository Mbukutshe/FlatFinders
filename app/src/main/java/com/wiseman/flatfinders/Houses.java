package com.wiseman.flatfinders;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Wiseman on 2017-06-25.
 */

public class Houses extends Fragment {
    View myView;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    FlatRecyclerviewAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_houses,container,false);
        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView) myView.findViewById(R.id.sale_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new FlatRecyclerviewAdapter(this.getContext());
        mRecyclerView.setAdapter(mAdapter);
        return myView;
    }
}
