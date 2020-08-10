package com.cenfotec.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cenfotec.movies.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	List<Movie> findByTituloContaining(String nombre);
	List<Movie> findByPresupuestoBetween(int primerValor, int segundoValor);
	List<Movie> findByDuracionBetween(float primerValor, float segundoValor);
	
	@Query("SELECT peli FROM Movie peli WHERE DAY(peli.fechaLanzamiento) = ?1 AND MONTH(peli.fechaLanzamiento) = ?2 AND YEAR(peli.fechaLanzamiento) = ?3")
	List<Movie> findByDayAndMonthAndYear(int dia, int mes, int anno);
	
	@Query("SELECT peli FROM Movie peli WHERE YEAR(peli.fechaLanzamiento) = ?1")
	List<Movie> findByYear(int anno);
	
	@Query("SELECT peli FROM Movie peli WHERE DAY(peli.fechaLanzamiento) = ?1 AND MONTH(peli.fechaLanzamiento) = ?2")
	List<Movie> findByDayAndMonth(int dia, int mes);
}
