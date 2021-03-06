/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moh.afifun
 */
@Entity
@Table(name = "checkout")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checkout.findAll", query = "SELECT c FROM Checkout c"),
    @NamedQuery(name = "Checkout.findById", query = "SELECT c FROM Checkout c WHERE c.id = :id"),
    @NamedQuery(name = "Checkout.findByIdAkun", query = "SELECT c FROM Checkout c WHERE c.idAkun = :idAkun"),
    @NamedQuery(name = "Checkout.findByNamaKurir", query = "SELECT c FROM Checkout c WHERE c.namaKurir = :namaKurir"),
    @NamedQuery(name = "Checkout.findByIdOrderKurir", query = "SELECT c FROM Checkout c WHERE c.idOrderKurir = :idOrderKurir"),
    @NamedQuery(name = "Checkout.findByJenisPaket", query = "SELECT c FROM Checkout c WHERE c.jenisPaket = :jenisPaket"),
    @NamedQuery(name = "Checkout.findByBeratPaket", query = "SELECT c FROM Checkout c WHERE c.beratPaket = :beratPaket"),
    @NamedQuery(name = "Checkout.findByWaktuPenerimaan", query = "SELECT c FROM Checkout c WHERE c.waktuPenerimaan = :waktuPenerimaan"),
    @NamedQuery(name = "Checkout.findByBiayaPengiriman", query = "SELECT c FROM Checkout c WHERE c.biayaPengiriman = :biayaPengiriman"),
    @NamedQuery(name = "Checkout.findByBiayaItem", query = "SELECT c FROM Checkout c WHERE c.biayaItem = :biayaItem"),
    @NamedQuery(name = "Checkout.findByBank", query = "SELECT c FROM Checkout c WHERE c.bank = :bank"),
    @NamedQuery(name = "Checkout.findByStatus", query = "SELECT c FROM Checkout c WHERE c.status = :status"),
    @NamedQuery(name = "Checkout.findByTanggal", query = "SELECT c FROM Checkout c WHERE c.tanggal = :tanggal")})
public class Checkout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "id_akun")
    private int idAkun;
    @Column(name = "nama_kurir")
    private String namaKurir;
    @Column(name = "id_order_kurir")
    private String idOrderKurir;
    @Basic(optional = false)
    @Column(name = "jenis_paket")
    private String jenisPaket;
    @Basic(optional = false)
    @Column(name = "berat_paket")
    private int beratPaket;
    @Basic(optional = false)
    @Column(name = "waktu_penerimaan")
    private String waktuPenerimaan;
    @Basic(optional = false)
    @Column(name = "biaya_pengiriman")
    private double biayaPengiriman;
    @Basic(optional = false)
    @Column(name = "biaya_item")
    private double biayaItem;
    @Basic(optional = false)
    @Column(name = "bank")
    private String bank;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;

    public Checkout() {
    }

    public Checkout(Long id) {
        this.id = id;
    }

    public Checkout(Long id, int idAkun, String jenisPaket, int beratPaket, String waktuPenerimaan, double biayaPengiriman, double biayaItem, String bank, int status, Date tanggal) {
        this.id = id;
        this.idAkun = idAkun;
        this.jenisPaket = jenisPaket;
        this.beratPaket = beratPaket;
        this.waktuPenerimaan = waktuPenerimaan;
        this.biayaPengiriman = biayaPengiriman;
        this.biayaItem = biayaItem;
        this.bank = bank;
        this.status = status;
        this.tanggal = tanggal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(int idAkun) {
        this.idAkun = idAkun;
    }

    public String getNamaKurir() {
        return namaKurir;
    }

    public void setNamaKurir(String namaKurir) {
        this.namaKurir = namaKurir;
    }

    public String getIdOrderKurir() {
        return idOrderKurir;
    }

    public void setIdOrderKurir(String idOrderKurir) {
        this.idOrderKurir = idOrderKurir;
    }

    public String getJenisPaket() {
        return jenisPaket;
    }

    public void setJenisPaket(String jenisPaket) {
        this.jenisPaket = jenisPaket;
    }

    public int getBeratPaket() {
        return beratPaket;
    }

    public void setBeratPaket(int beratPaket) {
        this.beratPaket = beratPaket;
    }

    public String getWaktuPenerimaan() {
        return waktuPenerimaan;
    }

    public void setWaktuPenerimaan(String waktuPenerimaan) {
        this.waktuPenerimaan = waktuPenerimaan;
    }

    public double getBiayaPengiriman() {
        return biayaPengiriman;
    }

    public void setBiayaPengiriman(double biayaPengiriman) {
        this.biayaPengiriman = biayaPengiriman;
    }

    public double getBiayaItem() {
        return biayaItem;
    }

    public void setBiayaItem(double biayaItem) {
        this.biayaItem = biayaItem;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
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
