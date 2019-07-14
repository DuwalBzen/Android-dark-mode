package com.example.motivational;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motivational.Model.Theleadersmindset_model;

import java.util.List;

public class Theleadersmindset_recycleAdapter extends RecyclerView.Adapter<Theleadersmindset_recycleAdapter.ViewHolder> {
    int lastPosition=-1;
    Context context;
    List<Theleadersmindset_model> theleadersmindset_list_images;

    public Theleadersmindset_recycleAdapter(Context context, List theleadersmindset_list_images) {
        this.context = context;
        this.theleadersmindset_list_images = theleadersmindset_list_images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.theleadersmindset_list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Animation animation = AnimationUtils.loadAnimation(context,
                (position > lastPosition) ? R.anim.recycleview_up_from_bottom
                        : R.anim.recycleview_down_from_top);
        holder.itemView.startAnimation(animation);
        lastPosition = position;

        Theleadersmindset_model item=theleadersmindset_list_images.get(position);
        holder.theleadersmindset_image.setImageResource(item.getImage_id());
    }

    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    @Override
    public int getItemCount() {
        return theleadersmindset_list_images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView theleadersmindset_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            theleadersmindset_image=itemView.findViewById(R.id.theleadersmindset_rowlist_image_id);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            Theleadersmindset_model item=theleadersmindset_list_images.get(position);
            Intent sento_details=new Intent(context, Theleadermindset_detailActivity.class);
            sento_details.putExtra("ïmage_id",item.getImage_id());
            context.startActivity(sento_details);
        }
    }
}
