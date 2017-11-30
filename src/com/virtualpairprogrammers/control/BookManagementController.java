package com.virtualpairprogrammers.control;

import java.util.List;

import com.virtualpairprogrammers.views.BooksReportExcel;
import com.virtualpairprogrammers.views.BooksReportPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.virtualpairprogrammers.domain.Book;
import com.virtualpairprogrammers.services.BookService;

@Controller
public class BookManagementController
{
	@Autowired
	private BookService bookService;

	@RequestMapping("/viewAllBooks")
	public ModelAndView viewAllBooks()
	{
		List<Book> allBooks = bookService.getEntireCatalogue();
		return new ModelAndView("displayAllBooks","allBooks",allBooks);
	}

	@RequestMapping("/viewAllBooksPDF")
	public ModelAndView viewAllBooksPDF()
	{
		List<Book> allBooks = bookService.getEntireCatalogue();
		return new ModelAndView("bookReportPdf", "allBooks", allBooks);
	}

	@RequestMapping("/viewAllBooksExcel")
	public ModelAndView viewAllBooksExcel()
	{
		List<Book> allBooks = bookService.getEntireCatalogue();
		return new ModelAndView("bookReportExcel", "allBooks", allBooks);
	}

	@RequestMapping("/findByAuthor") //this is mapped to findByAuthor.jsp - action in the form.  Notice that .do is not needed
	public ModelAndView findByAuthor(@RequestParam("AUTHOR") String author) //this is how parameters are being passed from the request jsp to the controller.
	{
		List<Book> books = bookService.getAllBooksByAuthor(author);
		return new ModelAndView("displayAllBooks", "allBooks", books); //allBooks is the jsp variable in displayAllBooks.jsp
	}

	@RequestMapping("/looseSearch")
	public @ResponseBody List<Book> performLooseSearch(@RequestParam("CHARS") String chars)
	{
		if(chars.length() < 3)
			return null;

		return bookService.searchBooksByLooseMatch(chars);
	}
}

