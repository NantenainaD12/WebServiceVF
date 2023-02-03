package com.example.demo.Model.Encher;

import com.example.demo.Function.Conn_Encher;

import java.sql.ResultSet;
import java.sql.Statement;

public class Client {
    String id_client,nom,prenom,login,mdp;
    double argent=0;


    public double getArgent() {
        return argent;
    }

    public void setArgent(double argent) {
        this.argent = argent;
    }

    public  boolean insert(){
        Conn_Encher c=null;
        ResultSet rs=null;
        Statement st=null;
        Client valiny=null;
        try {
            c=new Conn_Encher();

            String sql="INSERT INTO utilisateur  (nomutilisateur, prenom,login,mdp,argent)  VALUES ('"+this.nom+"','"+this.prenom+"','"+this.login+"','"+this.mdp+"',"+this.argent+")";
            System.out.println(sql);
            st=c.get_espace();
            st.execute(sql);
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
    public static Client login(String login,String mdp){
        Conn_Encher c=null;
        ResultSet rs=null;
        Statement st=null;
        Client valiny=null;
        try {
            valiny=new Client( "-100", "", "", "", "", 0);
            c=new Conn_Encher();
            String sql="select * from utilisateur where login= '"+login+"' and mdp='"+mdp+"'";
            System.out.println(sql);
            st=c.get_espace();
            rs = st.executeQuery(sql);
            while (rs.next()){
                valiny=new Client(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6));
            }
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
        return valiny;
    }
    public Client() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    public Client(String id_client, String nom, String prenom, String login, String mdp, double argent) {
        this.id_client = id_client;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
        this.argent = argent;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public Client(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }
}
