package com.cenfotec.movies.services;

import java.util.List;
import java.util.Optional;

import com.cenfotec.movies.models.Movie;

public interface MovieService {
	public Movie saveMovie(Movie newMovie);
	public List<Movie> getAllMovies();
	public Movie updateMovie(Movie movie);
	public void deleteMovie(long id);
	public Optional<Movie> findMovie(long id);
	public List<Movie> findByTitulo(String titulo);
	public List<Movie> findByRangoPresupuesto(int primerValor, int segundoValor);
	public List<Movie> findByRangoDuracion(float primerValor, float segundoValor);
	public List<Movie> findByDiaYMes(int dia, int mes);
	public List<Movie> findByDiaYMesYAnno(int dia, int mes, int anno);
	public List<Movie> findByAnno(int anno);

}
