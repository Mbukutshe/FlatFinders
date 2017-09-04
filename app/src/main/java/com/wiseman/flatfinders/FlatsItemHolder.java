package com.wiseman.flatfinders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Wiseman on 2017-06-29.
 */

public class FlatsItemHolder extends RecyclerView.ViewHolder {
    RecyclerView viewPager;
    public FlatsItemHolder (View itemView) {
        super(itemView);
        viewPager = (RecyclerView) itemView.findViewById(R.id.sale_viewpager);
    }
}
