package ReadExcel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcel {

    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\yoges\\Documents\\Zorba_Exam_Submission\\Hibernate0812\\src\\main\\resources\\Exam_info.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
    }
}