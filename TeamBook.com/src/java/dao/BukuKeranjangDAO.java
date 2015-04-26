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
import model.BukuKeranjang;

/**
 *
 * @author moh.afifun
 */
public class BukuKeranjangDAO {

    private EntityManager manager;

    public BukuKeranjangDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeamBook.comPU");
        this.manager = emf.createEntityManager();
    }

    public BukuKeranjang getBukuKeranjang(String id) {
        BukuKeranjang co = (BukuKeranjang) manager.createNamedQuery("BukuKeranjang.findById").setParameter("id", Integer.parseInt(id)).getSingleResult();
        if (co == null) {
            throw new EntityNotFoundException("Tidak dapat menemukan checkout dengan id " + id);
        }
        return co;
    }

    public int size(String idKeranjang) {
        List co = manager.createNamedQuery("BukuKeranjang.findByIdKeranjang").setParameter("idKeranjang", Integer.parseInt(idKeranjang)).getResultList();
        if (co == null) {
            throw new EntityNotFoundException("Tidak dapat menemukan BukuKeranjang dengan idKeranjang " + idKeranjang);
        }
        return co.size();
    }

    public List<BukuKeranjang> getListBukuKeranjang() {
        List<BukuKeranjang> co_list = new ArrayList();
        List result_list = manager.createNamedQuery("BukuKeranjang.findAll").getResultList();

        for (Object item : result_list) {
            co_list.add((BukuKeranjang) item);
        }
        return co_list;
    }

    public List<BukuKeranjang> getListBukuKeranjangByKeranjang(int idKeranjang) {
        List<BukuKeranjang> co_list = new ArrayList();
        List result_list = manager.createNamedQuery("BukuKeranjang.findByIdKeranjang").setParameter("idKeranjang", idKeranjang).getResultList();

        for (Object item : result_list) {
            co_list.add((BukuKeranjang) item);
        }
        return co_list;
    }

    public boolean add(BukuKeranjang newCo) {
        try {
            BukuKeranjang tmp = getBukuKeranjangByBuku(newCo.getIdKeranjang(), newCo.getIdBuku());
            if (tmp == null) {
                newCo.setKuantitas(1);
                manager.getTransaction().begin();
                manager.persist(newCo);
                manager.getTransaction().commit();
            } else {
                int old_kuantitas = tmp.getKuantitas();
                int new_kuantitas = old_kuantitas + 1;

                newCo.setId(tmp.getId());
                newCo.setKuantitas(new_kuantitas);

                update(newCo);
            }
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public boolean update(BukuKeranjang newCo) {
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

            BukuKeranjang co = getBukuKeranjang(id);
            manager.getTransaction().begin();
            manager.remove(co);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private BukuKeranjang getBukuKeranjangByBuku(int idKeranjang, int idBuku) {
        List co = manager.createNamedQuery("BukuKeranjang.findByIdKeranjangAndBuku").setParameter("idKeranjang", idKeranjang).setParameter("idBuku", idBuku).getResultList();
        if (!co.isEmpty()) {
            BukuKeranjang item = (BukuKeranjang) co.get(0);
            return item;
        } else {
            return null;
        }
    }
}
