package com.chen.dao;

import java.util.List;

import com.chen.entity.Film;

public interface FilmDao {
  public List<Film> getFilms(String conditions);

public void deleteById(String id);

public void update(Film film);

public void add(Film film);

}
