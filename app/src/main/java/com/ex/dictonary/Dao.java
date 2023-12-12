package com.ex.dictonary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao extends Connect {

    private Connection db;


    public void create_table(String e) throws SQLException{
        Statement stm=this.getDb().createStatement();
        String query = "CREATE TABLE "+e+"(Id INT IDENTITY(1,1) PRIMARY KEY,Anahtar VARCHAR(50),Kilit VARCHAR(Max),Durum VARCHAR(50))";
        int yarat=stm.executeUpdate(query);

    }

    public String say(String username)throws SQLException{

        Statement stm=this.getDb().createStatement();
        String query = "SELECT COUNT(*) as soni FROM "+username;
        ResultSet rs=stm.executeQuery(query);
        String chaqir1 = "1";
        while (rs.next()) {
            chaqir1=rs.getString("soni");
        }

    return chaqir1;
    }

    public String say12(String username)throws SQLException{

        Statement stm=this.getDb().createStatement();
        String query = "SELECT COUNT(*) as soni FROM "+username+" where durum='true'";
        ResultSet rs=stm.executeQuery(query);
        String chaqir1 = "1";
        while (rs.next()) {
            chaqir1=rs.getString("soni");
        }

        return chaqir1;
    }

    public void lugat_ekle(String key, String value,String username)throws SQLException{
        Statement stm=this.getDb().createStatement();
        String query="insert into "+username+"  (Anahtar, Kilit,Durum) values ('"+key+"','"+value+"','false')";
        int add=stm.executeUpdate(query);

    }
    public String chaqirboshliqeng(String username)throws SQLException{
        Statement stm=this.getDb().createStatement();
        String query="SELECT Top 1 Anahtar FROM "+username+" where durum='false' order by NEWID()";
        ResultSet rs=stm.executeQuery(query);
        String chaqir1 = null;
        while (rs.next()) {
            chaqir1=rs.getString("Anahtar");
        }


        return chaqir1;
    }

    public String chaqirboshliquz(String username)throws SQLException{
        Statement stm=this.getDb().createStatement();
        String query="SELECT Top 1 Kilit FROM "+username+" where durum='false' order by NEWID()";
        ResultSet rs=stm.executeQuery(query);
        String chaqir1 = null;
        while (rs.next()) {
            chaqir1=rs.getString("Kilit");
        }

        return chaqir1;
    }

    public String chaqirtogrivariantuz(String username,String key)throws SQLException{
        Statement stm=this.getDb().createStatement();
        String query="Select Anahtar from "+username+" where Kilit='"+key+"'";
        ResultSet rs=stm.executeQuery(query);
        String chaqir1 = null;
        while (rs.next()) {
            chaqir1=rs.getString("Anahtar");
        }

        return chaqir1;
    }

    public String chaqirtogrivarianteng(String username, String key)throws SQLException{
        String chaqir1 = null;
        Statement stm=this.getDb().createStatement();
        String query="Select Kilit from "+username+" where Anahtar='"+key+"'";
        ResultSet rs=stm.executeQuery(query);

        while (rs.next()) {
            chaqir1=rs.getString("Kilit");
        }

        return chaqir1;
    }

    public String varianteng(String username)throws SQLException{
        Statement stm=this.getDb().createStatement();
        String query="SELECT TOP 1 Kilit FROM "+username+" ORDER BY NEWID()";
        ResultSet rs=stm.executeQuery(query);
        String chaqir1 = null;
        while (rs.next()) {
            chaqir1=rs.getString("Kilit");
        }

        return chaqir1;
    }


    public String chaqir_variant_uz(String username)throws SQLException{
        Statement stm=this.getDb().createStatement();
        String query="SELECT TOP 1 Anahtar FROM "+username+" ORDER BY NEWID()";
        ResultSet rs=stm.executeQuery(query);
        String chaqir1 = null;
        while (rs.next()) {
            chaqir1=rs.getString("Anahtar");
        }

        return chaqir1;
    }
    public String chaqir_variant_eng(String username,int id)throws SQLException{
        Statement stm=this.getDb().createStatement();
        String query="Select Anahtar from "+username+" where Id="+id;
        ResultSet rs=stm.executeQuery(query);
        String chaqir1 = null;
        while (rs.next()) {
            chaqir1=rs.getString("Anahtar");
        }

        return chaqir1;
    }

    public void durumeng(String username,String a)throws  SQLException{
        Statement stm=this.getDb().createStatement();
        String query="Update "+username+" set durum='true' where Anahtar='"+a+"'";
        int update=stm.executeUpdate(query);
    }


    public List<Map<String,String>> getlist(String username) {
        List<Map<String,String>> mylist = null;
        mylist = new ArrayList<Map<String,String>>();
        try {
            Statement stm = this.getDb().createStatement();
            ResultSet rs = stm.executeQuery("select Anahtar, Kilit from "+username+" where durum='true'");
            while (rs.next()) {
                Map<String,String> listi = new HashMap<String,String>();
                listi.put("item1",rs.getString("Anahtar"));
                listi.put("item2",rs.getString("Kilit"));
                mylist.add(listi);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return mylist;
    }






    public Connection getDb() throws SQLException {

        if(this.db==null){
            this.db= this.connection();

        }

        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }
}
