package com.example.demo.Model.Encher;

import com.example.demo.Function.Conn_Encher;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Rechargement {
    String idRechargement,id_client;
    double montant;
    Date date;
    int etat;

    public  boolean insert(){
        Conn_Encher c=null;
        ResultSet rs=null;
        Statement st=null;
        Client valiny=null;
        try {
            c=new Conn_Encher();

            String sql="INSERT INTO rechargement  (idutilisateur, montant,dateRechargement,etat)  VALUES ('"+this.id_client+"','"+this.montant+"','now()','"+1+"')";
            st=c.get_espace();
            st.execute(sql);
            System.out.println(sql);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (st!=null){ st.close();}
                if (rs!=null){ rs.close();}
                if (c!=null){ c.close();}
            }
            catch (Exception e){e.printStackTrace();}
        }
        return false;
    }

    public Rechargement(String idRechargement, String id_client, double montant, Date date, int etat) {
        this.idRechargement = idRechargement;
        this.id_client = id_client;
        this.montant = montant;
        this.date = date;
        this.etat = etat;
    }

    public Rechargement() {
    }

    public String getIdRechargement() {
        return idRechargement;
    }

    public void setIdRechargement(String idRechargement) {
        this.idRechargement = idRechargement;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
