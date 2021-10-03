package com.fiqri.tugas2_1;

public class Reitem {

    String Title,deskripsi,tanggal;   //memanggil fungsi yang memuat tipe data string
    int user;                         //memanggil fungsi yang memuat tipe data integer

    public Reitem() {

}

    public Reitem(String title, String content, String date, int userPhoto) { //membuat sebuah method
        Title = title;
        deskripsi = content;
        tanggal = date;
        this.user = userPhoto;
    }

    public void setTitle(String title) {        //membuat sebuah method untuk menambahkan judul

        Title = title;
    }

    public void setContent(String content) {        //membuat sebuah method untuk menambahkan deskripsi

        deskripsi = content;
    }

    public void setDate(String date) {              //membuat sebuah method untuk menambahkan tanggal

        tanggal = date;
    }

    public void setUserPhoto(int userPhoto) {           //membuat sebuah method untuk menambahkan gambar/foto profil

        this.user = userPhoto;
    }

    public String getTitle() {          //membuat sebuah method untuk mendapatkan judul

        return Title;
    }

    public String getContent() {        //membuat sebuah method untuk mendapatkan sebuah deskripsi

        return deskripsi;
    }

    public String getDate() {           //membuat sebuah method untuk mendapatkan tanggal

        return tanggal;
    }

    public int getUserPhoto() {         //membuat sebuah method untuk mendapatkan sebuah gambar

        return user;
    }
}
