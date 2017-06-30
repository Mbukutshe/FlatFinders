package com.wiseman.flatfinders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Wiseman on 2017-06-29.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryHolder> {
    Context context;
    public GalleryAdapter(Context context)
    {
        this.context = context;
    }
    @Override
    public GalleryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item,null);
        GalleryHolder rcv = new GalleryHolder(layoutView);
        return rcv;
    }
    @Override
    public void onBindViewHolder(GalleryHolder holder, int position) {
        int[] pictures = {R.drawable.houses,R.drawable.inside,R.drawable.forsale,R.drawable.sale};
        holder.pictures.setImageResource(pictures[position]);
    }
    @Override
    public int getItemCount() {
        return 4;
    }
}
