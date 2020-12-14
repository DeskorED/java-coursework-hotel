package javavt18.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javavt18.rooms.Category;
import javavt18.rooms.Room;

public class PDFBuilder extends AbstractTextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> room, Document doc,
                                    PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        // get data model which is passed by the Spring container
        Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        paragraphFont.setSize(14);

        List<Category> categories = (List<Category>) room.get("Categories");
        Paragraph catParagraph = new Paragraph("Categories",paragraphFont);
        catParagraph.setAlignment(Element.ALIGN_CENTER);
        doc.add(catParagraph);
        PdfPTable categoriesTable = getCategoryTable(categories);
        doc.add(categoriesTable);

        List<Room> rooms = (List<Room>) room.get("Rooms");
        Paragraph modelParagraph = new Paragraph("Rooms",paragraphFont);
        modelParagraph.setAlignment(Element.ALIGN_CENTER);
        doc.add(modelParagraph);
        PdfPTable carModelsTable = getCarModelTable(rooms);
        doc.add(carModelsTable);
    }


    private PdfPTable getCategoryTable(List<Category> categories) throws Exception {

        PdfPTable table = new PdfPTable(9);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{1.0f, 2.0f, 1.0f, 2.0f, 1f, 2.0f, 1.0f, 2.0f, 1.0f});
        table.setSpacingBefore(10);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA, "ISO-8859-5");
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        // write table header
        cell.setPhrase(new Phrase("#", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Number of places", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Wifi", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Breakfast", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Dinner", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Jacuzzi", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("TV", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Price", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        // write table row data
        int index = 1;
        for (Category category : categories) {
            table.addCell("" + index);
            table.addCell("" +category.getNumberOfPlaces());
            table.addCell("" +category.isWifi());
            table.addCell("" +category.isBreakfast());
            table.addCell("" +category.isDinner());
            table.addCell("" +category.isJacuzzi());
            table.addCell("" +category.isTv());
            table.addCell("" +category.getPrice());
            table.addCell(category.getName());
            index++;
        }
        return table;
    }

    private PdfPTable getCarModelTable(List<Room> rooms) throws Exception {

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{0.4f, 1.5f, 1.5f, 2.0f, 0.7f});
        table.setSpacingBefore(5);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA, "ISO-8859-5");
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        // write table header
        cell.setPhrase(new Phrase("#", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Category", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Room Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Room Number", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Status", font));
        table.addCell(cell);


        int index = 1;
        // write table row data
        for (Room room : rooms) {
            table.addCell("" + index);
            table.addCell("" +room.getIdCategory());
            table.addCell(room.getRoomName());
            table.addCell("" +room.getRoomNumber());
            table.addCell("" +room.isStatus());
            index++;
        }
        return table;
    }
}