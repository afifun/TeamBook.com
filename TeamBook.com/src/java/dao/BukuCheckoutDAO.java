/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import model.BukuCheckout;

/**
 *
 * @author moh.afifun
 */
public class BukuCheckoutDAO {

    private EntityManager manager;

    public BukuCheckoutDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeamBook.comPU");
        this.manager = emf.createEntityManager();
    }
    
    public BukuCheckout getBukuCheckoutByIdCheckout(String id) {
        BukuCheckout co = (BukuCheckout) manager.createNamedQuery("BukuCheckout.findByIdCheckout").setParameter("idCheckout", Integer.parseInt(id)).getSingleResult();
        if (co == null) {
            throw new EntityNotFoundException("Tidak dapat menemukan BukuCheckout dengan id " + id);
        }
        return co;
    }

    public BukuCheckout getBukuCheckout(String id) {
        BukuCheckout co = (BukuCheckout) manager.createNamedQuery("BukuCheckout.findById").setParameter("id", Integer.parseInt(id)).getSingleResult();
        if (co == null) {
            throw new EntityNotFoundException("Tidak dapat menemukan BukuCheckout dengan id " + id);
        }
        return co;
    }

    public List<BukuCheckout> getListBukuCheckout() {
        List<BukuCheckout> co_list = new ArrayList();
        List result_list = manager.createNamedQuery("BukuCheckout.findAll").getResultList();

        for (Object item : result_list) {
            co_list.add((BukuCheckout) item);
        }
        return co_list;
    }

    public boolean add(BukuCheckout newCo) {
        try {
            manager.getTransaction().begin();
            manager.persist(newCo);
            manager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(BukuCheckout newCo) {
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
            
            BukuCheckout co = getBukuCheckout(id);
            manager.getTransaction().begin();
            manager.remove(co);
            manager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }  
}
