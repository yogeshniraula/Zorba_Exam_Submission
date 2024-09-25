package org.springMVC.dao;

//import org.hibernate.Query;
import org.hibernate.query.Query; // Correct import for Hibernate 5.x

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springMVC.entity.Inventory;
import org.springMVC.entity.InventoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InventoryCategoryDAOImpl implements InventoryCategoryDAO {


    private SessionFactory sessionFactory;
//    @Autowired
//    InventoryCategory inventoryCategory;
//    @Autowired
//    Inventory inventory;

    //constructor DI
    @Autowired
    public InventoryCategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<InventoryCategory> findCategoryByName(String categoryName) {
        InventoryCategory inventoryCategory = new InventoryCategory();
        Session session = this.sessionFactory.openSession();
        String inventoryCategoryQuery = "FROM InventoryCategory i where i.categoryName = :categoryName";
        try {
            Query query = session.createQuery(inventoryCategoryQuery);
           // query.setString("categoryName", categoryName);
            inventoryCategory = (InventoryCategory) query.uniqueResult();
            return Optional.ofNullable(inventoryCategory);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return Optional.of(inventoryCategory);
    }

    @Override
    public String saveCategory(Optional<InventoryCategory> category) {
        String res = "";
        Session session = this.sessionFactory.openSession();
        //Transaction tx = null;
        try {
            //tx = session.beginTransaction();
            session.persist(category);
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
}

