package com.example.motivational;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.motivational.Model.Hits;
import com.example.motivational.Model.pixel_bay_api_model;
import com.example.motivational.Model.pixel_bay_images_fetch_model;
import com.example.motivational.Pixelbay_retrofit_api.Pixelbay_request_api;
import com.example.motivational.Pixelbay_retrofit_api.Pixelbay_retrofitApi;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pixelbay_imagesActivity extends AppCompatActivity {
    private LinearLayout pixelbay_layout_id;
    private RecyclerView pixelbay_recycleView;
    private RecyclerView.Adapter pixelbay_adapter;
    private List<pixel_bay_images_fetch_model> pixel_bay_images_fetch_list;
    Pixelbay_request_api pixelbay_request_api;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixelbay_images);
        pixelbay_layout_id=findViewById(R.id.pixelbay_layout_id);
        pixel_bay_images_fetch_list = new ArrayList<>();

        pixelbay_recycleView = findViewById(R.id.pixelbay_recycleview_id);

        SharedPreferences pre = getSharedPreferences("category", 0);
        category = pre.getString("category_name", "sports");

        pixelbay_request_api = Pixelbay_retrofitApi.link_RetrofitApi().create(Pixelbay_request_api.class);

        Call<pixel_bay_api_model> call = pixelbay_request_api.getSearchImages("13028103-1ed3e7eace4a8414aac9b2afd", category, 200);
        call.enqueue(new Callback<pixel_bay_api_model>() {
            @Override
            public void onResponse(Call<pixel_bay_api_model> call, Response<pixel_bay_api_model> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Error Code, " + response.code(), Toast.LENGTH_SHORT).show();
                    // text.setText("Code :" + response.code());
                    return;
                }
                try {
                    List<Hits> result = response.body().getHits();

                    Log.d("res", result.toString());

                    for (int i = 0; i < result.size(); i++) {
                        pixel_bay_images_fetch_model item1 = new pixel_bay_images_fetch_model(result.get(i).getLargeImageURL());
                        pixel_bay_images_fetch_list.add(item1);
                        Log.d("resarr", String.valueOf(pixel_bay_images_fetch_list.size()));
                        pixelbay_adapter.notifyDataSetChanged();

                    }
                } catch (
                        JsonSyntaxException exception) {
                    exception.getCause();
                }
            }

            @Override
            public void onFailure(Call<pixel_bay_api_model> call, Throwable t) {
                Log.d("bijen_log", t.getMessage());
                Toast.makeText(getApplicationContext(), "Error jnm, " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        pixelbay_recycleView.setHasFixedSize(true);
        pixelbay_recycleView.setLayoutManager(new LinearLayoutManager(this));
        pixelbay_adapter = new Pixelbay_recycleviewAdapter(this, pixel_bay_images_fetch_list);
        pixelbay_recycleView.setAdapter(pixelbay_adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences darkmode = getSharedPreferences("darkmode", 0);
        if (darkmode.contains("mode")) {
            pixelbay_layout_id.setBackgroundColor(getResources().getColor(R.color.colorBlack));

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorBlack));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.colorBlack)));

        } else {
            pixelbay_layout_id.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.colorPrimary)));
        }
    }

}