package dao;

/**
 *
 * @author moh.afifun
 */
import connection.ConnectionManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import model.Akun;
import model.Buku;
import model.BukuKeranjang;
import model.Keranjang;
import model.Keranjang;

public class KeranjangDAO {

    private EntityManager manager;

    public KeranjangDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeamBook.comPU");
        this.manager = emf.createEntityManager();
    }

    public Keranjang getKeranjang(String id) {
        Keranjang co = (Keranjang) manager.createNamedQuery("Keranjang.findByIdKeranjang").setParameter("idKeranjang", Integer.parseInt(id)).getSingleResult();
        if (co == null) {
            throw new EntityNotFoundException("Tidak dapat menemukan keranjang dengan id " + id);
        }
        return co;
    }
        
    public Keranjang getKeranjangByAkun(String id) {
        List co = manager.createNamedQuery("Keranjang.findByIdAkun").setParameter("idAkun", Integer.parseInt(id)).getResultList();
        if (co == null) {
            throw new EntityNotFoundException("Tidak dapat menemukan keranjang dengan id_akun " + id);
        }
        Keranjang kr = (Keranjang) co.get(0);
        return kr;
    }

    public List<Keranjang> getListKeranjang() {
        List<Keranjang> co_list = new ArrayList();
        List result_list = manager.createNamedQuery("Keranjang.findAll").getResultList();

        for (Object item : result_list) {
            co_list.add((Keranjang) item);
        }
        return co_list;
    }
    
    public boolean add(Keranjang newCo) {
        try {
            
            manager.getTransaction().begin();
            manager.persist(newCo);
            manager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(Keranjang newCo) {
        try {
            manager.getTransaction().begin();
            manager.merge(newCo);
            manager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean delete(String id) {
        try {
            
            Keranjang co = getKeranjang(id);
            manager.getTransaction().begin();
            manager.remove(co);
            manager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
    
}
