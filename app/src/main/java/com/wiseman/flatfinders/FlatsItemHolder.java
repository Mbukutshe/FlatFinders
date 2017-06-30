package com.wiseman.flatfinders;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Wiseman on 2017-06-29.
 */

public class FlatsItemHolder extends RecyclerView.ViewHolder {
    RecyclerView viewPager;
    ImageView call,map,email;
    public FlatsItemHolder (View itemView) {
        super(itemView);
        viewPager = (RecyclerView) itemView.findViewById(R.id.sale_viewpager);
        call = (ImageView)itemView.findViewById(R.id.call);
        map = (ImageView)itemView.findViewById(R.id.map);
        email = (ImageView)itemView.findViewById(R.id.email);
    }
}
