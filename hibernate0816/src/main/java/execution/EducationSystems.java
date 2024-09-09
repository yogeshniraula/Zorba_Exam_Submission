package execution;

import entity.*;

import excel_operation.ReadFromExcelFile;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
* We have one excel file name education_systems,
1. read the excel file
2. Store the 3 entity info with mapping to database in 3 tables
3. We need to fetch data based on below condition.
    i. fetch all the student info who belongs to department science
    ii. fetch all the department info where teacher belongs to NYC
    iii. fetch the teacher info who has the students score the highest.
*
* */
public class EducationSystems {
    public static void main(String[] args) {
        List<Teacher> receivedTeachers = new ArrayList<>();
        //read the excel file from the location
        try {
            File file = new File("src/main/resources/education_systems.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            ReadFromExcelFile readFromExcelFile = new ReadFromExcelFile();
            receivedTeachers = readFromExcelFile.readTeachersFromExcel("file");
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        //Database operation
        //Save Data to the respective tables
        saveData(receivedTeachers);

        //fetch Student Info
        List<Student> fetchStudents = fetchStudentInfo();
        System.out.println(fetchStudents);

        //fetch Department Info
        List<Department> departments = fetchDepartmentInfo();
        System.out.println(departments);

        //fetch teacher Info
        Teacher retrievedTeacher = fetchTeacherInfo();
        System.out.println(retrievedTeacher);
    }

    private static SessionFactory getSessionFactory() {
        //Read Configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        //Register all the entity to the hibernate for annotation based operation
        configuration.addAnnotatedClass(Teacher.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Department.class);

        //Create SessionFactory Object from Configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    private static void saveData(List<Teacher> teachers) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            for (Teacher teacher: teachers) {
                session.persist(teacher);
            }
            tx.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private static List<Student> fetchStudentInfo() {
        List<Student> students = new ArrayList<>();
        Session session = getSessionFactory().openSession();
//        String joinQuery = "select from Student s join Teacher t on t.teacherId = s.teacherId " +
//                                                " join Department d on d.t"
        //TODO: Need to read the students object using HQL/Criteria/NormalSession
        return students;
    }

    private static List<Department> fetchDepartmentInfo() {
        List<Department> departments = new ArrayList<>();
        Session session = getSessionFactory().openSession();
        //TODO: Need to read the Department object using HQL/Criteria/NormalSession
        return departments;
    }

    private static Teacher fetchTeacherInfo() {

        Session session = getSessionFactory().openSession();
        //TODO: Need to read the Teacher object using HQL/Criteria/NormalSession

        List<Teacher> teachers = new ArrayList<>();

        try (FileInputStream file = new FileInputStream("src/main/resources/education_systems.xlsx");
             Workbook workbook = new HSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                // Skip header row
                if (row.getRowNum() == 0) continue;

                Long id = (long) row.getCell(0).getNumericCellValue();
                String name = row.getCell(0).getStringCellValue();
                String specialization = row.getCell(1).getStringCellValue();
                String email = row.getCell(2).getStringCellValue();
                Long mobile = (long) row.getCell(3).getNumericCellValue();
                String address = row.getCell(4).getStringCellValue();

                Teacher teacher = new Teacher();
                teachers.add(teacher);
            }

        } catch (IOException e) {
            e.printStackTrace();


        }
        return (Teacher) teachers;

    }}