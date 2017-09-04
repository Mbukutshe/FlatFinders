package com.wiseman.flatfinders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Wiseman on 2017-06-25.
 */

public class FlatsViewPager  extends RecyclerView.Adapter<FlatsItemHolder> implements View.OnClickListener{
    private Context context;
    LinearLayoutManager mLayoutManager;
    GalleryAdapter adapter;
    public FlatsViewPager (Context context) {
        this.context = context;

    }
    @Override
    public FlatsItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.for_sale_item,null);
        FlatsItemHolder rcv = new FlatsItemHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(FlatsItemHolder holder, int position) {
        int[] mResources = {
                R.drawable.forsale,
                R.drawable.sale,
                R.drawable.houses,
                R.drawable.inside,
        };
        String[] Prices = {
               "R20 000 - R50 000",
                "R100 000 - R500 000",
                "R1 000 000 - R5 000 000",
                "R200 000 - R800 000",
        };
        ((TextView)holder.itemView.findViewById(R.id.price)).getBackground().setAlpha(150);
        ImageView imageView = (ImageView)holder.itemView.findViewById(R.id.flat);
        imageView.setImageResource(mResources[position]);
        ((TextView)holder.itemView.findViewById(R.id.price)).setText(Prices[position]);
        ((ImageView)holder.itemView.findViewById(R.id.flat)).setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return 4;
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id)
        {
            case R.id.flat:
                context.startActivity(new Intent(context,RoomDetails.class));
                break;
        }
    }
}
