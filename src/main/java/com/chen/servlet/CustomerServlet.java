package com.chen.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.entity.Customer;
import com.chen.entity.Film;
import com.chen.service.CustomerService;
import com.chen.service.FilmService;
import com.chen.service.impl.CustomerServiceImpl;
import com.chen.service.impl.FilmServiceImpl;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService = new CustomerServiceImpl();
	private FilmService filmService = new FilmServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String op =  request.getParameter("op");
			String firstName = request.getParameter("firstName");
			firstName="mary";
			HttpSession session = request.getSession();
			if(op!=null&&op.equals("login")&&firstName!=null){
				
				Customer customer=customerService.getCustomer(firstName);
				if(customer==null){
					response.sendRedirect("login.jsp");
				}else{
					List<Film> films = filmService.getAllFilms();
					session.setAttribute("customer", customer);
					session.setAttribute("films",films);
					response.sendRedirect("films.jsp");
				}
			}else{
				
				response.sendRedirect("login.jsp");
			}
			
	}

}
