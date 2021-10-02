package com.fiqri.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BahasaActivity extends AppCompatActivity {

    ListView listView;                                  //memanggil fungsi untuk list view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bahasa);
        changeStatusBarColor();                         //memanngil fungsi untuk mengganti warna status bar

        listView = findViewById(R.id.listbahasa);       //mencari data menggunakan id
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.bahasa, android.R.layout.simple_list_item_1); //membuat sebuah array adapter yang bekerja hanya pada string
        listView.setAdapter(adapter);       //menetapkan sebuah adapter pada baris sebelumnya
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {  //membuat sebuah aksi saat menekan array-string yang di dalamnya berada item yang terdapat pada listview
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String lang = ((TextView) view).getText().toString();
                Toast.makeText(getApplicationContext(),"Bahasa yang dipilih : "+lang,Toast.LENGTH_SHORT).show();   //membuat sebuah informasi dalam bentuk teks saat kita telah memilih tersebut
            }
        });

    }

    private void changeStatusBarColor() {                       //membuat sebuah method untuk mengantti warna status bar
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.JELLY_BEAN){             //mengatur versi android
            Window window =getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));           //memberikan warna pada status bar
        }
    }

    public void onBackClick(View view) {                                    //membuat sebuah method untuk berpindah ke halaman login
        startActivity(new Intent(this,LoginActivity.class));    //memberikan sebuah aksi atau perintah untuk berpindah kelas Login
        overridePendingTransition(R.anim.slide_in_left, android.R.anim.slide_out_right);        //menambahkan tarnsisi saat berpindah halaman yaitu transisi ke kiri dan transisi keluar ke kanan.
    }
}