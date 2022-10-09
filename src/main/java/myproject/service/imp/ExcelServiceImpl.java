package myproject.service.imp;

import myproject.models.Student;
import myproject.models.User;
import myproject.service.abstracts.ExcelService;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public User loadAllUsers() {
        return null;
    }

    @Override
    public void unloadAllUsers(List<Student> students) {
        try (Workbook book = new XSSFWorkbook()){
            FileOutputStream fileOut = new FileOutputStream("H://Test//students.xlsx");
            Sheet sheet = book.createSheet("something");
            int counter = 0;
            for (Student student:students) {
                XSSFRow row = (XSSFRow) sheet.createRow((short) counter++);
                row.createCell(0).setCellValue(student.getTypeOfDocument());
                row.createCell(1).setCellValue(student.getProgram());
                row.createCell(2).setCellValue(student.getManager());
                row.createCell(3).setCellValue(student.getFullNameStudent());
                row.createCell(4).setCellValue(student.getRegistrationNumber());
                row.createCell(5).setCellValue(student.getForm());
                row.createCell(6).setCellValue(student.getEnrollmentDate());
                row.createCell(7).setCellValue(student.getReleaseDate());
                row.createCell(8).setCellValue(student.getNameGroup());
                row.createCell(9).setCellValue(student.getNumberOfHours());
                row.createCell(10).setCellValue(student.getTheLevelOfEducation());
                row.createCell(11).setCellValue(student.getCommissionDecision());
                row.createCell(12).setCellValue(student.getPlaceOfWork());
                row.createCell(13).setCellValue(student.getJobTitle());
                counter++;
            }
            book.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
