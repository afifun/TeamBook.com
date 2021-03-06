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

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import model.Akun;

public class AkunDAO {

    private EntityManager manager;

    public AkunDAO() throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeamBook.comPU");
        this.manager = emf.createEntityManager();
    }

    public Akun getAkun(String id) {
        Akun co = (Akun) manager.createNamedQuery("Akun.findById").setParameter("id", Integer.parseInt(id)).getSingleResult();
        if (co == null) {
            throw new EntityNotFoundException("Tidak dapat menemukan akun dengan id " + id);
        }
        return co;
    }
    
    public Akun getAkunByEmail(String email) {
        List co = manager.createNamedQuery("Akun.findByEmail").setParameter("email", email).getResultList();
        
        if(!co.isEmpty()){
            Akun akun = (Akun) co.get(0);
            return akun;
        }
        else {
            return null;
        }
    }
    
    public List<Akun> getListAkun() {
        List<Akun> co_list = new ArrayList();
        List result_list = manager.createNamedQuery("Akun.findAll").getResultList();

        for (Object item : result_list) {
            co_list.add((Akun) item);
        }
        return co_list;
    }

    public boolean add(Akun newCo) throws IOException, SQLException {
        
        if(emailIsNotExist(newCo.getEmail())){
            try {
                manager.getTransaction().begin();
                manager.persist(newCo);
                manager.getTransaction().commit();

                return true;
            } catch (Exception e) {
                return false;
            }
        }
        else{
            System.out.println("emailnya sudah digunakan");
            return false;
        }
        
    }

    public boolean update(Akun newCo) throws IOException, SQLException {
        if(emailIsNotExist2(newCo)){
            try{
            manager.getTransaction().begin();
            manager.merge(newCo);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
        }
        else{
            System.out.println("emailnya sudah digunakan");
            return false;
        }
    }

    public boolean delete(String id) {
        try {

            Akun co = getAkun(id);
            manager.getTransaction().begin();
            manager.remove(co);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Akun login(String str, String password) throws Exception {
       List list = null;
       if(str.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
           list = manager.createNamedQuery("Akun.findByEmail").setParameter("email", str).getResultList();
       }
       else {
           list = manager.createNamedQuery("Akun.findByUsername").setParameter("username", str).getResultList();
       }
       
        
       if(list == null || list.size() == 0){
            return null;
       }
       else {
           Akun akun = (Akun) list.get(0);
           if (akun.getPassword().equals(password)){
               return akun;
           }
           else {
               System.out.println("password ga sama");
               return null;
           }
       }
    }
    
    public boolean emailIsNotExist2(Akun acc) throws IOException, SQLException {
        List akun = manager.createNamedQuery("Akun.findByEmail").setParameter("email", acc.getEmail()).getResultList();
        Akun akunobj = (Akun) akun.get(0);
        
        if (akun == null){
            return true;
        }
        else return Objects.equals(akunobj.getId(), acc.getId());
    }
    
    public boolean emailIsNotExist(String email) throws IOException, SQLException {
        List akun = manager.createNamedQuery("Akun.findByEmail").setParameter("email", email).getResultList();
        return akun != null;
    }

    public String getAkunId(String email) throws IOException, SQLException {
        Akun co = (Akun) manager.createNamedQuery("Akun.findByEmail").setParameter("email",email).getSingleResult();
        if (co == null) {
            throw new EntityNotFoundException("Tidak dapat menemukan akun dengan email " + email);
        }
        return ""+co.getId();
        
    }
}
