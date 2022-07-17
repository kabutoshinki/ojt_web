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

    static public List<Account> upload(MultipartFile file) throws Exception {
        List <Account> accountList = new ArrayList<>();
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
                Account newAccount = new Account();
                newAccount.setFullName((String) params.get(1));
                /*if (params.size() > 3)
                    newAccount.setStudentId((String) params.get(3));*/
                newAccount.setEmail((String) params.get(2));
                accountList.add(newAccount);
                /*accountList.add(new Account((int)Math.round((Double)params.get(0)), (String) params.get(1), (String) params.get(2),
                        null, (String) params.get(4), (String) params.get(5), (String) params.get(6), (int)Math.round((Double)params.get(7))));*/
                //System.out.println("");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        //System.out.println(accountList);
        return accountList;
    }

    public void saveFile(MultipartFile file, String name, String path) {
        if(file.isEmpty())
        {
            throw  new RuntimeException("please provide a valide file");
        }

        InputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(file.getInputStream());
            byte[] b = in.readAllBytes();
            String filename = file.getOriginalFilename();
            int index = filename.indexOf('.');
            String extension = filename.substring(index+1, filename.length()).toUpperCase();
            path += name + "." + extension;
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