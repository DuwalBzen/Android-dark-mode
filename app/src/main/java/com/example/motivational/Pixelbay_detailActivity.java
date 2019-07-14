package com.example.motivational;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.clans.fab.FloatingActionButton;

public class Pixelbay_detailActivity extends AppCompatActivity {
    private RelativeLayout pixelbay_layout;
private PhotoView pixelbay_image;
private Bundle extras;
private FloatingActionButton share_image;
private final int REQUEST_CODE=300;
    DownloadManager downloadManager;
    private FloatingActionButton download_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixelbay_detail);
pixelbay_layout=findViewById(R.id.pixelbay_layout);
        extras=getIntent().getExtras();
        pixelbay_image=findViewById(R.id.pixelbay_detailed_image_id);


        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        Glide.with(this).load(extras.getString("detail_image")).into(pixelbay_image);


        share_image=findViewById(R.id.pixelbay_floating_action_share_id);
        share_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out this cool image");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, extras.getString("detail_image"));
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });


        download_image=findViewById(R.id.pixelbay_floating_action_favourate_id);
        download_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadWallpaper();
            }
        });


        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE);
        }
        else{


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(REQUEST_CODE==requestCode){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

                Toast.makeText(getApplicationContext(),"Permession granted one",Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void DownloadWallpaper() {
        Uri url = Uri.parse(extras.getString("detail_image"));
        downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(url);
        request.setTitle("Download");
        request.setDescription("Downloading file");
        request.allowScanningByMediaScanner();
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "" + System.currentTimeMillis() + ".jpg");
        downloadManager.enqueue(request);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences darkmode = getSharedPreferences("darkmode", 0);
        if (darkmode.contains("mode")) {
            pixelbay_layout.setBackgroundColor(getResources().getColor(R.color.colorBlack));

           /* Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorBlack));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.colorBlack)));*/

        } else {
            pixelbay_layout.setBackgroundColor(getResources().getColor(R.color.colorWhite));

           /* Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.colorPrimary)));*/
        }
    }

}
