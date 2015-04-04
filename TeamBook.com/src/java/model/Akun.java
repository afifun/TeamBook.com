/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author moh.afifun
 */
public class Akun {

    public Akun load(ResultSet rs) throws SQLException {
        Akun acc = new Akun();

        String value = null;
        
        value = rs.getString(1);
        if (value != null) {
            acc.setId(value);
        } else {
            acc.setId(null);
        }

        value = rs.getString(2);
        if (value != null) {
            acc.setNama(value);
        } else {
            acc.setNama(null);
        }

        value = rs.getString(3);
        if (value != null) {
            acc.setPassword(value);
        } else {
            acc.setPassword(null);
        }

        value = rs.getString(4);
        if (value != null) {
            acc.setEmail(value);
        } else {
            acc.setEmail(null);
        }

        value = rs.getString(5);
        if (value != null) {
            
            if (value.equalsIgnoreCase("1")){
                acc.setIsAdmin(true);
            }
            else{
                acc.setIsAdmin(false);
            }
        }

        return acc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    private String id;
    private String nama;
    private String password;
    private String email;
    private boolean isAdmin;
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
