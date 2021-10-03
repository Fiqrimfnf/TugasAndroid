package com.fiqri.tugas2_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //memanggil sebuah fungsi
    RecyclerView NewRecyclerView;
    ReAdapter reAdapter;
    List<Reitem> mData;
    FloatingActionButton fabswitcher;
    boolean isDark=false;
    ConstraintLayout rootlayout;
    EditText searchInput;
    CharSequence search="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {        //method
        super.onCreate(savedInstanceState);

        //membuat aktiviti layar penuh
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //menyembunyikan status bar
        getSupportActionBar().hide();


        //menampilkan sebuah view
        fabswitcher=findViewById(R.id.switcher);
        rootlayout=findViewById(R.id.root);
        searchInput=findViewById(R.id.search);
        NewRecyclerView=findViewById(R.id.recy);
        mData= new ArrayList<>();

        //memuat sebuah tema
        isDark=getThemeStatePref();
        if (isDark){                            //kondisi
            // dark theme menyala

            searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
            rootlayout.setBackgroundColor(getResources().getColor(R.color.black));
        }
        else
        {
            // light theme menyala
            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootlayout.setBackgroundColor(getResources().getColor(R.color.white));
        }

        // mengsisi list dengan data
        mData.add(new Reitem("Maulana Fiqri","HI nama saya maulana fiqri nurul fawaid","03 oktober 2021",R.drawable.gambar1));
        mData.add(new Reitem("Sugeng","Sugeng is the best","03 oktober 2021",R.drawable.gambar3));
        mData.add(new Reitem("fiqri maulama","NIM:E41200105 \nmaulana fiqri nurul fawaid \nTIF A","03 oktober 2021",R.drawable.gambar2));
        mData.add(new Reitem("vivi","NIM:E41200059 \nVivi Handayani \nTIF A","03 oktober 2021",R.drawable.gambar4));
        mData.add(new Reitem("Alvioni","NIM:E41200048 \nAlvioni Tineke Risqianti \nTIF A","04 oktober 2021",R.drawable.gambar5));
        mData.add(new Reitem("Rafliansyah","NIM:E41200266 \nRafliansyah Akbar Ravendivi \nTIF A","05 oktober 2021",R.drawable.gambar6));
        mData.add(new Reitem("paijo","Sugeng is the best","09 oktober 2021",R.drawable.gambar7));
        mData.add(new Reitem("paimin","Sugeng is the best","10 oktober 2021",R.drawable.gambar7));
        mData.add(new Reitem("bambang","Sugeng is the best","11 oktober 2021",R.drawable.gambar6));
        mData.add(new Reitem("sukimin","Sugeng is the best","12 oktober 2021",R.drawable.gambar5));
        mData.add(new Reitem("sukijo","Sugeng is the best","1 oktober 2021",R.drawable.gambar4));

        //membuat sebuah adapter

        reAdapter = new ReAdapter(this,mData,isDark);
        NewRecyclerView.setAdapter(reAdapter);
        NewRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fabswitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isDark=!isDark;
                if (isDark){                                                                // sebuah kondisi

                    rootlayout.setBackgroundColor(getResources().getColor(R.color.black));
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
                }
                else {
                    rootlayout.setBackgroundColor(getResources().getColor(R.color.white));
                    searchInput.setBackgroundResource(R.drawable.search_input_style);
                }

                reAdapter= new ReAdapter(getApplicationContext(),mData,isDark);
                if (!search.toString().isEmpty()){

                    reAdapter.getFilter().filter(search);
                }

                NewRecyclerView.setAdapter(reAdapter);
                saveThemeStatePref(isDark);
            }
        });

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {   //sebuah method

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                reAdapter.getFilter().filter(s);
                search=s;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void saveThemeStatePref(boolean isDark) {                       //mthod
        SharedPreferences pref=getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }

    private boolean getThemeStatePref() {
        SharedPreferences pref= getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        boolean isDark=pref.getBoolean("isDark",false);
        return isDark;
    }
}