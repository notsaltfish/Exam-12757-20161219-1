package com.chen.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chen.dao.FilmDao;
import com.chen.entity.Film;
import com.chen.util.DbUtil;

public class FilmDaoImpl implements FilmDao{

	@Override
	//根据条件查询电影
	public List<Film> getFilms(String conditions) {
		List<Film> films = new ArrayList<Film>();
		Film film = null;
		List<Object> params = new ArrayList<Object>();
		String sql = "";
		if(conditions!=null){
			sql = "SELECT f.*,l1.name AS language1,l2.name AS lanaguage2  FROM LANGUAGE l1, film f"
						+" LEFT JOIN LANGUAGE l2 ON f.original_language_id = l2.language_id"
						+" WHERE f.language_id = l1.language_id   "+conditions;
			params.add(conditions);
		}
		
		//ResultSet rs = DbUtil.executeQuery(sql, params);
		ResultSet rs = DbUtil.getResultSet(sql);
		try {
			while(rs.next()){
				film = getFilminfo(rs);
				films.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbUtil.CloseAll();
		}
		return films;
		
	}

	private Film getFilminfo(ResultSet rs) {
		Film film = new Film();
		
		try {
			film.setId(rs.getInt(1));
			film.setTitle(rs.getString(2));;
			film.setDescription(rs.getString(3));
			film.setReleaseYear(rs.getInt(4));
			film.setLanguageId(rs.getInt(5));
			//film.setOriginalLanguage(rs.getString(6));
			film.setRentalDuration(rs.getInt(7));
			film.setRentalRate(rs.getDouble(8));
			film.setLength(rs.getInt(9));
			film.setReplacementCost(rs.getInt(10));
			film.setRating(rs.getString(11));
			film.setSpecialFeatures(rs.getString(12));
			film.setLastUpdate(rs.getDate(13));
			film.setLanguageName(rs.getString(14));
			film.setOriginalLanguage(rs.getString(15));
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return film;
		
		
	}

	@Override
	public void deleteById(String id) {
	/*String sql1 = "delete from film_actor where film_id = "+id ;
	String sql2 =		 " delete from film_category  where film_id = "+id;
	String sql3 =		 " delete from inventory  where film_id = "+id;*/
	String sql4 =		 "SET FOREIGN_KEY_CHECKS = 0";
	String sql5 =		 " delete from film  where film_id = "+id;
	String sql6 =		 " SET FOREIGN_KEY_CHECKS = 1";
	Connection conn = DbUtil.getConnetion();
	try {
		Statement sta = conn.createStatement();
		sta.executeUpdate(sql4);
		sta.executeUpdate(sql5);
		sta.executeUpdate(sql6);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	/*DbUtil.executeUpdate(sql1, null);
	DbUtil.executeUpdate(sql2, null);
	DbUtil.executeUpdate(sql3, null);*/
/*	DbUtil.executeUpdate(sql4, null);
	DbUtil.executeUpdate(sql5, null);
	DbUtil.executeUpdate(sql6, null);*/
	DbUtil.CloseAll();
		
	}

	@Override
	public void update(Film film) {
		String sql = "update film set title='"+film.getTitle()+"',language_id= "+film.getLanguageId()
			              +", description= '"+film.getDescription()
			              +"' where film_id = "+film.getId();
		DbUtil.executeUpdate(sql, null);
		DbUtil.CloseAll();
	}

	@Override
	public void add(Film film) {
		String sql = "insert into film(title,description,language_id) values(?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(film.getTitle());
		params.add(film.getDescription());
		params.add(film.getLanguageId());
		DbUtil.executeUpdate(sql, params);
		DbUtil.CloseAll();
	}

	@Override
	public int getCount() {
		String sql = "select count(*) from film";
		ResultSet rs = DbUtil.getResultSet(sql);
		int count=0;
		try {
			rs.next();
			count= rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.CloseAll();
		return count;
	}

	
}
