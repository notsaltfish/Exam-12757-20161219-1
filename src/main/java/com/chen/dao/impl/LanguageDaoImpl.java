package com.chen.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chen.dao.LanguageDao;
import com.chen.entity.Film;
import com.chen.entity.Language;
import com.chen.util.DbUtil;

public class LanguageDaoImpl implements LanguageDao{

	@Override
	public List<Language> getLanguages(String conditions) {
		List<Language> films = new ArrayList<Language>();
		Language film = null;
		List<Object> params = new ArrayList<Object>();
		String sql = "";
		if(conditions!=null){
			sql = "  select * from language where 1=1 "+conditions;
			params.add(conditions);
		}
		
		//ResultSet rs = DbUtil.executeQuery(sql, params);
		ResultSet rs = DbUtil.getResultSet(sql);
		try {
			while(rs.next()){
				film = getLanguageInfo(rs);
				films.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbUtil.CloseAll();
		}
		return films;
		
		
	}

	private Language getLanguageInfo(ResultSet rs) {
		Language language = new Language();
		try {
			language.setId(rs.getInt(1));
			language.setName(rs.getString(2));
			language.setLastUpdate(rs.getDate(3));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return language;
	}

}
