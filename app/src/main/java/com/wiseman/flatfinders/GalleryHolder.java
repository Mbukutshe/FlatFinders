package com.wiseman.flatfinders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Wiseman on 2017-06-29.
 */

public class GalleryHolder extends RecyclerView.ViewHolder {
    ImageView pictures;
    public GalleryHolder(View itemView)
    {
      super(itemView);
       pictures = (ImageView)itemView.findViewById(R.id.pictures);
    }
}
