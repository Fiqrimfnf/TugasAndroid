package com.fiqri.tugasbottom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    //memanggil sebuah fungsi
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menampilkan sebuah view
        bottomNavigation=findViewById(R.id.bottomNav); //findbyviewid =(untuk fragmen yang menyediakan UI dalam layout aktivitas)

        //getsupportfrgamen untuk mengelola fragmen dalam aktivitas
        getSupportFragmentManager().beginTransaction().replace(R.id.content,new fragment_home()).commit();

        bottomNavigation.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){                                  //pada baris 36-48 menggunakan percabangan switchcase
                    case R.id.home:                                         // membandingkan isi sebuah variabel dengan beberapa nilai. Jika proses perbandingan tersebut menghasilkan true, maka block kode program akan di proses.
                        selectedFragment = new fragment_home();
                        break;
                    case R.id.search:
                        selectedFragment = new fragment_search();
                        break;
                    case R.id.cart:
                        selectedFragment = new fragment_cart();
                        break;
                    case R.id.settings:
                        selectedFragment = new fragment_settings();
                }

                //getsupportfrgamen untuk mengelola fragmen dalam aktivitas
                getSupportFragmentManager().beginTransaction().replace(R.id.content, selectedFragment).commit();

                return;
            }
        });
    }
}