package com.example.crudfirebase.Model;

import java.io.Serializable;

public class Upload implements Serializable {
    public String imgUrl;
    public String namaProduk;
    public String stok;
    public String deskripsi;
    public String kategori;

    private String qey;

    public Upload() {

    }

    public Upload(String namaProduk, String stok, String deskripsi, String kategori) {
//        this.imgUrl = imgUrl;
        this.namaProduk = namaProduk;
        this.stok = stok;
        this.deskripsi = deskripsi;
        this.kategori = kategori;

    }



    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getKey() {
        return qey;
    }

    public void setQey(String key) {
        this.qey = qey;
    }

    public String toString(){
        return " " + namaProduk + "\n" +
                " "+ stok + "\n" +
                " "+deskripsi ;
    }
}
