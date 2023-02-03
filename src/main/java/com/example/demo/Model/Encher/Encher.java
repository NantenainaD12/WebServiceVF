package com.example.demo.Model.Encher;

import com.example.demo.Function.Conn_Encher;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Encher {
    String id_encher;
    String id_client;
    String idCategorie;
    String nom_produit;
    String about;
    double prix;
    Timestamp daty_debut;
    Timestamp daty_fin;
    String sary;
    double max_encherir;

    public String getSary() {
        return sary;
    }

    public void setSary(String sary) {
        this.sary = sary;
    }

    public double getMax_encherir() {
        return max_encherir;
    }

    public void setMax_encherir(double max_encherir) {
        this.max_encherir = max_encherir;
    }

    public boolean insert_encher() {
        Conn_Encher c = null;
        ResultSet rs = null;
        Statement st = null;
        Client valiny = null;
        try {
            c = new Conn_Encher();
            String sql = "INSERT INTO vente_encher (idutilisateur,idCategorie,nomproduit,about,prixmin,datedebut,datefin,etat)  VALUES ('" + this.id_client + "','" + this.idCategorie + "','" + this.about + "','" + this.nom_produit + "','" + this.prix + "','" + this.daty_debut + "','" + this.daty_fin + "',1)";
            System.out.println(sql);
            st = c.get_espace();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static List<Encher> recherche(String requete) {
        requete = requete.replaceAll("\"", " ");
        List<Encher> valiny = new ArrayList<>();
        Conn_Encher c = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            c = new Conn_Encher();
            String sql = "select * from vente_encher where 1=1" + requete;
            System.out.println(sql);
            st = c.get_espace();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Encher kl = new Encher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getTimestamp(7), rs.getTimestamp(8),rs.getString(10));
                double max=kl.get_max_encherir(kl.getId_encher());
                //System.out.println("SS "+kl.getSary());
                kl.setMax_encherir(max);
                valiny.add(kl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return valiny;
    }

    public static List<Encher> get_current_encher() {
        List<Encher> valiny = new ArrayList<>();
        Conn_Encher c = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            c = new Conn_Encher();
             String sql="select * from vente_encher where vente_encher.datefin>now() ";
           // String sql = "select * from vente_encher";
            System.out.println(sql);
            st = c.get_espace();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Encher kl = new Encher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getTimestamp(7), rs.getTimestamp(8),rs.getString(10));
                double max=kl.get_max_encherir(kl.getId_encher());
                kl.setMax_encherir(max);
                valiny.add(kl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return valiny;
    }

    public static Encher get_by_id(String id_encher) {
        Encher valiny = null;
        Conn_Encher c = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            c = new Conn_Encher();
           // String sql = "select * from vente_encher where  id_encher=" + id_encher;
             String sql="select * from vente_encher where vente_encher.datefin>now() and id_encher="+id_encher;
            System.out.println(sql);
            st = c.get_espace();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                valiny = new Encher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getTimestamp(7), rs.getTimestamp(8),rs.getString(10));
                double max=valiny.get_max_encherir(valiny.getId_encher());
                valiny.setMax_encherir(max);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return valiny;
    }

    public static List<Encher> my_propre_encher(String id_me) {
        List<Encher> valiny = new ArrayList<>();
        Conn_Encher c = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            c = new Conn_Encher();
            String sql = "select * from vente_encher where idutilisateur=" + id_me;
            System.out.println(sql);
            st = c.get_espace();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Encher kl = new Encher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getTimestamp(7), rs.getTimestamp(8),rs.getString(10));
                double max=kl.get_max_encherir(kl.getId_encher());
                kl.setMax_encherir(max);
                valiny.add(kl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return valiny;
    }

    public Encher(String id_encher, String id_client, String idCategorie, String nom_produit, String about, double prix, Timestamp daty_debut, Timestamp daty_fin,String sary) {
        this.id_encher = id_encher;
        this.id_client = id_client;
        this.idCategorie = idCategorie;
        this.nom_produit = nom_produit;
        this.about = about;
        this.prix = prix;
        this.daty_debut = daty_debut;
        this.daty_fin = daty_fin;
        this.sary=sary;
    }

    public Encher() {
    }

    public String getId_encher() {
        return id_encher;
    }

    public void setId_encher(String id_encher) {
        this.id_encher = id_encher;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Timestamp getDaty_fin() {
        return daty_fin;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Timestamp getDaty_debut() {
        return daty_debut;
    }

    public void setDaty_debut(Timestamp daty_debut) {
        this.daty_debut = daty_debut;
    }

    public void setDaty_fin(Timestamp daty_fin) {
        this.daty_fin = daty_fin;
    }

    double get_max_encherir(String is_encher) {
        Conn_Encher c = null;
        ResultSet rs = null;
        Statement st = null;
        double valiny=0;
        try {
            c = new Conn_Encher();
            String sql = "select * from max_fotsiny where  id_encher=" + is_encher;
            // String sql="select * from vente_encher where vente_encher.datefin>now() and id_encher="+id_encher;
            //System.out.println(sql);
            st = c.get_espace();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                valiny = rs.getDouble(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  valiny;
    }
}
