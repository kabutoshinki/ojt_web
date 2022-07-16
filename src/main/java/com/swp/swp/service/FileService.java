package com.swp.swp.service;

import com.swp.swp.database.Database;
import com.swp.swp.model.Account;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FileService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    static public ArrayList <ArrayList> upload(MultipartFile file) throws Exception {
        ArrayList <ArrayList> accountList = new ArrayList<>();
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
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(accountList);
        return accountList;
    }

    public void saveFile(MultipartFile file, String path) {
        if(file.isEmpty())
        {
            throw  new RuntimeException("please provide a valide file");
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
        }
        finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}