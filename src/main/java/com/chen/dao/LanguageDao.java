package com.chen.dao;

import java.util.List;

import com.chen.entity.Language;

public interface LanguageDao {
	public List<Language> getLanguages(String conditions);
}
