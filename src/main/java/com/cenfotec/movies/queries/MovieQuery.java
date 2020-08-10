package com.cenfotec.movies.queries;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.movies.models.Movie;
import com.cenfotec.movies.services.MovieService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class MovieQuery implements GraphQLQueryResolver{

	@Autowired
	private MovieService service;
	
	public List<Movie> getMovies(){
		return service.getAllMovies();
	}
	
	public Optional<Movie> getMovie(long id){
		return service.findMovie(id);
	}
	
	public List<Movie> findByTitulo(String titulo) {
		return service.findByTitulo(titulo);
	}
	
	public List<Movie> findByAnno(int anno) {
		return service.findByAnno(anno);
	}
}
