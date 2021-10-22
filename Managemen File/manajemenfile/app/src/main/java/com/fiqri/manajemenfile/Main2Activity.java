package com.fiqri.manajemenfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    //memanggil sebuah fungsi
    TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        showText = (TextView) findViewById(R.id.getText); //findbyviewid =(untuk fragmen yang menyediakan UI dalam layout aktivitas)
    }

    //mendapatkan data dari public
    public void getPublic(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);//folder name
        File myfile = new File(folder, "myData1.txt");//Filename
        String text = getdata(myfile);
        if (text != null) {         //sebuah kondisi
            showText.setText(text);
        } else {
            showText.setText("No Data");
        }

    }
    //mendapatkan sebuah data
    private String getdata(File myfile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(myfile);
            int i = -1;
            StringBuffer buffer = new StringBuffer();
            while ((i = fileInputStream.read()) != -1) {
                buffer.append((char) i);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    //mendapatkan data privat
    public void getPrivate(View view) {
        File folder = getExternalFilesDir("fiqri");//folder name
        File myFile = new File(folder,"myData2.txt");// nama file
        String text = getdata(myFile);
        if(text != null){
            showText.setText(text);
        }else{
            showText.setText("No Data");
        }
    }

    //membuat method untuk kembali
    public void back(View view) {
        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
    }
}