package com.example.motivational;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.motivational.Model.pixel_bay_images_fetch_model;


import java.util.List;

public class Pixelbay_recycleviewAdapter extends RecyclerView.Adapter<Pixelbay_recycleviewAdapter.ViewHolder> {

    Context context;
    List<pixel_bay_images_fetch_model> pixel_bay_images_list;

    public Pixelbay_recycleviewAdapter(Context context, List pixel_bay_images_list) {
        this.context = context;
        this.pixel_bay_images_list = pixel_bay_images_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pixelbay_list_rows,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        pixel_bay_images_fetch_model item=pixel_bay_images_list.get(position);
        Log.d("c",item.toString());
        Glide.with(context).load(item.getWebformatURL()).into(holder.pixelbay_Image);
    }

    @Override
    public int getItemCount() {
        return pixel_bay_images_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView pixelbay_Image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            pixelbay_Image=itemView.findViewById(R.id.pixelbay_rowlist_image_id);
        }

        @Override
        public void onClick(View view) {
            int id=getAdapterPosition();
            pixel_bay_images_fetch_model item=pixel_bay_images_list.get(id);
            Intent send_topixelbay_details=new Intent(context,Pixelbay_detailActivity.class);
            send_topixelbay_details.putExtra("detail_image",item.getWebformatURL());
            context.startActivity(send_topixelbay_details);
        }
    }
}
