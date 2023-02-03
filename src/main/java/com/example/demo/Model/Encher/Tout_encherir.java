package com.example.demo.Model.Encher;

import com.example.demo.Function.Conn_Encher;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Tout_encherir {
    String id_encherir ;
    String id_client ;
    String nom ;
    String id_encher ;
    Timestamp daty_encherir ;
    double montant;

    public  boolean encherir() throws Exception{
        System.out.println("III "+this.id_client);
        Encher tepm=Encher.get_by_id(this.id_encher);
        if (tepm != null) {
            System.out.println("temp= "+tepm.getId_client());
            if (tepm.getId_client().compareTo(this.id_client)==0){
                System.out.println("client try to encherir in his own encher");
                throw new Exception("client try to encherir in his own encher");}
        }

        Conn_Encher c=null;
        ResultSet rs=null;
        Statement st=null;
        int test=0;
        try {
            c=new Conn_Encher();
            String sql="INSERT INTO encherir (id_client,id_encher,daty_encherir,montant)VALUES("+this.id_client+","+this.id_encher+",'"+this.daty_encherir+"',"+this.montant+")";
            System.out.println(sql);
            st=c.get_espace();
            st.execute(sql);
            test=1;
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
        if(test==1)return true;
        return false;
    }
    public static List<Tout_encherir> find_by_id_encher(String id_encher)
    {
        List<Tout_encherir> valiny=new ArrayList<>();
        Conn_Encher c=null;
        ResultSet rs=null;
        Statement st=null;
        try {
            c=new Conn_Encher();
            String sql="select * from tout_encherir where id_encher="+id_encher;
            System.out.println(sql);
            st=c.get_espace();
            rs = st.executeQuery(sql);
            while (rs.next()){
                Tout_encherir kl=new Tout_encherir(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5),(double)rs.getDouble(6));
                valiny.add(kl);
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
        return  valiny;
    }

    public static Tout_encherir find_max_by_id_encher(String id_encher)
    {
        Tout_encherir valiny=null;
        Conn_Encher c=null;
        ResultSet rs=null;
        Statement st=null;
        try {
            c=new Conn_Encher();
            String sql="select * from tout_encherir_max where id_encher="+id_encher;
            System.out.println(sql);
            st=c.get_espace();
            rs = st.executeQuery(sql);
            while (rs.next()){
                 valiny=new Tout_encherir(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5),(double)rs.getDouble(6));

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
        return  valiny;
    }

    public Tout_encherir() {
    }

    public Tout_encherir(String id_encherir, String id_client, String nom, String id_encher, Timestamp daty_encherir, double montant) {
        this.id_encherir = id_encherir;
        this.id_client = id_client;
        this.nom = nom;
        this.id_encher = id_encher;
        this.daty_encherir = daty_encherir;
        this.montant = montant;
    }
//
//        public Tout_encherir(String id_client, String id_encher, Timestamp daty_encherir, double montant) {
//        System.out.println("GGG");
//        this.id_client = id_client;
//        this.id_encher = id_encher;
//        this.daty_encherir = daty_encherir;
//        this.montant = montant;
//    }
//    public Tout_encherir(String id_client, String id_encher, String daty_encherir, double montant) {
//        System.out.println("TAYYY");
//        this.id_client = id_client;
//        this.id_encher = id_encher;
//        this.daty_encherir = Timestamp.valueOf(daty_encherir);
//        // daty_encherir;
//        this.montant = montant;
//    }

    public String getId_encherir() {
        return id_encherir;
    }

    public void setId_encherir(String id_encherir) {
        this.id_encherir = id_encherir;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId_encher() {
        return id_encher;
    }

    public void setId_encher(String id_encher) {
        this.id_encher = id_encher;
    }

    public Timestamp getDaty_encherir() {
        return daty_encherir;
    }

    public void setDaty_encherir(Timestamp daty_encherir) {
        this.daty_encherir = daty_encherir;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
