package com.example.demo.Model.Encher;

import com.example.demo.Base.FonctionBase;

import java.util.Date;
import java.util.Vector;

public class RechargementList {
    double montant;
    Date daterechargement;
    String statue;

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDaterechargement() {
        return daterechargement;
    }

    public void setDaterechargement(Date daterechargement) {
        this.daterechargement = daterechargement;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public RechargementList(double montant, Date daterechargement, String statue) {
        this.montant = montant;
        this.daterechargement = daterechargement;
        this.statue = statue;
    }
    public static Vector<RechargementList>getAll(int idUtilisateur) throws Exception {
        Vector<RechargementList>valiny=new Vector<>();
        String sql="select montant,daterechargement,statue from rechargement join etat e on e.idetat = rechargement.etat where idutilisateur="+idUtilisateur+" order by etat";
        Vector<Object>[]get= FonctionBase.select(sql);
        for (int i = 0; i <get[0].size() ; i++) {
            RechargementList list=new RechargementList((double) get[0].elementAt(i),(Date) get[1].elementAt(i),(String) get[2].elementAt(i));
            valiny.add(list);
        }
        return valiny;
    }
}
