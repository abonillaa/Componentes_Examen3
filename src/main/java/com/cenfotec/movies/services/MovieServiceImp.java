package com.cenfotec.movies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.movies.models.Movie;
import com.cenfotec.movies.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	MovieRepository repository;
	
	@Override
	public Movie saveMovie(Movie newMovie) {
		return repository.save(newMovie);
	}

	@Override
	public List<Movie> getAllMovies() {
		return repository.findAll();
	}

	@Override
	public Movie updateMovie(Movie movie) {
		return repository.save(movie);
	}

	@Override
	public void deleteMovie(long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Movie> findMovie(long id) {
		return repository.findById(id);
	}

	@Override
	public List<Movie> findByTitulo(String titulo) {
		return repository.findByTituloContaining(titulo);
	}

	@Override
	public List<Movie> findByRangoPresupuesto(int primerValor, int segundoValor) {
		return repository.findByPresupuestoBetween(primerValor, segundoValor);
	}
	
	@Override
	public List<Movie> findByRangoDuracion(float primerValor, float segundoValor) {
		return repository.findByDuracionBetween(primerValor, segundoValor);
	}

	@Override
	public List<Movie> findByDiaYMes(int dia, int mes) {
		return repository.findByDayAndMonth(dia, mes);
	}

	@Override
	public List<Movie> findByDiaYMesYAnno(int dia, int mes, int anno) {
		return repository.findByDayAndMonthAndYear(dia, mes, anno);
	}

	@Override
	public List<Movie> findByAnno(int anno) {
		return repository.findByYear(anno);
	}
}
