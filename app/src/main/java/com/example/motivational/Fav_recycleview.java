package com.example.motivational;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motivational.Model.Fav_list_row_model;
import com.example.motivational.Sqllite_db.Save_fav_motivation_DB;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Fav_recycleview extends RecyclerView.Adapter<Fav_recycleview.ViewHolder> {
    Save_fav_motivation_DB db;
    int lastPosition = -1;
    Context context;
    List<Fav_list_row_model> fav_list_row;

    public Fav_recycleview(Context context, List fav_list_row) {
        db = new Save_fav_motivation_DB(context);
        this.context = context;
        this.fav_list_row = fav_list_row;
    }

    @NonNull
    @Override
    public Fav_recycleview.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Fav_recycleview.ViewHolder holder, int position) {
        Animation animation = AnimationUtils.loadAnimation(context,
                (position > lastPosition) ? R.anim.recycleview_up_from_bottom
                        : R.anim.recycleview_down_from_top);
        holder.itemView.startAnimation(animation);
        lastPosition = position;

        Fav_list_row_model item = fav_list_row.get(position);
        holder.row_image.setImageResource(item.getImage_id());
    }

    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }


    @Override
    public int getItemCount() {
        return fav_list_row.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView row_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            row_image = itemView.findViewById(R.id.fav_rowlist_image_id);
        }

        @Override
        public void onClick(View view) {
            int id = getAdapterPosition();

            Fav_list_row_model items_delete = fav_list_row.get(id);

            int no = db.deleteData(String.valueOf(items_delete.getImage_id()));
            if (no >= 1) {
                Snackbar.make(view, "Data deleted successful ", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                fav_list_row.remove(id);
                notifyItemRemoved(id);
            } else {
                Snackbar.make(view, "Data not deleted", Snackbar.LENGTH_SHORT).setAction("Action", null).show();

            }
        }
    }
}
