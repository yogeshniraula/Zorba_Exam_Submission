package org.springMVC.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springMVC.entity.InventoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class InventoryCategoryDAOImpl implements InventoryCategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<InventoryCategory> findByCategoryName(String categoryName) {
        try (Session session = sessionFactory.openSession()) {
            InventoryCategory category = session.createQuery("FROM InventoryCategory WHERE categoryName = :categoryName", InventoryCategory.class)
                    .setParameter("categoryName", categoryName)
                    .uniqueResult();
            return Optional.ofNullable(category);
        }
    }

    @Override
    public void saveCategory(InventoryCategory category) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
        }
    }
}

