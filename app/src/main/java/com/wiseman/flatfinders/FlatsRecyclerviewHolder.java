package com.wiseman.flatfinders;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Wiseman on 2017-06-25.
 */

public class FlatsRecyclerviewHolder extends RecyclerView.ViewHolder{
    RecyclerView viewPager;
    TextView group;
    AppCompatButton oneBed,twoBed,bachelor,all;
    public FlatsRecyclerviewHolder (View itemView) {
        super(itemView);
        viewPager = (RecyclerView) itemView.findViewById(R.id.sale_viewpager);
        group = (TextView)itemView.findViewById(R.id.group);
        oneBed =(AppCompatButton)itemView.findViewById(R.id.one_bed);
        twoBed = (AppCompatButton)itemView.findViewById(R.id.two_bed);
        bachelor = (AppCompatButton)itemView.findViewById(R.id.bachelor);
        all = (AppCompatButton)itemView.findViewById(R.id.all);
    }
}
