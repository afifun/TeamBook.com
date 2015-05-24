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
import model.Checkout;

/**
 *
 * @author moh.afifun
 */
public class CheckoutDAO {

    private EntityManager manager;

    public CheckoutDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeamBook.comPU");
        this.manager = emf.createEntityManager();
    }

    public Checkout getCheckout(String id) {
        Checkout co = (Checkout) manager.createNamedQuery("Checkout.findById").setParameter("id", Long.parseLong(id)).getSingleResult();
        if (co == null) {
            throw new EntityNotFoundException("Tidak dapat menemukan checkout dengan id " + id);
        }
        return co;
    }
    
    public List<Checkout> getCheckoutByAkun(String id) {
        List<Checkout> co_list = new ArrayList();
        List result_list = manager.createNamedQuery("Checkout.findByIdAkun").setParameter("idAkun", Integer.parseInt(id)).getResultList();
        for (Object item : result_list) {
            co_list.add((Checkout) item);
        }
        return co_list;
    }

    public List<Checkout> getListCheckout() {
        List<Checkout> co_list = new ArrayList();
        List result_list = manager.createNamedQuery("Checkout.findAll").getResultList();

        for (Object item : result_list) {
            co_list.add((Checkout) item);
        }
        return co_list;
    }

    public boolean add(Checkout newCo) {
        try {
            manager.getTransaction().begin();
            manager.persist(newCo);
            manager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(Checkout newCo) {
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
            
            Checkout co = getCheckout(id);
            manager.getTransaction().begin();
            manager.remove(co);
            manager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }  
}
