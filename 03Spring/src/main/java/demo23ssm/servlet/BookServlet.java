package demo23ssm.servlet;

import com.sun.javafx.webkit.WebConsoleListener;
import demo23ssm.entity.Book;
import demo23ssm.service.IBookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mycom on 2018/3/17.
 */
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bookName=request.getParameter("bookname");
        Integer bookPrice=Integer.parseInt(request.getParameter("bookprice"));
        String bookAuthor=request.getParameter("bookauthor");
        //创建book对象
        Book book=new Book();
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);
        book.setBookAuthor(bookAuthor);
        //ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextdemo23ssm.xml");
        ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        IBookService bookService =(IBookService) context.getBean("bookService");
        int count = bookService.addBook(book);
        if(count>0){
            //转发
            request.getSession().setAttribute("book",book);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            response.sendRedirect("/addBook.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
