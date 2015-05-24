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
@Table(name = "bukti_transfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BuktiTransfer.findAll", query = "SELECT b FROM BuktiTransfer b"),
    @NamedQuery(name = "BuktiTransfer.findById", query = "SELECT b FROM BuktiTransfer b WHERE b.id = :id"),
    @NamedQuery(name = "BuktiTransfer.findByIdCheckout", query = "SELECT b FROM BuktiTransfer b WHERE b.idCheckout = :idCheckout"),
    @NamedQuery(name = "BuktiTransfer.findByGambarPath", query = "SELECT b FROM BuktiTransfer b WHERE b.gambarPath = :gambarPath")})
public class BuktiTransfer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_checkout")
    private long idCheckout;
    @Basic(optional = false)
    @Column(name = "gambar_path")
    private String gambarPath;

    public BuktiTransfer() {
    }

    public BuktiTransfer(Integer id) {
        this.id = id;
    }

    public BuktiTransfer(Integer id, long idCheckout, String gambarPath) {
        this.id = id;
        this.idCheckout = idCheckout;
        this.gambarPath = gambarPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getIdCheckout() {
        return idCheckout;
    }

    public void setIdCheckout(long idCheckout) {
        this.idCheckout = idCheckout;
    }

    public String getGambarPath() {
        return gambarPath;
    }

    public void setGambarPath(String gambarPath) {
        this.gambarPath = gambarPath;
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
        if (!(object instanceof BuktiTransfer)) {
            return false;
        }
        BuktiTransfer other = (BuktiTransfer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BuktiTransfer[ id=" + id + " ]";
    }
    
}
