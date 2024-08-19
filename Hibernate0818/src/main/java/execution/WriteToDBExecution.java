package execution;

import jakarta.persistence.*;
import entity.ProductType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.management.Query;

public class WriteToDBExecution {

    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(ProductType.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();



        Session session = sessionFactory.openSession();


        try{
            Query query1 = (Query) session.createQuery("Create table product_type (product_id int not null, type varchar(255), price int)");

        } catch (Exception e) {
            System.err.println(e.getMessage());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        Session session1 = sessionFactory.openSession();


    }
}
