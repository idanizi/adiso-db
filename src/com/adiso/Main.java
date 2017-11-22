package com.adiso;

import com.adiso.db.DAL;
public class Main {

    public static void main(String[] args) {

                DAL db = DAL.getInstance();
                db.example();
    }


}
