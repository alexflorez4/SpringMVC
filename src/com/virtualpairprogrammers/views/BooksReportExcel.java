package com.virtualpairprogrammers.views;

import com.virtualpairprogrammers.domain.Book;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class BooksReportExcel extends AbstractExcelView
{
    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook wb, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception
    {
        HSSFSheet sheet = wb.createSheet("Book Report");

        List<Book> books = (List)model.get("allBooks");
        for (int i=0; i<books.size(); i++)
        {
            Book next = (Book) books.get(i);

            HSSFCell cell = getCell(sheet, 1+i, 0);
            setText(cell, next.getTitle());

            cell = getCell(sheet, 1+i, 1);
            setText(cell, next.getAuthor());

            cell = getCell(sheet, 1+i, 2);
            setText(cell, "" + next.getPrice());
        }
    }
}
