package it.vvf.cinemapp.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.vvf.cinemapp.dto.FilmRequest;
import it.vvf.cinemapp.dto.FilmResponse;
import it.vvf.cinemapp.service.FilmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/films")
@RequiredArgsConstructor
@Tag(name = "Films", description = "API per la gestione dei film")
@Slf4j
public class FilmController {
    
    private final FilmService filmService;
    
    @PostMapping
    @Operation(summary = "Inserisce un nuovo film")
    public ResponseEntity<FilmResponse> createFilm(@Valid @RequestBody FilmRequest request) {
        log.info("Creazione nuovo film: {}", request.getTitolo());
        return ResponseEntity.status(HttpStatus.CREATED).body(filmService.createFilm(request));
    }
    
    @GetMapping
    @Operation(summary = "Recupera tutti i film")
    public ResponseEntity<List<FilmResponse>> getAllFilms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(filmService.getAllFilms(page, size));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Recupera un film tramite ID")
    public ResponseEntity<FilmResponse> getFilmById(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.getFilmById(id));
    }
    
    @GetMapping("/search")
    @Operation(summary = "Cerca film per titolo")
    public ResponseEntity<List<FilmResponse>> searchFilms(@RequestParam String titolo) {
        return ResponseEntity.ok(filmService.searchFilmsByTitle(titolo));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Aggiorna un film")
    public ResponseEntity<FilmResponse> updateFilm(
            @PathVariable Long id,
            @Valid @RequestBody FilmRequest request) {
        return ResponseEntity.ok(filmService.updateFilm(id, request));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un film")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}