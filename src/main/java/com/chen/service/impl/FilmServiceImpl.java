package com.chen.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chen.dao.FilmDao;
import com.chen.dao.LanguageDao;
import com.chen.dao.impl.FilmDaoImpl;
import com.chen.dao.impl.LanguageDaoImpl;
import com.chen.entity.Film;
import com.chen.entity.Language;
import com.chen.service.FilmService;

public class FilmServiceImpl implements FilmService {

	private FilmDao filmDao = new FilmDaoImpl();
	private LanguageDao languageDao = new LanguageDaoImpl();
	@Override
	public List<Film> getAllFilms() {
		String condition  = "";
		
		return filmDao.getFilms(condition);
	}
	@Override
	public void deletById(String id) {
		
			filmDao.deleteById(id);
	}
	@Override
	public Map findById(String id) {
		Map<String,Object> maps = new HashMap<String,Object>();
		String condition = " and film_id="+id;
		Film film  =filmDao.getFilms(condition).get(0);
		List<Language> lans = languageDao.getLanguages("");
		maps.put("film", film);
		maps.put("lans", lans);
		return maps;
	}
	@Override
	public void update(Film film) {
		filmDao.update(film);
		
		
	}
	@Override
	public void add(Film film) {

		filmDao.add(film);
	}
	@Override
	public List<Language> getLanguages() {
		List<Language> lans = languageDao.getLanguages("");
		
		return lans;
	}
	@Override
	public List<Film> findAllFilms(int curPage, int pageSize) {
		String condition = "limit "+(curPage-1)*pageSize+","+pageSize;
		
		return filmDao.getFilms(condition);
	}
	@Override
	/**
	 * 查询所有电影的总数
	 */
	public int getCount() {
		// TODO Auto-generated method stub
		
		return filmDao.getCount();
	}

	
	
}
