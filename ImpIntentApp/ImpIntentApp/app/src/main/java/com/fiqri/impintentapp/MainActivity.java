package com.fiqri.impintentapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //implict intent
    public void Whatsapp(View view) {  //membuat sebuah method untuk berpindah ke halaman whatsapp
        String url="https://wa.me/6282143078424";   //pada baris 29-32 mengunnakan Implicit Intent yaitu untuk membuka url di browser web android dari aplikasi android
        Intent whatsapp = new Intent(Intent.ACTION_VIEW);
        whatsapp.setData(Uri.parse(url));
        startActivity(whatsapp);//memulai activity
    }

    public void Instagram(View view) {  //membuat sebuah method untuk berpindah ke halaman instagram
        String url="https://instagram.com/fiqri.0718?utm_medium=copy_link"; //pada baris 36-39 mengunnakan Implicit Intent yaitu untuk membuka url di browser web android dari aplikasi android
        Intent Instagram = new Intent(Intent.ACTION_VIEW);
        Instagram.setData(Uri.parse(url));
        startActivity(Instagram);//memulai activity
    }

    public void Youtube(View view) {    //membuat sebuah method untuk berpindah ke halaman youtube
        String url="https://youtube.com/channel/UCX6eKmY3UMiPFW760TYG72Q";  //pada baris 43-46 mengunnakan Implicit Intent yaitu untuk membuka url di browser web android dari aplikasi android
        Intent Instagram = new Intent(Intent.ACTION_VIEW);
        Instagram.setData(Uri.parse(url));
        startActivity(Instagram);//memulai activity

    }

    public void Telegram(View view) {   //membuat sebuah method untuk berpindah ke halaman telegram
        String url="https://t.me/maulanafiqrinf"; //pada baris 51-54 mengunnakan Implicit Intent yaitu untuk membuka url di browser web android dari aplikasi android
        Intent Instagram = new Intent(Intent.ACTION_VIEW);
        Instagram.setData(Uri.parse(url));
        startActivity(Instagram);//memulai activity
    }

    public void Twitter(View view) {    //membuat sebuah method untuk berpindah ke halaman twitter
        String url="https://twitter.com/MaulanaFiqri11?t=iei6O6aGCP0VmM3VScWfaQ&s=08";  //pada baris 58-61 mengunnakan Implicit Intent yaitu untuk membuka url di browser web android dari aplikasi android
        Intent Instagram = new Intent(Intent.ACTION_VIEW);
        Instagram.setData(Uri.parse(url));
        startActivity(Instagram);//memulai activity
    }

    public void Linkedln(View view) { //membuat sebuah method untuk berpindah ke halaman linkedln
        String url="https://www.linkedin.com/in/maulana-fiqri-nurul-fawaid";        //pada baris 65-68 mengunnakan Implicit Intent yaitu untuk membuka url di browser web android dari aplikasi android
        Intent Instagram = new Intent(Intent.ACTION_VIEW);
        Instagram.setData(Uri.parse(url));
        startActivity(Instagram);//memulai activity
    }


    // Explicit Intent
    public void About(View view) {      //membuat sebuah method untuk berpindah ke halaman about
        Intent AboutActivity = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(AboutActivity);

    }
}