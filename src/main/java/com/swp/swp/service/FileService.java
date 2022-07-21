package com.swp.swp.service;

import com.swp.swp.database.Database;
import com.swp.swp.model.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FileService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    static public ArrayList<ArrayList> upload(MultipartFile file) throws Exception {
        ArrayList<ArrayList> accountList = new ArrayList<>();
        try {
            Path tempDir = Files.createTempDirectory("");

            File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();

            file.transferTo(tempFile);
            FileInputStream fis = new FileInputStream(tempFile);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            int rowId = 0;
            while (itr.hasNext()) {
                ArrayList params = new ArrayList();
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //System.out.print(cell.getCellType() + "    ");
                    switch (cell.getCellType()) {
                        case STRING:
                            //System.out.println(cell.getStringCellValue() + "\t\t\t");
                            params.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            //System.out.println(cell.getNumericCellValue() + "\t\t\t");
                            params.add(cell.getNumericCellValue());
                            break;
                        default:
                            System.out.println("\t\t\t");
                    }
                }
                rowId++;
                if (rowId == 1) continue;
                //System.out.println(params);
                accountList.add(params);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(accountList);
        return accountList;
    }

    public void saveFile(MultipartFile file, String path) {
        if (file.isEmpty()) {
            throw new RuntimeException("please provide a valide file");
        }

        InputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(file.getInputStream());
            byte[] b = in.readAllBytes();
            out = new BufferedOutputStream(new FileOutputStream(path));
            out.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void exportStudentList(Iterable<Student> studentList) {
        try {


            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Students");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("No.");
            rowhead.createCell(1).setCellValue("Student ID");
            rowhead.createCell(2).setCellValue("Full Name");
            rowhead.createCell(3).setCellValue("Email");
            rowhead.createCell(4).setCellValue("Phone");
            rowhead.createCell(5).setCellValue("Gender");
            rowhead.createCell(6).setCellValue("Address");
            rowhead.createCell(7).setCellValue("Status");
            int count = 1;
            for (Student student: studentList) {
                HSSFRow row = sheet.createRow((short) count);

                row.createCell(0).setCellValue(count);
                row.createCell(1).setCellValue(student.getStudentId());
                row.createCell(2).setCellValue(student.getAccount().getFullName());
                row.createCell(3).setCellValue(student.getAccount().getEmail());
                row.createCell(4).setCellValue(student.getAccount().getPhone());
                row.createCell(5).setCellValue(student.getGender());
                row.createCell(6).setCellValue(student.getAccount().getAddress());
                row.createCell(7).setCellValue(student.getAccount().getStatus());
                count += 1;
            }
            /*Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\target\\classes\\static");
            String filename = currentWorkingDir.normalize().toString() + "\\file.xls";
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);*/
            workbook.write(new FileOutputStream(Path.of(Paths.get("").toAbsolutePath() + "/target/classes/static").toString() + "/file.xls"));
            workbook.write(new FileOutputStream(Path.of(Paths.get("").toAbsolutePath() + "/src/main/resources/static").toString() + "/file.xls"));

            //fileOut.close();
            workbook.close();
            System.out.println("Excel file has been generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportCompanyList(Iterable<Company> companyList) {
        try {
            Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\target\\classes\\static");
            String filename = currentWorkingDir.normalize().toString() + "\\file.xls";

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Companies");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("No.");
            rowhead.createCell(1).setCellValue("Company Name");
            rowhead.createCell(2).setCellValue("Email");
            rowhead.createCell(3).setCellValue("Phone");
            rowhead.createCell(4).setCellValue("Address");
            rowhead.createCell(5).setCellValue("Status");
            int count = 1;
            for (Company company: companyList) {
                HSSFRow row = sheet.createRow((short) count);

                row.createCell(0).setCellValue(count);
                row.createCell(1).setCellValue(company.getAccount().getFullName());
                row.createCell(2).setCellValue(company.getAccount().getEmail());
                row.createCell(3).setCellValue(company.getAccount().getPhone());
                row.createCell(4).setCellValue(company.getAccount().getAddress());
                row.createCell(5).setCellValue(company.getAccount().getStatus());
                count += 1;
            }
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            /*workbook.close();*/
            workbook.write(new FileOutputStream(Path.of(Paths.get("").toAbsolutePath() + "/target/classes/static").toString() + "/file.xls"));
            workbook.write(new FileOutputStream(Path.of(Paths.get("").toAbsolutePath() + "/src/main/resources/static").toString() + "/file.xls"));

            System.out.println("Excel file has been generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void exportApplyList(Iterable<StudentApplyJob> applyList) {
        try {
            Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\target\\classes\\static");
            String filename = currentWorkingDir.normalize().toString() + "\\file.xls";

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Applications");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("No.");
            rowhead.createCell(1).setCellValue("Student ID");
            rowhead.createCell(2).setCellValue("Full name");
            rowhead.createCell(3).setCellValue("Email");
            rowhead.createCell(4).setCellValue("Phone");
            rowhead.createCell(5).setCellValue("Position");
            rowhead.createCell(6).setCellValue("Company");
            rowhead.createCell(7).setCellValue("Status");
            int count = 1;
            for (StudentApplyJob apply: applyList) {
                HSSFRow row = sheet.createRow((short) count);

                row.createCell(0).setCellValue(count);
                row.createCell(1).setCellValue(apply.getStudent().getStudentId());
                row.createCell(2).setCellValue(apply.getStudent().getAccount().getFullName());
                row.createCell(3).setCellValue(apply.getStudent().getAccount().getEmail());
                row.createCell(4).setCellValue(apply.getStudent().getAccount().getPhone());
                row.createCell(5).setCellValue(apply.getJob().getPosition().getPosition());
                row.createCell(6).setCellValue(apply.getJob().getCompany().getAccount().getFullName());
                row.createCell(7).setCellValue(apply.getStatus());
                count += 1;
            }
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Excel file has been generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportExternalApplyList(Iterable<ExternalRequest> requestsList) {
        try {
            Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\target\\classes\\static");
            String filename = currentWorkingDir.normalize().toString() + "\\file.xls";

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("External Applications");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("No.");
            rowhead.createCell(1).setCellValue("Student ID");
            rowhead.createCell(2).setCellValue("Full name");
            rowhead.createCell(3).setCellValue("Email");
            rowhead.createCell(4).setCellValue("Phone");
            rowhead.createCell(5).setCellValue("Company Name");
            rowhead.createCell(6).setCellValue("Company Email");
            rowhead.createCell(7).setCellValue("Company Phone");
            rowhead.createCell(8).setCellValue("Status");
            int count = 1;
            for (ExternalRequest request: requestsList) {
                HSSFRow row = sheet.createRow((short) count);

                row.createCell(0).setCellValue(count);
                row.createCell(1).setCellValue(request.getStudent().getStudentId());
                row.createCell(2).setCellValue(request.getStudent().getAccount().getFullName());
                row.createCell(3).setCellValue(request.getStudent().getAccount().getEmail());
                row.createCell(4).setCellValue(request.getStudent().getAccount().getPhone());
                row.createCell(5).setCellValue(request.getCompanyName());
                row.createCell(6).setCellValue(request.getCompanyEmail());
                row.createCell(7).setCellValue(request.getCompanyPhone());
                row.createCell(8).setCellValue(request.getApplication().getStatus());
                count += 1;
            }
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            //workbook.close();
            workbook.write(new FileOutputStream(Path.of(Paths.get("").toAbsolutePath() + "/target/classes/static").toString() + "/file.xls"));
            workbook.write(new FileOutputStream(Path.of(Paths.get("").toAbsolutePath() + "/src/main/resources/static").toString() + "/file.xls"));

            System.out.println("Excel file has been generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportProcessList(Iterable<OjtProcess> processList) {
        try {
            Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\target\\classes\\static");
            String filename = currentWorkingDir.normalize().toString() + "\\file.xls";

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("External Applications");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("No.");
            rowhead.createCell(1).setCellValue("Student ID");
            rowhead.createCell(2).setCellValue("Full name");
            rowhead.createCell(3).setCellValue("Email");
            rowhead.createCell(4).setCellValue("Phone");
            rowhead.createCell(5).setCellValue("Start Date");
            rowhead.createCell(6).setCellValue("End Date");
            rowhead.createCell(7).setCellValue("Job Description");
            rowhead.createCell(8).setCellValue("Knowledge");
            rowhead.createCell(9).setCellValue("Knowledge Point");
            rowhead.createCell(10).setCellValue("Soft Skill");
            rowhead.createCell(11).setCellValue("Soft Skill Point");
            rowhead.createCell(12).setCellValue("Attitude");
            rowhead.createCell(13).setCellValue("Attitude Point");
            rowhead.createCell(14).setCellValue("Total Grade");


            rowhead.createCell(15).setCellValue("Status");
            int count = 1;
            for (OjtProcess process: processList) {
                HSSFRow row = sheet.createRow((short) count);

                row.createCell(0).setCellValue(count);
                row.createCell(1).setCellValue(process.getStudent().getStudentId());
                row.createCell(2).setCellValue(process.getStudent().getAccount().getFullName());
                row.createCell(3).setCellValue(process.getStudent().getAccount().getEmail());
                row.createCell(4).setCellValue(process.getStudent().getAccount().getPhone());
                row.createCell(5).setCellValue(process.getStartDate());
                row.createCell(6).setCellValue(process.getEndDate());
                row.createCell(7).setCellValue(process.getDescription());
                row.createCell(8).setCellValue(process.getKnowledge());
                row.createCell(9).setCellValue(process.getKnowledgePoint());
                row.createCell(10).setCellValue(process.getSoftSkill());
                row.createCell(11).setCellValue(process.getSoftSkillPoint());
                row.createCell(12).setCellValue(process.getAttitude());
                row.createCell(13).setCellValue(process.getAttitudePoint());
                row.createCell(14).setCellValue(process.getGrade());
                row.createCell(15).setCellValue(process.getApplication().getStatus());
                count += 1;
            }
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            //workbook.close();
            workbook.write(new FileOutputStream(Path.of(Paths.get("").toAbsolutePath() + "/target/classes/static").toString() + "/file.xls"));
            workbook.write(new FileOutputStream(Path.of(Paths.get("").toAbsolutePath() + "/src/main/resources/static").toString() + "/file.xls"));

            System.out.println("Excel file has been generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportEmployeeList(ArrayList<Employee> employeeList) {
        try {


            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Employees");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("No.");
            rowhead.createCell(1).setCellValue("Full Name");
            rowhead.createCell(2).setCellValue("Email");
            rowhead.createCell(3).setCellValue("Phone");
            rowhead.createCell(4).setCellValue("Address");
            int count = 1;
            for (Employee employee: employeeList) {
                HSSFRow row = sheet.createRow((short) count);

                row.createCell(0).setCellValue(count);
                row.createCell(1).setCellValue(employee.getAccount().getFullName());
                row.createCell(2).setCellValue(employee.getAccount().getEmail());
                row.createCell(3).setCellValue(employee.getAccount().getPhone());
                row.createCell(4).setCellValue(employee.getAccount().getAddress());
                count += 1;
            }
            /*Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\target\\classes\\static");
            String filename = currentWorkingDir.normalize().toString() + "\\file.xls";
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);*/
            workbook.write(new FileOutputStream(Path.of(Paths.get("").toAbsolutePath() + "/target/classes/static").toString() + "/file.xls"));
            workbook.write(new FileOutputStream(Path.of(Paths.get("").toAbsolutePath() + "/src/main/resources/static").toString() + "/file.xls"));

            //fileOut.close();
            workbook.close();
            System.out.println("Excel file has been generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}