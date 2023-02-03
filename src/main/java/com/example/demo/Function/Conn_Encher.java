package com.example.demo.Function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conn_Encher{
    public Connection conn=null;
    private Statement espace;

    public Conn_Encher(){


        try{
            Class.forName("org.postgresql.Driver");
         //   this.conn = DriverManager.getConnection("jdbc:postgresql://hattie.db.elephantsql.com:5432/rfharpmk","rfharpmk","y3_VINdERSmmXdBb9De5fbUVAUgGz4U0");
            //étape 3: créer l'objet statement
            String url="jdbc:postgresql://containers-us-west-58.railway.app:6125/railway";
            String user="postgres";
            String passWord="YYiG1xSGZt3ZWKpJcCAw";
            //postgresql://postgres:YYiG1xSGZt3ZWKpJcCAw@containers-us-west-58.railway.app:6125/railway
            this.conn=DriverManager.getConnection(url,user,passWord); //DriverManager.getConnection("jdbc:postgresql://hattie.db.elephantsql.com:5432/rfharpmk","rfharpmk","y3_VINdERSmmXdBb9De5fbUVAUgGz4U0");
            //DriverManager.getConnection("jdbc:postgresql://postgres:YYiG1xSGZt3ZWKpJcCAw@containers-us-west-58.railway.app:6125/railway","containers-us-west-58.railway.app","YYiG1xSGZt3ZWKpJcCAw");
            //DriverManager.getConnection("jdbc:postgresql://snuffleupagus.db.elephantsql.com:5432/tioxwyhf","tioxwyhf","ylLj--uUH8gutjATR4z4rXqX7sq33uJq");//DriverManager.getConnection("jdbc:postgresql://snuffleupagus.db.elephantsql.com:5432/bbonphcj","bbonphcj","eskhpU-XtNQCBmonz6UhSMrJyyBeXWx5");//DriverManager.getConnection(url,user,passWord);
            this.conn.setAutoCommit(true);
            this.espace=this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

}
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Statement get_espace()
    {
        return this.espace;
    }
    public void close()
    {
        try {
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}