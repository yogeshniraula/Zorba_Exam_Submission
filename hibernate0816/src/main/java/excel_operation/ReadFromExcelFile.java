package excel_operation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//import com.mysql.cj.result.Row;
import entity.Teacher;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;

public class ReadFromExcelFile {
    public List<Teacher> readTeachersFromExcel(String filePath) throws FileNotFoundException {
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
return teachers;}}

