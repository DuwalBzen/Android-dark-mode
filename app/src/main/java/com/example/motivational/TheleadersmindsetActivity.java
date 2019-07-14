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

import com.example.motivational.Model.Theleadersmindset_model;

import java.util.ArrayList;
import java.util.List;

public class TheleadersmindsetActivity extends AppCompatActivity {
    private LinearLayout theleader_mindest_layout_id;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myadapter;
    private List<Theleadersmindset_model> theleadersmindset_list_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theleadersmindset);
        recyclerView = findViewById(R.id.leadermindset_recycleview_id);
        theleader_mindest_layout_id = findViewById(R.id.theleader_mindest_layout_id);
        theleadersmindset_list_images = new ArrayList<>();

        int image[] = {
                R.drawable.theleadersmindset_1,
                R.drawable.theleadersmindset_2,
                R.drawable.theleadersmindset_3,
                R.drawable.theleadersmindset_4,
                R.drawable.theleadersmindset_5,
                R.drawable.theleadersmindset_6,
                R.drawable.theleadersmindset_7,
                R.drawable.theleadersmindset_8,
                R.drawable.theleadersmindset_9,
                R.drawable.theleadersmindset_10,
                R.drawable.theleadersmindset_11,
                R.drawable.theleadersmindset_12,
                R.drawable.theleadersmindset_13,
                R.drawable.theleadersmindset_14,
                R.drawable.theleadersmindset_15,
                R.drawable.theleadersmindset_16,
                R.drawable.theleadersmindset_17,
                R.drawable.theleadersmindset_18,
                R.drawable.theleadersmindset_19,
                R.drawable.theleadersmindset_20,
                R.drawable.theleadersmindset_21,
                R.drawable.theleadersmindset_22,
                R.drawable.theleadersmindset_23,
                R.drawable.theleadersmindset_24,
                R.drawable.theleadersmindset_25,
                R.drawable.theleadersmindset_26,
                R.drawable.theleadersmindset_27,
                R.drawable.theleadersmindset_28,
                R.drawable.theleadersmindset_29,
                R.drawable.theleadersmindset_30,
                R.drawable.theleadersmindset_31,
                R.drawable.theleadersmindset_32,
                R.drawable.theleadersmindset_33,
                R.drawable.theleadersmindset_34,
                R.drawable.theleadersmindset_35,
                R.drawable.theleadersmindset_36,
                R.drawable.theleadersmindset_37,
                R.drawable.theleadersmindset_38,
                R.drawable.theleadersmindset_39,
                R.drawable.theleadersmindset_40,
                R.drawable.theleadersmindset_41,
                R.drawable.theleadersmindset_42,
                R.drawable.theleadersmindset_43,
                R.drawable.theleadersmindset_44,
                R.drawable.theleadersmindset_45,
                R.drawable.theleadersmindset_46,
                R.drawable.theleadersmindset_47,
                R.drawable.theleadersmindset_48,
                R.drawable.theleadersmindset_49,
                R.drawable.theleadersmindset_50,
                R.drawable.theleadersmindset_51,
                R.drawable.theleadersmindset_52,
                R.drawable.theleadersmindset_53,
                R.drawable.theleadersmindset_54,
                R.drawable.theleadersmindset_55,
                R.drawable.theleadersmindset_56,
                R.drawable.theleadersmindset_57,
                R.drawable.theleadersmindset_58,
                R.drawable.theleadersmindset_59,
                R.drawable.theleadersmindset_60,
                R.drawable.theleadersmindset_61,
                R.drawable.theleadersmindset_62,
                R.drawable.theleadersmindset_63,
                R.drawable.theleadersmindset_64,
                R.drawable.theleadersmindset_65,
                R.drawable.theleadersmindset_66,
                R.drawable.theleadersmindset_67,
                R.drawable.theleadersmindset_68,
                R.drawable.theleadersmindset_69,
                R.drawable.theleadersmindset_70,
                R.drawable.theleadersmindset_71,
                R.drawable.theleadersmindset_72,
                R.drawable.theleadersmindset_73,
                R.drawable.theleadersmindset_74,
                R.drawable.theleadersmindset_75,
                R.drawable.theleadersmindset_76,
                R.drawable.theleadersmindset_77,
                R.drawable.theleadersmindset_78,
                R.drawable.theleadersmindset_79,
                R.drawable.theleadersmindset_80,
                R.drawable.theleadersmindset_81,
                R.drawable.theleadersmindset_82,
                R.drawable.theleadersmindset_83,
                R.drawable.theleadersmindset_84,
                R.drawable.theleadersmindset_85,
                R.drawable.theleadersmindset_86,
                R.drawable.theleadersmindset_87,
                R.drawable.theleadersmindset_88,
                R.drawable.theleadersmindset_89,
                R.drawable.theleadersmindset_90,
                R.drawable.theleadersmindset_91,
                R.drawable.theleadersmindset_92,
                R.drawable.theleadersmindset_93,
                R.drawable.theleadersmindset_94,
                R.drawable.theleadersmindset_95,
                R.drawable.theleadersmindset_96,
                R.drawable.theleadersmindset_97,
                R.drawable.theleadersmindset_98,
                R.drawable.theleadersmindset_99,
                R.drawable.theleadersmindset_100,

        };

        for (int i = 0; i < image.length; i++) {
            Theleadersmindset_model items = new Theleadersmindset_model(image[i]);
            theleadersmindset_list_images.add(items);
        }


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myadapter = new Theleadersmindset_recycleAdapter(this, theleadersmindset_list_images);
        recyclerView.setAdapter(myadapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences darkmode = getSharedPreferences("darkmode", 0);
        if (darkmode.contains("mode")) {
            theleader_mindest_layout_id.setBackgroundColor(getResources().getColor(R.color.colorBlack));

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorBlack));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.colorBlack)));

        } else {
            theleader_mindest_layout_id.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                    .getColor(R.color.colorPrimary)));
        }
    }

}
