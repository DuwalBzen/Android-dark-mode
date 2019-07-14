package com.example.motivational;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.motivational.Model.list_row_model;

import java.util.ArrayList;
import java.util.List;

public class Thegoodquotes_Activity extends AppCompatActivity {

    private LinearLayout thegoodquotes_layout_activity_id;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myadapter;
    private List<list_row_model> list_row_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thegoodquotes_);
        thegoodquotes_layout_activity_id=findViewById(R.id.thegoodquotes_layout_activity_id);

        list_row_data=new ArrayList<>();
        recyclerView=findViewById(R.id.main_recycleview_id);


        int image[]={
                R.drawable.thegoodquote_1,
                R.drawable.thegoodquote_2,
                R.drawable.thegoodquote_3,
                R.drawable.thegoodquote_4,
                R.drawable.thegoodquote_5,
                R.drawable.thegoodquote_6,
                R.drawable.thegoodquote_7,
                R.drawable.thegoodquote_8,
                R.drawable.thegoodquote_9,
                R.drawable.thegoodquote_10,
                R.drawable.thegoodquote_11,
                R.drawable.thegoodquote_12,
                R.drawable.thegoodquote_13,
                R.drawable.thegoodquote_14,
                R.drawable.thegoodquote_15,
                R.drawable.thegoodquote_16,
                R.drawable.thegoodquote_17,
                R.drawable.thegoodquote_18,
                R.drawable.thegoodquote_19,
                R.drawable.thegoodquote_20,

        };

        for(int i=0;i<image.length;i++){
            list_row_model items=new list_row_model(image[i]);
            list_row_data.add(items);
        }


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myadapter=new Thegoodquotes_recycleviewAdapter(this,list_row_data);
        recyclerView.setAdapter(myadapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences darkmode = getSharedPreferences("darkmode", 0);
        if (darkmode.contains("mode")) {
            thegoodquotes_layout_activity_id.setBackgroundColor(getResources().getColor(R.color.colorBlack));

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorBlack));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.colorBlack)));

        } else {
            thegoodquotes_layout_activity_id.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.colorPrimary)));
        }
    }

}
