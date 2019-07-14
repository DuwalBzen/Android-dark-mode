package com.example.motivational;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.motivational.Model.Fav_list_row_model;

import android.util.Log;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.example.motivational.Sqllite_db.Save_fav_motivation_DB;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
private LinearLayout mainLayout_id;
    Save_fav_motivation_DB instance_Dd;
    private RecyclerView recyclerView;
    public static RecyclerView.Adapter myadapter;
    public static ArrayList<Fav_list_row_model> fav_list_data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout_id=findViewById(R.id.mainLayout_id);
        recyclerView = findViewById(R.id.fav_recycleview_id);

        instance_Dd=new Save_fav_motivation_DB(this);

        Log.d("data",String.valueOf(fav_list_data.size()));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        fav_list_data.clear();
        Cursor res=instance_Dd.getAllData();
        if(res.getCount()==0){

        }
        while(res.moveToNext()){
            Fav_list_row_model item=new Fav_list_row_model(Integer.parseInt(res.getString(1)));
            fav_list_data.add(item);
        }






        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        myadapter = new Fav_recycleview(getApplicationContext(), fav_list_data);
        recyclerView.setAdapter(myadapter);
        myadapter.notifyDataSetChanged();





        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }



    @Override
    protected void onRestart() {
        super.onRestart();
        fav_list_data.clear();
        Cursor res=instance_Dd.getAllData();
        if(res.getCount()==0){

        }
        while(res.moveToNext()){
            Fav_list_row_model item=new Fav_list_row_model(Integer.parseInt(res.getString(1)));
            fav_list_data.add(item);
        }
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.app_settings) {
            Intent sendto_appsetting=new Intent(MainActivity.this,App_settingActivity.class);
            startActivity(sendto_appsetting);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent sendto_thegoodquotes = new Intent(MainActivity.this, Thegoodquotes_Activity.class);
            startActivity(sendto_thegoodquotes);
        } else if (id == R.id.nav_gallery) {
            Intent sendto_theleadersmindset = new Intent(MainActivity.this, TheleadersmindsetActivity.class);
            startActivity(sendto_theleadersmindset);

        }

        else if (id == R.id.pixelbay_imagesActivity) {
            Intent sendto_pixelbay_imagesActivity = new Intent(MainActivity.this, Pixelbay_imagesActivity.class);
            startActivity(sendto_pixelbay_imagesActivity);

        }else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences darkmode = getSharedPreferences("darkmode", 0);
        if(darkmode.contains("mode")){
            mainLayout_id.setBackgroundColor(getResources().getColor(R.color.colorBlack));

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorBlack));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.colorBlack)));

        }else{
            mainLayout_id.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.colorPrimary)));
        }
    }
}
