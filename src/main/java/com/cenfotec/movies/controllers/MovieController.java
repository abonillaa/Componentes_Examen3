package com.cenfotec.movies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.movies.models.Movie;
import com.cenfotec.movies.services.MovieService;
import com.cenfotec.movies.services.MovieService;
import com.cenfotec.movies.models.Movie;

@RestController
@RequestMapping({"/movies"})
public class MovieController {
	
	@Autowired
	private MovieService service;


	@GetMapping
	public List findAll(){
		return service.getAllMovies();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Movie> findById(@PathVariable long id){
	 return service.findMovie(id).map(record -> ResponseEntity.ok().body(record))
			 .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Movie create(@RequestBody Movie movie){
		return service.saveMovie(movie);
	}
	
	@PutMapping(value="/{id}")
	 public ResponseEntity<Movie> update(@PathVariable("id") long id, @RequestBody Movie movie){
	 return service.findMovie(id)
		 .map(record -> {
			 record.setTitulo(movie.getTitulo());
			 record.setPresupuesto(movie.getPresupuesto());
			 record.setDuracion(movie.getDuracion());
			 record.setLenguaje(movie.getLenguaje());
			 record.setFechaLanzamiento(movie.getFechaLanzamiento());
			 
			Movie updated = service.updateMovie(record);
		 	return ResponseEntity.ok().body(updated);
		 }).orElse(ResponseEntity.notFound().build());
	 }
	
	@DeleteMapping(path ={"/{id}"})
	 public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return service.findMovie(id)
			 .map(record -> {
				 service.deleteMovie(id);
				 return ResponseEntity.ok().build();
			 }).orElse(ResponseEntity.notFound().build());
	 }
	
	@GetMapping(path = {"titulo/{titulo}"})
	public List<Movie> findByTitulo(@PathVariable String titulo){
		return service.findByTitulo(titulo);
	}
	
	@GetMapping(path = {"presupuesto/{primerValor}/{segundoValor}"})
	public List<Movie> findByRangoPresupuesto(@PathVariable int primerValor, @PathVariable int segundoValor){
		return service.findByRangoPresupuesto(primerValor, segundoValor);
	}
	
	@GetMapping(path = {"duracion/{primerValor}/{segundoValor}"})
	public List<Movie> findByRangoDuracion(@PathVariable float primerValor, @PathVariable float segundoValor){
		return service.findByRangoDuracion(primerValor, segundoValor);
	}
	
	@GetMapping(path = {"fecha/{dia}/{mes}"})
	public List<Movie> findByDayAndMonth(@PathVariable int dia, @PathVariable int mes){
		return service.findByDiaYMes(dia, mes);
	}
	
	@GetMapping(path = {"fecha/{dia}/{mes}/{anno}"})
	public List<Movie> findByDayAndMonthAndYear(@PathVariable int dia, @PathVariable int mes, @PathVariable int anno){
		return service.findByDiaYMesYAnno(dia, mes, anno);
	}
	
	@GetMapping(path = {"fecha/{anno}"})
	public List<Movie> findByYear(@PathVariable int anno){
		return service.findByAnno(anno);
	}
	
}
