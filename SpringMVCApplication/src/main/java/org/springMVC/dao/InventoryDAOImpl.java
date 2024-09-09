package org.springMVC.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springMVC.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveInventory(Inventory inventory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(inventory);
            session.getTransaction().commit();
        }
    }
