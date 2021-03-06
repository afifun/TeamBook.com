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
@Table(name = "buku_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BukuCheckout.findAll", query = "SELECT b FROM BukuCheckout b"),
    @NamedQuery(name = "BukuCheckout.findById", query = "SELECT b FROM BukuCheckout b WHERE b.id = :id"),
    @NamedQuery(name = "BukuCheckout.findByIdBuku", query = "SELECT b FROM BukuCheckout b WHERE b.idBuku = :idBuku"),
    @NamedQuery(name = "BukuCheckout.findByIdCheckout", query = "SELECT b FROM BukuCheckout b WHERE b.idCheckout = :idCheckout"),
    @NamedQuery(name = "BukuCheckout.findByKuantitas", query = "SELECT b FROM BukuCheckout b WHERE b.kuantitas = :kuantitas")})
public class BukuCheckout implements Serializable {
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
    @Column(name = "id_checkout")
    private long idCheckout;
    @Basic(optional = false)
    @Column(name = "kuantitas")
    private int kuantitas;

    public BukuCheckout() {
    }

    public BukuCheckout(Integer id) {
        this.id = id;
    }

    public BukuCheckout(Integer id, int idBuku, long idCheckout, int kuantitas) {
        this.id = id;
        this.idBuku = idBuku;
        this.idCheckout = idCheckout;
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

    public long getIdCheckout() {
        return idCheckout;
    }

    public void setIdCheckout(long idCheckout) {
        this.idCheckout = idCheckout;
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
        if (!(object instanceof BukuCheckout)) {
            return false;
        }
        BukuCheckout other = (BukuCheckout) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BukuCheckout[ id=" + id + " ]";
    }
    
}
