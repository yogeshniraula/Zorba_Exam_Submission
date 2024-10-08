package org.springMVC.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springMVC.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public InventoryDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    //constructor DI
    public void inventoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String saveInventory(Inventory inventory) {
        String res = "";
        Session session = this.sessionFactory.openSession();
        //Transaction tx = null;
        try {
            //tx = session.beginTransaction();
            session.persist(inventory);
            //tx.commit();
            res = "Data Saved Successfully...";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            //tx.rollback();
            res = "Data Not Saved";
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return res;
    }

    @Override
    public Inventory getInventoryById(int inventoryId) {

        Session session = this.sessionFactory.openSession();
        String inventoryQuery = "FROM Inventory s where s.studId = :inventoryId";
        Inventory inventory = new Inventory(inventoryId);
        try {
            Query query = session.createQuery(inventoryQuery);
            //query.setInteger("inventoryId", inventoryId);
            inventory = (Inventory) query.uniqueResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return inventory;
    }

    @Override
    public List<Inventory> getAllInventory() {
        List<Inventory> inventory = new ArrayList<>();
        Session session = this.sessionFactory.openSession();
        String inventoryQuery = "FROM Inventory";
        try {
            Query query = session.createQuery(inventoryQuery);
            inventory = query.list();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return inventory;
    }

}
