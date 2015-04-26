/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.BukuKeranjangDAO;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "keranjang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Keranjang.findAll", query = "SELECT k FROM Keranjang k"),
    @NamedQuery(name = "Keranjang.findByIdKeranjang", query = "SELECT k FROM Keranjang k WHERE k.idKeranjang = :idKeranjang"),
    @NamedQuery(name = "Keranjang.findByIdAkun", query = "SELECT k FROM Keranjang k WHERE k.idAkun = :idAkun")})
public class Keranjang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_keranjang")
    private Integer idKeranjang;
    @Basic(optional = false)
    @Column(name = "id_akun")
    private int idAkun;

    public Keranjang() {
    }

    public Keranjang(Integer idKeranjang) {
        this.idKeranjang = idKeranjang;
    }

    public Keranjang(Integer idKeranjang, int idAkun) {
        this.idKeranjang = idKeranjang;
        this.idAkun = idAkun;
    }

    public Integer getIdKeranjang() {
        return idKeranjang;
    }

    public void setIdKeranjang(Integer idKeranjang) {
        this.idKeranjang = idKeranjang;
    }

    public int getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(int idAkun) {
        this.idAkun = idAkun;
    }
    
     public int size(){
        BukuKeranjangDAO dao = new BukuKeranjangDAO();
        return dao.size("" + this.idKeranjang);
    }
    
    public List<BukuKeranjang> getItemsKeranjang(){
        BukuKeranjangDAO dao = new BukuKeranjangDAO();
        return dao.getListBukuKeranjangByKeranjang(this.idKeranjang);     
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKeranjang != null ? idKeranjang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Keranjang)) {
            return false;
        }
        Keranjang other = (Keranjang) object;
        if ((this.idKeranjang == null && other.idKeranjang != null) || (this.idKeranjang != null && !this.idKeranjang.equals(other.idKeranjang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Keranjang[ idKeranjang=" + idKeranjang + " ]";
    }
    
}
