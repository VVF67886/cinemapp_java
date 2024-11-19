package it.vvf.cinemapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.vvf.cinemapp.dto.FilmRequest;
import it.vvf.cinemapp.dto.FilmResponse;
import it.vvf.cinemapp.exceptions.BadRequestException;
import it.vvf.cinemapp.exceptions.ResourceNotFoundException;
import it.vvf.cinemapp.model.Film;
import it.vvf.cinemapp.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmService {
    
    private final FilmRepository filmRepository;
    
    public FilmResponse createFilm(FilmRequest request) {
        if (filmRepository.existsByTitolo(request.getTitolo())) {
            throw new BadRequestException("Film già presente con questo titolo");
        }
        
        Film film = Film.builder()
                .titolo(request.getTitolo())
                .trama(request.getTrama())
                .immagine(request.getImmagine())
                .dataUscita(request.getDataUscita())
                .dataInserimento(LocalDateTime.now())
                .build();
        
        return mapToResponse(filmRepository.save(film));
    }
    
    public List<FilmResponse> getAllFilms(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("dataUscita").descending());
        return filmRepository.findAll(pageable)
                .getContent()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    
    public FilmResponse getFilmById(Long id) {
        return filmRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Film non trovato con ID: " + id));
    }
    
    public List<FilmResponse> searchFilmsByTitle(String titolo) {
        return filmRepository.findByTitoloContainingIgnoreCase(titolo)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    
    public FilmResponse updateFilm(Long id, FilmRequest request) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Film non trovato con ID: " + id));
        
        film.setTitolo(request.getTitolo());
        film.setTrama(request.getTrama());
        if (request.getImmagine() != null) {
            film.setImmagine(request.getImmagine());
        }
        film.setDataUscita(request.getDataUscita());
        
        return mapToResponse(filmRepository.save(film));
    }
    
    public void deleteFilm(Long id) {
        if (!filmRepository.existsById(id)) {
            throw new ResourceNotFoundException("Film non trovato con ID: " + id);
        }
        filmRepository.deleteById(id);
    }
    
    private FilmResponse mapToResponse(Film film) {
        return FilmResponse.builder()
                .id(film.getId())
                .titolo(film.getTitolo())
                .trama(film.getTrama())
                .immagine(film.getImmagine())
                .dataUscita(film.getDataUscita())
                .dataInserimento(film.getDataInserimento())
                .build();
    }
}
