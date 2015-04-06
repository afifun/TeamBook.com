/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import static dao.KeranjangDAO.con;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;
import model.Order;

/**
 *
 * @author moh.afifun
 */
public class OrderDAO {
    static Connection currentCon = null;
    static ConnectionManager con = null;
    static ResultSet rs = null;
    String propertiesFileName = "config.properties";
    Properties properti = null;

    public OrderDAO() throws IOException {
        con = new ConnectionManager();
        currentCon = con.getConnection();
    }
    
    public boolean create(Order order){
        
        return false;
    }
    
}
