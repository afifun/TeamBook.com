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
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checkout.findAll", query = "SELECT c FROM Checkout c"),
    @NamedQuery(name = "Checkout.findById", query = "SELECT c FROM Checkout c WHERE c.id = :id"),
    @NamedQuery(name = "Checkout.findByIdAkun", query = "SELECT c FROM Checkout c WHERE c.idAkun = :idAkun"),
    @NamedQuery(name = "Checkout.findByIdBuku", query = "SELECT c FROM Checkout c WHERE c.idBuku = :idBuku"),
    @NamedQuery(name = "Checkout.findByStatus", query = "SELECT c FROM Checkout c WHERE c.status = :status")})
public class Checkout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_akun")
    private int idAkun;
    @Basic(optional = false)
    @Column(name = "id_buku")
    private int idBuku;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;

    public Checkout() {
    }

    public Checkout(Integer id) {
        this.id = id;
    }

    public Checkout(Integer id, int idAkun, int idBuku, int status) {
        this.id = id;
        this.idAkun = idAkun;
        this.idBuku = idBuku;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(int idAkun) {
        this.idAkun = idAkun;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        if (!(object instanceof Checkout)) {
            return false;
        }
        Checkout other = (Checkout) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Checkout[ id=" + id + " ]";
    }
    
}
