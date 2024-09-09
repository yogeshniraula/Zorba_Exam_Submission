package xml_based.execution;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import xml_based.entity.Employee;
import xml_based.entity.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

public class XMLBasedPDExecution {

    public static void main(String[] args) {
        //Read the Configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        //Create SessionFactory Object from Configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Create new Session
        Session session = sessionFactory.openSession();

        //Declare transaction Object
        Transaction tx = null;

        File file = new File("C:\\Users\\yoges\\Documents\\Zorba_Exam_Submission\\Hibernate0812\\src\\main\\resources\\Exam_info.xlsx");


        // Saving data from Employee direction
        Employee employee = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.println("Type Employee Name: ");
        employee.setEmployeeName(sc.nextLine());
        Set<Skill> skills = new HashSet<>();

        Skill skill = new Skill();
        skill.setSkillName("Hi");
        skills.add(skill);

        Skill skill1 = new Skill();
        skill1.setSkillName("Hi");
        skills.add(skill1);

        employee.setSkills(skills);

        try (FileInputStream fileInputStream = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
           XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
//            tx = session.beginTransaction();
//            session.persist(employee);
//            tx.commit();
            for (Row row : xssfSheet) {
                Cell idCell = row.getCell(0);
                Cell nameCell = row.getCell(1);
                Cell addCell = row.getCell(2);
                Cell emailCell = row.getCell(3);
                Cell experienceCell = row.getCell(4);

                int id = (int) idCell.getNumericCellValue();
                String name = nameCell.getStringCellValue();
                String address = addCell.getStringCellValue();
                String email = emailCell.getStringCellValue();
                int experience = (int) experienceCell.getNumericCellValue();



                employee.setEmployeeId(id);
                employee.setEmployeeName(name);
                employee.setEmployeeAddress(address);
                employee.setEmployeeEmail(email);
                employee.setEmployeeExperience(experience);


                session.persist(employee);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());

        } finally {
            if (session != null) {
                session.close();
            }
        }

            Session session1 = sessionFactory.openSession();

            try (FileInputStream fileInputStream = new FileInputStream(file);
                 Workbook workbook = new XSSFWorkbook(fileInputStream)){
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
                XSSFSheet xssfSheet1 = xssfWorkbook.getSheetAt(1);

                Employee retrievedEmployee = session1.get(Employee.class, 1);
                System.out.println(retrievedEmployee);
                Set<Skill> retrievedSkill = retrievedEmployee.getSkills();
                System.out.println(retrievedSkill);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session1 != null) {
                    session1.close();
                }
            }
//
//            // saving data via Skills direction
//            Skill newSkill = new Skill();
//            newSkill.setSkillName("Test_Skill");
//
//
//            Set<Employee> employeeSet = new HashSet<>();
//
//            Employee employee1 = new Employee();
//            employee1.setEmployeeName("A");
//
//
//            Employee employee2 = new Employee();
//            employee2.setEmployeeName("B");
//
//
//            employeeSet.add(employee1);
//            employeeSet.add(employee2);
//
//            newSkill.setEmployees(employeeSet);
//
//            Session session2 = sessionFactory.openSession();
//            Transaction tx2 = null;
//
//            try {
//                tx2 = session2.beginTransaction();
//                session2.persist(newSkill);
//                tx2.commit();
//            } catch (Exception e) {
//                e.printStackTrace();
//                tx2.rollback();
//            } finally {
//                if (session2 != null) {
//                    session2.close();
//                }
//            }
//        }
    }
}
