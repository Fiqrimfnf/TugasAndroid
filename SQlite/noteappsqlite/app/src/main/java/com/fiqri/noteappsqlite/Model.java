package com.fiqri.noteappsqlite;

public class Model {

    //memanggil sebuah fungsi
    String title;
    String description;
    String id;

    public Model(String id, String title, String description) { //membuat sebuah method
        this.title = title;
        this.description = description;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { //membuat sebuah method untuk menambahkan judul
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }  //membuat sebuah method untuk menambahkan deskripsi

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }       //membuat sebuah method untuk mendapatkan id
}
