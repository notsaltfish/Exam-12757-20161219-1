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
import com.chen.util.PageUtil;

/**
 * Servlet implementation class FilmServlet
 * @author chenyong
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
		if(op!=null&&op.equals("delete")){//删除电影
			String id = request.getParameter("id");
			filmService.deletById(id);
			pagenation(request,response,session);
			response.sendRedirect("films.jsp");
		}else if(op!=null&&op.equals("toModify")){//前往修改页面
			String id = request.getParameter("id");
			 Map<String,Object> maps = filmService.findById(id); 
			session.setAttribute("obj", maps.get("film"));
			session.setAttribute("lans", maps.get("lans"));
			response.sendRedirect("update.jsp");
		}else if(op!=null&&op.equals("modify")){//执行修改操作
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
			pagenation(request,response,session);
			response.sendRedirect("films.jsp");
		}else if(op!=null&&op.equals("toAdd")){//前往添加页面
			List<Film> films = filmService.getAllFilms();
			 	List<Language> lans = filmService.getLanguages(); 
				session.setAttribute("lans", lans);
			response.sendRedirect("add.jsp");
		}else if(op!=null&&op.equals("add")){//执行添加操作。
			String languageId = request.getParameter("languageId");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			Film  film = new Film();
			film.setLanguageId(Integer.parseInt(languageId));
			film.setTitle(title);
			film.setDescription(description);
			filmService.add(film);
			pagenation(request,response,session);
			response.sendRedirect("films.jsp");
	}else if(op!=null&&op.equals("pageQuery")){//执行分页查询
		pagenation(request,response,session);
		
		//List<Film> films = filmService.getAllFilms();
	
		response.sendRedirect("films.jsp");
	}
			
		
	}

	/**
	 * 分页方法
	 * @param request
	 * @param response
	 * @param session
	 */
	private void pagenation(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		int count = filmService.getCount();
		//调用分页工具类<=>逻辑代码
		PageUtil pageUtil=new PageUtil(9, count);
		int curPage=1;
		String strCurPage=request.getParameter("pageNum");
		if(strCurPage!=null){
			curPage = Integer.parseInt(strCurPage);
		}
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		List<Film> films = filmService.findAllFilms(curPage, 9);
		
		session.setAttribute("page", pageUtil);
		session.setAttribute("films",films);
	}
	
	

}
