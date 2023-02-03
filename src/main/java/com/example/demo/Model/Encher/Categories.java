package com.example.demo.Model.Encher;

import com.example.demo.Base.FonctionBase;

import java.util.Vector;

public class Categories {
    int idcategories;
    String nomcategorie;

    public Categories(int idcategories, String nomcategorie) {
        this.idcategories = idcategories;
        this.nomcategorie = nomcategorie;
    }
    public static Vector<Categories>listAll() throws Exception {
        Vector<Categories>valiny=new Vector<>();
        String sql="select idcategories,nomcategorie from categories";
        Vector<Object>[]responce= FonctionBase.select(sql);
        for (int i = 0; i <responce[0].size() ; i++) {
            Categories categories=new Categories((int)responce[0].elementAt(i),(String) responce[1].elementAt(i));
            valiny.add(categories);
        }
        return valiny;
    }
    public int getIdcategories() {
        return idcategories;
    }
    public void setIdcategories(int idcategories) {
        this.idcategories = idcategories;
    }
    public String getNomcategorie() {
        return nomcategorie;
    }
    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }
    
}
