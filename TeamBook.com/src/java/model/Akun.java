/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moh.afifun
 */
@Entity
@Table(name = "akun")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Akun.findAll", query = "SELECT a FROM Akun a"),
    @NamedQuery(name = "Akun.findById", query = "SELECT a FROM Akun a WHERE a.id = :id"),
    @NamedQuery(name = "Akun.findByNama", query = "SELECT a FROM Akun a WHERE a.nama = :nama"),
    @NamedQuery(name = "Akun.findByUsername", query = "SELECT a FROM Akun a WHERE a.username = :username"),
    @NamedQuery(name = "Akun.findByPassword", query = "SELECT a FROM Akun a WHERE a.password = :password"),
    @NamedQuery(name = "Akun.findByEmail", query = "SELECT a FROM Akun a WHERE a.email = :email"),
    @NamedQuery(name = "Akun.findByPhone", query = "SELECT a FROM Akun a WHERE a.phone = :phone"),
    @NamedQuery(name = "Akun.findByProvinsi", query = "SELECT a FROM Akun a WHERE a.provinsi = :provinsi"),
    @NamedQuery(name = "Akun.findByKota", query = "SELECT a FROM Akun a WHERE a.kota = :kota"),
    @NamedQuery(name = "Akun.findByKodePos", query = "SELECT a FROM Akun a WHERE a.kodePos = :kodePos"),
    @NamedQuery(name = "Akun.findByAlamatShipping", query = "SELECT a FROM Akun a WHERE a.alamatShipping = :alamatShipping"),
    @NamedQuery(name = "Akun.findByAlamatDefault", query = "SELECT a FROM Akun a WHERE a.alamatDefault = :alamatDefault"),
    @NamedQuery(name = "Akun.findByIsAdmin", query = "SELECT a FROM Akun a WHERE a.isAdmin = :isAdmin")})
public class Akun implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "provinsi")
    private String provinsi;
    @Basic(optional = false)
    @Column(name = "kota")
    private String kota;
    @Basic(optional = false)
    @Column(name = "kode_pos")
    private String kodePos;
    @Basic(optional = false)
    @Column(name = "alamat_shipping")
    private String alamatShipping;
    @Basic(optional = false)
    @Column(name = "alamat_default")
    private String alamatDefault;
    @Basic(optional = false)
    @Column(name = "isAdmin")
    private boolean isAdmin;

    public Akun() {
    }

    public Akun(Integer id) {
        this.id = id;
    }

    public Akun(Integer id, String nama, String username, String password, String email, String phone, String provinsi, String kota, String kodePos, String alamatShipping, String alamatDefault, boolean isAdmin) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.provinsi = provinsi;
        this.kota = kota;
        this.kodePos = kodePos;
        this.alamatShipping = alamatShipping;
        this.alamatDefault = alamatDefault;
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getAlamatShipping() {
        return alamatShipping;
    }

    public void setAlamatShipping(String alamatShipping) {
        this.alamatShipping = alamatShipping;
    }

    public String getAlamatDefault() {
        return alamatDefault;
    }

    public void setAlamatDefault(String alamatDefault) {
        this.alamatDefault = alamatDefault;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Akun)) {
            return false;
        }
        Akun other = (Akun) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Akun[ id=" + id + " ]";
    }
    
}
