/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.net.URL;
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
import model.Buku;

public class BukuDAO {
    

    private EntityManager manager;
    String propertiesFileName = "config.properties";
    Properties properti = null;

    public BukuDAO() throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeamBook.comPU");
        this.manager = emf.createEntityManager();
        this.properti = new Properties();
	URL url = getClass().getResource(propertiesFileName);
	properti.load(url.openStream());
    }

    public Buku getBuku(String id) {
        Buku co = (Buku) manager.createNamedQuery("Buku.findById").setParameter("id", Integer.parseInt(id)).getSingleResult();
        if (co == null) {
            throw new EntityNotFoundException("Tidak dapat menemukan checkout dengan id " + id);
        }
        return co;
    }

    public List<Buku> getListBuku() {
        List<Buku> co_list = new ArrayList();
        List result_list = manager.createNamedQuery("Buku.findAll").getResultList();

        for (Object item : result_list) {
            co_list.add((Buku) item);
        }
        return co_list;
    }
    
    public List<Buku> getListBuku(int indexMulai, int indexAkhir) {
        List<Buku> co_list = new ArrayList();
        List result_list = manager.createNamedQuery("Buku.findAll").getResultList();
        
        if(indexMulai > result_list.size()){
            return null;
        }
        
        if ((indexAkhir) > result_list.size()){
            indexAkhir = result_list.size();
        }
        
        for (int i = indexMulai; i < indexAkhir; i++) {
            co_list.add((Buku) result_list.get(i));
        }
        return co_list;
    }

    public boolean add(Buku newCo, InputStream filecontent) {
        try {
            manager.getTransaction().begin();
            manager.persist(newCo);
            manager.getTransaction().commit();

            OutputStream outputStream = new FileOutputStream(new File(properti.getProperty("imgdir") + "/buku/" + newCo.getIsbn() + ".jpg"));

            int read = 0;
            byte[] bytes = new byte[2048];

            while ((read = filecontent.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            if (filecontent != null) {
                try {
                    // outputStream.flush();
                    filecontent.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(Buku newCo, InputStream filecontent) {
        try {
            
            if (filecontent != null) {
            
            File f = new File(properti.getProperty("imgdir") + "/buku/" + newCo.getIsbn()+ ".jpg");

            Boolean flag = false;
            
            if (f.exists()) {
                flag = f.delete();
            }
                        
            OutputStream outputStream = new FileOutputStream(new File(properti.getProperty("imgdir") + "/buku/" + newCo.getIsbn()+ ".jpg"));

            int read = 0;
            byte[] bytes = new byte[2048];
            
                while ((read = filecontent.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }

                try {
                    // outputStream.flush();
                    filecontent.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            
        } else {
            System.out.println("GAK MASUK WOI");
        }
            
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
            
            Buku co = getBuku(id);
            manager.getTransaction().begin();
            manager.remove(co);
            manager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }  

    public List<Buku> getListBuku(List<Integer> id) throws IOException, SQLException {        
        List<Buku> list = new ArrayList();
        for (Integer id1 : id) {
            list.add(getBuku(""+id1)); 
        }
        return list;
    }
}
