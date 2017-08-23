package com.wiseman.flatfinders;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Wiseman on 2017-06-25.
 */

public class FlatRecyclerviewAdapter extends RecyclerView.Adapter<FlatsRecyclerviewHolder> {
    FlatsViewPager adapter;
    private Context context;
    RecyclerView.LayoutManager mLayoutManager;
    public FlatRecyclerviewAdapter(Context context) {
        this.context = context;

    }
    @Override
    public FlatsRecyclerviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.for_sale,null);
        FlatsRecyclerviewHolder rcv = new FlatsRecyclerviewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(FlatsRecyclerviewHolder holder, int position) {

        holder.viewPager.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.viewPager.setLayoutManager(mLayoutManager);
        adapter = new FlatsViewPager(context);
        holder.card.getBackground().setAlpha(190);
        holder.inside_card.getBackground().setAlpha(0);
        holder.viewPager.setAdapter(adapter);
        switch (position)
        {
            case 0:
                holder.group.setText("For Sale");
                holder.oneBed.setVisibility(View.GONE);
                holder.twoBed.setVisibility(View.GONE);
                holder.bachelor.setVisibility(View.GONE);
                holder.all.setVisibility(View.GONE);
                break;
            case 1:
                holder.group.setText("To Rent");
                break;
            case 2:
                holder.group.setText("To Share");
                break;
        }
    }
    @Override
    public int getItemCount() {
        return 3;
    }
}
