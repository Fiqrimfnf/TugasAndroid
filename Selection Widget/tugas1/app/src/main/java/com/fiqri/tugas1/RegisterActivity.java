package com.fiqri.tugas1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private static final String[] KOTA = new String[]{              //membuat sebuah array yang hanya bisa diaskes oleh kelas ini
            "Jember","Tuban","Malang","Madiun","Surabaya","Probolinggo","Nganjuk","Sidoarjo","Batu"
    };

    Spinner spinner;                            //memanggil fungsi untuk spinner
    AutoCompleteTextView autocompletetext;      //memanggil fungsi untuk autocompletetextview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        changeStatusBarColor();         //memanngil fungsi untuk mengganti warna status bar

        spinner = findViewById(R.id.spinner);           //mencari data menggunakan id
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.Provinsi, android.R.layout.simple_spinner_dropdown_item); //membuat sebuah array adapter yang bekerja hanya pada string
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //membuat sebuah set semua item yang sudah di inisiasi jatuh ke bawah
        spinner.setAdapter(adapter);            //menetapkan sebuah adapter pada baris sebelumnya
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {        //membuat sebuah aksi saat memilih array-string yang di dalamnya berada item yang terdapat pada listview
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String prov=parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Pilih: "+prov, Toast.LENGTH_SHORT).show();     //membuat sebuah informasi dalam bentuk teks saat kita telah memilih tersebut
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        autocompletetext = findViewById(R.id.actv);     //mencari data menggunakan id
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, KOTA);        //membuat sebuah array adapter yang bekerja hanya pada string yang telah di inisaisi pada private string diatas dengan mengetikkan beberapa huruf maka string yang telah di inisais akan muncul.
        autocompletetext.setAdapter(adapter1);      //menetapkan sebuah adapter pada baris sebelumnya

        autocompletetext.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {           //membuat sebuah aksi saat memilih array-string yang di dalamnya berada item yang terdapat pada listview
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String namaKota = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Silahakan tulis kota : " + namaKota, Toast.LENGTH_SHORT).show();       //membuat sebuah informasi dalam bentuk teks saat kita telah memilih tersebut
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void changeStatusBarColor() {               //membuat sebuah method untuk mengantti warna status bar
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.JELLY_BEAN){            //mengatur versi android
            Window window =getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));            //memberikan warna pada status bar
        }
    }

    public void onLoginClick(View view){                //membuat sebuah method untuk berpindah ke halaman login
        startActivity(new Intent(this,LoginActivity.class));        //memberikan sebuah aksi atau perintah untuk berpindah kelas Login
        overridePendingTransition(R.anim.slide_in_left, android.R.anim.slide_out_right);        //menambahkan tarnsisi saat berpindah halaman yaitu transisi ke kiri dan transisi keluar ke kanan.
    }
}