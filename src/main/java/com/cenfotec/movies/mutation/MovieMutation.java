package com.cenfotec.movies.mutation;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.movies.models.Movie;
import com.cenfotec.movies.services.MovieService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import javassist.NotFoundException;

@Component
public class MovieMutation  implements GraphQLMutationResolver{
	@Autowired
	private MovieService service;
	
	public Movie createMovie(String titulo, int presupuesto, float duracion, String lenguaje, String fechaLanzamiento) throws ParseException {
		Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaLanzamiento);
		return service.saveMovie(new Movie(null, titulo, presupuesto, duracion, lenguaje, fecha));
	}
	
	public Movie updateMovie(long ID, String titulo, int presupuesto, float duracion, String lenguaje, String fechaLanzamiento) throws NotFoundException, ParseException {
		Optional<Movie> optMovie = service.findMovie(ID);
		if(optMovie.isPresent()) {
			Movie movie = optMovie.get();
			
			Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaLanzamiento);
			movie.setTitulo(titulo);
			movie.setPresupuesto(presupuesto);
			movie.setDuracion(duracion);
			movie.setLenguaje(lenguaje);
			movie.setFechaLanzamiento(fecha);
			
			service.saveMovie(movie);
			return movie;
		}
			
		throw new NotFoundException("Not found Movie to update!");
	}
	
	public boolean deleteMovie(long ID) {
		service.deleteMovie(ID);
		return true;
	}

}
