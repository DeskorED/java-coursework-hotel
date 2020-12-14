package javavt18.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javavt18.rooms.Room;
import javavt18.rooms.Category;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBuilder extends AbstractPOIExcelView {
    @Override
    protected XSSFWorkbook createWorkbook() {
        return new XSSFWorkbook();
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> room, XSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // get data model which is passed by the Spring container
        List<Category> Categories = (List<Category>) room.get("Category");
        List<Room> Rooms = (List<Room>) room.get("Room");

        generateBrandSheet(workbook, Categories);
        generateModelsSheet(workbook, Rooms);
    }

    private void generateBrandSheet(XSSFWorkbook workbook, List<Category> Categories){

        // create a new Excel sheet
        Sheet sheet = workbook.createSheet("Categories");
        sheet.setColumnWidth(0,2000);
        sheet.setColumnWidth(1,2000);
        sheet.setColumnWidth(2,2000);
        sheet.setColumnWidth(3,2000);
        sheet.setColumnWidth(4,2000);
        sheet.setColumnWidth(5,2000);
        sheet.setColumnWidth(6,2000);
        sheet.setColumnWidth(7,2000);
        sheet.setColumnWidth(8,2000);


        Font font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        font.setFontName("Helvetica");

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setFont(font);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        // create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("№");
        headerRow.getCell(0).setCellStyle(headerStyle);

        headerRow.createCell(1).setCellValue("NumberOfPlaces");
        headerRow.getCell(1).setCellStyle(headerStyle);

        headerRow.createCell(2).setCellValue("Wi-fi");
        headerRow.getCell(2).setCellStyle(headerStyle);

        headerRow.createCell(3).setCellValue("Breakfast");
        headerRow.getCell(3).setCellStyle(headerStyle);

        headerRow.createCell(4).setCellValue("Dinner");
        headerRow.getCell(4).setCellStyle(headerStyle);

        headerRow.createCell(5).setCellValue("Jacuzzi");
        headerRow.getCell(5).setCellStyle(headerStyle);

        headerRow.createCell(6).setCellValue("TV");
        headerRow.getCell(6).setCellStyle(headerStyle);

        headerRow.createCell(7).setCellValue("Price");
        headerRow.getCell(7).setCellStyle(headerStyle);

        headerRow.createCell(8).setCellValue("Name");
        headerRow.getCell(8).setCellStyle(headerStyle);

        CellStyle rowCellStyle = workbook.createCellStyle();
        rowCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        // create data rows
        int rowCount = 1;
        for (Category Category : Categories) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(rowCount-1);
            row.getCell(0).setCellStyle(rowCellStyle);

            row.createCell(1).setCellValue(Category.getNumberOfPlaces());
            row.getCell(1).setCellStyle(rowCellStyle);

            row.createCell(2).setCellValue(Category.isWifi());
            row.getCell(2).setCellStyle(rowCellStyle);

            row.createCell(3).setCellValue(Category.isBreakfast());
            row.getCell(3).setCellStyle(rowCellStyle);

            row.createCell(4).setCellValue(Category.isDinner());
            row.getCell(4).setCellStyle(rowCellStyle);

            row.createCell(5).setCellValue(Category.isJacuzzi());
            row.getCell(5).setCellStyle(rowCellStyle);

            row.createCell(6).setCellValue(Category.isTv());
            row.getCell(6).setCellStyle(rowCellStyle);

            row.createCell(7).setCellValue(Category.getPrice());
            row.getCell(7).setCellStyle(rowCellStyle);

            row.createCell(8).setCellValue(Category.getName());
            row.getCell(8).setCellStyle(rowCellStyle);
        }
    }

    private void generateModelsSheet(XSSFWorkbook workbook, List<Room> Rooms){

        // create a new Excel sheet
        Sheet sheet = workbook.createSheet("Rooms");
        sheet.setColumnWidth(0,2000);
        sheet.setColumnWidth(1,5000);
        sheet.setColumnWidth(2,5000);
        sheet.setColumnWidth(3,7000);
        sheet.setColumnWidth(4,2500);
        sheet.setColumnWidth(5,2000);
        sheet.setColumnWidth(6,2000);
        sheet.setColumnWidth(7,2500);

        Font font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        font.setFontName("Helvetica");

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setFont(font);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

        // create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("№");
        headerRow.getCell(0).setCellStyle(headerStyle);

        headerRow.createCell(1).setCellValue("Category");
        headerRow.getCell(1).setCellStyle(headerStyle);

        headerRow.createCell(2).setCellValue("Room name");
        headerRow.getCell(2).setCellStyle(headerStyle);

        headerRow.createCell(3).setCellValue("Room number");
        headerRow.getCell(3).setCellStyle(headerStyle);

        headerRow.createCell(4).setCellValue("Status");
        headerRow.getCell(4).setCellStyle(headerStyle);

        CellStyle rowCellStyle = workbook.createCellStyle();
        rowCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        // create data rows
        int rowCount = 1;
        for (Room Room : Rooms) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(rowCount-1);
            row.getCell(0).setCellStyle(rowCellStyle);

            row.createCell(1).setCellValue(Room.getIdCategory());
            row.getCell(1).setCellStyle(rowCellStyle);

            row.createCell(2).setCellValue(Room.getRoomName());
            row.getCell(2).setCellStyle(rowCellStyle);

            row.createCell(3).setCellValue(Room.getRoomNumber());
            row.getCell(3).setCellStyle(rowCellStyle);

            row.createCell(4).setCellValue(Room.isStatus());
            row.getCell(4).setCellStyle(rowCellStyle);

        }
    }

}