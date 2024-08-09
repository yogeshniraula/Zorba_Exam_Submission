package xmlExec;


import entities0804.Student;
import entities0804.Subject;
import entities0804.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class writingXmlBased {

        public static void main(String[] args) {
            //Read the Configuration file
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            //Create SessionFactory Object from Configuration
            SessionFactory sessionFactory = configuration.buildSessionFactory();



            //Session object creation
            Session session1 = sessionFactory.openSession();
            Transaction tx = null;
            String updateStud = "update Subject where (subjectName, )";
            try {
                tx = session1.beginTransaction();
                Query query1 = session1.createQuery(updateStud);
                query1.setParameter("newName", "Anil");
                query1.setParameter("empId", 2);
                int noOfRows = query1.executeUpdate();
                System.out.println(noOfRows + " row updated");
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            } finally {
                if (session1 != null) {
                    session1.close();
                }
            }

            //Session object creation
            Session session2 = sessionFactory.openSession();
            String selectEmp = "select empName from Employee";
            try {
                Query query2 = session2.createQuery(selectEmp);
                List<String> allEmpNames = query2.list();
                System.out.println(allEmpNames);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session2 != null) {
                    session2.close();
                }
            }
        }
    }

