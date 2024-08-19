package execution;


import jakarta.persistence.*;
import entity.ProductType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.management.Query;

public class WriteToTable {

    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(ProductType.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();



        Session session = sessionFactory.openSession();


        try{
            Query query1 = (Query) session.createQuery("Insert into product_type (type, rate) values (grocery, 30), " +
                    "(cosmatics, 50), (dairyproduct, 35)");

        } catch (Exception e) {
            System.err.println(e.getMessage());

        } finally {
            if (session != null) {
                session.close();
            }
        }



    }
}