package com.example.motivational;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class App_settingActivity extends AppCompatActivity {
    private Spinner pixelbay_category;
    private ArrayList<String> category;
    private static final String FILE_NAME = "category";
    private SharedPreferences mypref;
    private SharedPreferences darkpref;
    private SwitchCompat darkmode_Switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_setting);

        category = new ArrayList<>();
        category.add("fashion");
        category.add("nature");
        category.add("backgrounds");
        category.add("science");
        category.add("education");
        category.add("people");
        category.add("feelings");
        category.add("religion");
        category.add("health");
        category.add("places");
        category.add("animals");
        category.add("industry");
        category.add("food");
        category.add("computer");
        category.add("sports");
        category.add("transportation");
        category.add("travel");
        category.add("buildings");
        category.add("business");
        category.add("music");


        darkmode_Switch = findViewById(R.id.darkmode_switch_id);




        darkmode_Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    mypref = getSharedPreferences("darkmode", 0);
                    SharedPreferences.Editor editor = mypref.edit();
                    editor.putString("mode", "enable");
                    editor.commit();

                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(getResources().getColor(R.color.colorBlack));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                            .getColor(R.color.colorBlack)));

                } else {

                    mypref = getSharedPreferences("darkmode", 0);
                    SharedPreferences.Editor editor = mypref.edit();
                    editor.remove("mode"); // will delete key name
                    editor.commit(); // commit changes


                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                            .getColor(R.color.colorPrimary)));
                }
            }
        });
        pixelbay_category = findViewById(R.id.pixelbay_categories_id);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, category);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        pixelbay_category.setAdapter(spinnerArrayAdapter);


        pixelbay_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected_category = (String) parent.getItemAtPosition(position);
                // Notify the selected item text

                mypref = getSharedPreferences(FILE_NAME, 0);
                SharedPreferences.Editor editor = mypref.edit();
                editor.putString("category_name", selected_category);
                editor.commit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences getpref = getSharedPreferences("darkmode", 0);
        if (getpref.contains("mode")) {
            darkmode_Switch.setChecked(true);
        }else{
            darkmode_Switch.setChecked(false);
        }
    }
}

