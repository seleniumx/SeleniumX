package org.seleniumx.util;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static String filePath;

    private XSSFWorkbook workbook;


    private static final Logger logger = Logger.getLogger(DataReader.class);

    public String[] getData(int startingRaw, int columnNumber) {
        List<String> date = new ArrayList<String>();
        File src = new File(getFilePath());
        try {
            FileInputStream fis = new FileInputStream(src);
            workbook = new XSSFWorkbook(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        try {
            for (int i = startingRaw; i <= sheet.getLastRowNum(); i++) {
                XSSFCell cell = sheet.getRow(i).getCell(columnNumber);
                cell.setCellType(CellType.STRING);
                date.add(cell.getStringCellValue());
            }
        } catch (Exception e) {
            logger.info("Enf ot Excel sheet.");
        }

        String[] dataArray = new String[date.size()];
        dataArray = date.toArray(dataArray);
        return dataArray;
    }

    private static DataReader DataReader = null;

    private DataReader() {
    }

    public static synchronized DataReader reads() {
        if (DataReader == null) {
            DataReader = new DataReader();
        }
        return DataReader;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}