/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.BukuDAO;
import java.io.IOException;
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
@Table(name = "buku_keranjang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BukuKeranjang.findAll", query = "SELECT b FROM BukuKeranjang b"),
    @NamedQuery(name = "BukuKeranjang.findById", query = "SELECT b FROM BukuKeranjang b WHERE b.id = :id"),
    @NamedQuery(name = "BukuKeranjang.findByIdBuku", query = "SELECT b FROM BukuKeranjang b WHERE b.idBuku = :idBuku"),
    @NamedQuery(name = "BukuKeranjang.findByIdKeranjang", query = "SELECT b FROM BukuKeranjang b WHERE b.idKeranjang = :idKeranjang"),
    @NamedQuery(name = "BukuKeranjang.findByIdKeranjangAndBuku", query = "SELECT b FROM BukuKeranjang b WHERE b.idKeranjang = :idKeranjang AND b.idBuku = :idBuku"),
    @NamedQuery(name = "BukuKeranjang.findByKuantitas", query = "SELECT b FROM BukuKeranjang b WHERE b.kuantitas = :kuantitas")})
public class BukuKeranjang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_buku")
    private int idBuku;
    @Basic(optional = false)
    @Column(name = "id_keranjang")
    private int idKeranjang;
    @Basic(optional = false)
    @Column(name = "kuantitas")
    private int kuantitas;

    public BukuKeranjang() {
    }

    public BukuKeranjang(Integer id) {
        this.id = id;
    }

    public BukuKeranjang(Integer id, int idBuku, int idKeranjang, int kuantitas) {
        this.id = id;
        this.idBuku = idBuku;
        this.idKeranjang = idKeranjang;
        this.kuantitas = kuantitas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public int getIdKeranjang() {
        return idKeranjang;
    }

    public void setIdKeranjang(int idKeranjang) {
        this.idKeranjang = idKeranjang;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
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
        if (!(object instanceof BukuKeranjang)) {
            return false;
        }
        BukuKeranjang other = (BukuKeranjang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public Buku getBuku() throws IOException{
        BukuDAO dao = new BukuDAO();
        return dao.getBuku(""+ this.idBuku);
    }

    @Override
    public String toString() {
        return "model.BukuKeranjang[ id=" + id + " ]";
    }
}
