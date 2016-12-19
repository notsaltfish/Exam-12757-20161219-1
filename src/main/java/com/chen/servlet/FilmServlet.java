package com.chen.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.entity.Film;
import com.chen.entity.Language;
import com.chen.service.FilmService;
import com.chen.service.impl.FilmServiceImpl;

/**
 * Servlet implementation class FilmServlet
 */
public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FilmService filmService = new FilmServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		HttpSession session = request.getSession();
		if(op!=null&&op.equals("delete")){
			String id = request.getParameter("id");
			filmService.deletById(id);
			List<Film> films = filmService.getAllFilms();
			session.setAttribute("films",films);
			response.sendRedirect("films.jsp");
		}else if(op!=null&&op.equals("toModify")){
			String id = request.getParameter("id");
			 Map<String,Object> maps = filmService.findById(id); 
			session.setAttribute("obj", maps.get("film"));
			session.setAttribute("lans", maps.get("lans"));
			response.sendRedirect("update.jsp");
		}else if(op!=null&&op.equals("modify")){
			String id = request.getParameter("id");
			String languageId = request.getParameter("languageId");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			Film  film = new Film();
			film.setId(Integer.parseInt(id));
			film.setLanguageId(Integer.parseInt(languageId));
			film.setTitle(title);
			film.setDescription(description);
			filmService.update(film);
			List<Film> films = filmService.getAllFilms();
			session.setAttribute("films",films);
			response.sendRedirect("films.jsp");
		}else if(op!=null&&op.equals("toAdd")){
			List<Film> films = filmService.getAllFilms();
			 	List<Language> lans = filmService.getLanguages(); 
				session.setAttribute("lans", lans);
			response.sendRedirect("add.jsp");
		}else if(op!=null&&op.equals("add")){
			String languageId = request.getParameter("languageId");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			Film  film = new Film();
			film.setLanguageId(Integer.parseInt(languageId));
			film.setTitle(title);
			film.setDescription(description);
			filmService.add(film);
			List<Film> films = filmService.getAllFilms();
			session.setAttribute("films",films);
			response.sendRedirect("films.jsp");
	}
			
		
	}

}
