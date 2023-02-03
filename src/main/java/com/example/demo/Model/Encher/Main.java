package com.example.demo.Model.Encher;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Encher> current=Encher.get_current_encher();
        for (int i = 0; i < current.size(); i++) {
            System.out.println("I = "+current.get(i).getNom_produit());
        }
        List<Tout_encherir> toutEncherirs=Tout_encherir.find_by_id_encher(""+1);
        for (int i = 0; i < toutEncherirs.size(); i++) {
            //System.out.println("I = "+touthlikEncherirs.get(i).getNom());
        }
        Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant);

        Client cl=Client.login("0348289682","0000");
        System.out.println("ME= "+cl.getNom());
        List<Encher> all=Encher.my_propre_encher(cl.getId_client());
        for (int i = 0; i < all.size(); i++) {
            System.out.println("all = "+all.get(i).getNom_produit());
        }



        //Tout_encherir tt=new Tout_encherir("3","1", timestamp ,250000);
     //   boolean valiny=tt.encherir();
        //System.out.println("valiny= "+valiny);
    }
}
