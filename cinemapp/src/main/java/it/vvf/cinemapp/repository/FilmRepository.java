package it.vvf.cinemapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.vvf.cinemapp.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByTitoloContainingIgnoreCase(String titolo);
    boolean existsByTitolo(String titolo);
}
