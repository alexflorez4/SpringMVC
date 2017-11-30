package com.virtualpairprogrammers.views;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.virtualpairprogrammers.domain.Book;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class BooksReportPdf extends AbstractPdfView
{
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception
    {
        List<Book> books = (List<Book>)model.get("allBooks");

        PdfPTable table = new PdfPTable(3);

        for(Book next : books)
        {
            table.addCell(next.getTitle());
            table.addCell(next.getAuthor());
            table.addCell("" + next.getPrice());
        }
        document.add(table);
    }
}
