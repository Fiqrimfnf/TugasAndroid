package com.fiqri.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeStatusBarColor();                                                      //memanngil fungsi untuk mengganti warna status bar
        setContentView(R.layout.activity_login);
    }

    private void changeStatusBarColor() {                                                   //membuat sebuah method untuk mengantti warna status bar
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.JELLY_BEAN){                        //mengatur versi android
            Window window =getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));  //memberikan warna pada status bar

        }
    }

    public void onRegisterClick(View View){                                         //membuat sebuah method untuk berpindah ke halaman register
        startActivity(new Intent(this,RegisterActivity.class));        //memberikan sebuah aksi atau perintah untuk berpindah kelas register
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);               //menambahkan tarnsisi saat berpindah halaman yaitu transisi ke kanan dan tetap di tempat
    }

    public void onBahasaClick(View view) {                                          //membuat sebuah method untuk berpindah ke halaman register
        startActivity(new Intent(this,BahasaActivity.class));          //memberikan sebuah aksi atau perintah untuk berpindah kelas Bahasa
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);               //menambahkan tarnsisi saat berpindah halaman yaitu transisi ke kanan dan tetap di tempat
    }
}