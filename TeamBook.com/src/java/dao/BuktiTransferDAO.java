/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.tools.FileObject;
import model.BuktiTransfer;

/**
 *
 * @author moh.afifun
 */
public class BuktiTransferDAO {
    private EntityManager manager;
    String propertiesFileName = "config.properties";
    Properties properti = null;
    
    public BuktiTransferDAO() throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeamBook.comPU");
        this.manager = emf.createEntityManager();
        this.properti = new Properties();
	URL url = getClass().getResource(propertiesFileName);
	properti.load(url.openStream());
    }

    public BuktiTransfer getBuktiTransfer(String id) {
        BuktiTransfer co = (BuktiTransfer) manager.createNamedQuery("BuktiTransfer.findById").setParameter("id", Integer.parseInt(id)).getSingleResult();
        if (co == null) {
            throw new EntityNotFoundException("Tidak dapat menemukan checkout dengan id " + id);
        }
        return co;
    }
    
    public BuktiTransfer getBuktiTransferByCheckout(String id) {
        List result_list = manager.createNamedQuery("BuktiTransfer.findByIdCheckout").setParameter("idCheckout", Long.parseLong(id)).getResultList();
        if(result_list != null){
            return (BuktiTransfer)result_list.get(0);
        }
        else {
            return null;
        }
    
    }

    public List<BuktiTransfer> getListBuktiTransfer() {
        List<BuktiTransfer> co_list = new ArrayList();
        List result_list = manager.createNamedQuery("BuktiTransfer.findAll").getResultList();

        for (Object item : result_list) {
            co_list.add((BuktiTransfer) item);
        }
        return co_list;
    }

    public boolean add(BuktiTransfer newCo,InputStream filecontent ) {
        try {
            manager.getTransaction().begin();
            manager.persist(newCo);
            manager.getTransaction().commit();
            OutputStream outputStream = new FileOutputStream(new File(properti.getProperty("imgdir") + "/bukti_transfer/" + newCo.getIdCheckout() + ".jpg"));

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
    
    public boolean update(BuktiTransfer newCo) {
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
            
            BuktiTransfer co = getBuktiTransfer(id);
            manager.getTransaction().begin();
            manager.remove(co);
            manager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }  
}
