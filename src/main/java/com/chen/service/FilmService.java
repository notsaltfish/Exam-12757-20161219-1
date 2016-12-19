package com.chen.service;

import java.util.List;
import java.util.Map;

import com.chen.entity.Film;
import com.chen.entity.Language;


public interface FilmService {
 public List<Film> getAllFilms();

public void deletById(String id);

public Map findById(String id);

public void update(Film film);

public void add(Film film);

public List<Language> getLanguages();
}
