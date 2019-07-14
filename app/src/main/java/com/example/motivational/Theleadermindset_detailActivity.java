package com.example.motivational;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.motivational.Sqllite_db.Save_fav_motivation_DB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Theleadermindset_detailActivity extends AppCompatActivity {
    private RelativeLayout theleadermindset_layout_id;
    Save_fav_motivation_DB database_link;
    private ImageView detailed_image_id;
    private com.github.clans.fab.FloatingActionButton setFavourate;
    private com.github.clans.fab.FloatingActionButton shareImage;
    private Bundle extras;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theleadermindset_detail);
        theleadermindset_layout_id=findViewById(R.id.theleadermindset_layout_id);
        database_link=new Save_fav_motivation_DB(this);

        detailed_image_id = findViewById(R.id.theleadermindset_detailed_image_id);
        extras =getIntent().getExtras();
        detailed_image_id.setImageResource(extras.getInt("ïmage_id"));
        mp=MediaPlayer.create(Theleadermindset_detailActivity.this,R.raw.added_to_favourate);

        setFavourate = findViewById(R.id.leadermindset_floating_action_favourate_id);
        setFavourate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInserted= database_link.insertData(String.valueOf(extras.getInt("ïmage_id")));
                if(isInserted=true){

                    mp.start();
                    Snackbar.make(view, "Set to favourate" , Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }


            }
        });

        shareImage = findViewById(R.id.leadermindset_floating_action_share_id);
        shareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("image/png");
                Uri uri = Uri.parse("android.resource://com.example.motivational/"+extras.getInt("ïmage_id"));
                shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, Check out this cool image");
                startActivity(Intent.createChooser(shareIntent, "Share via"));



            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences darkmode = getSharedPreferences("darkmode", 0);
        if (darkmode.contains("mode")) {
            theleadermindset_layout_id.setBackgroundColor(getResources().getColor(R.color.colorBlack));

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorBlack));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.colorBlack)));

        } else {
            theleadermindset_layout_id.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.colorPrimary)));
        }
    }
}