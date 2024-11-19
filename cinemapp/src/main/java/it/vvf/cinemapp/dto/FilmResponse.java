package it.vvf.cinemapp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmResponse {
    private Long id;
    private String titolo;
    private String trama;
    private String immagine;
    private LocalDate dataUscita;
    private LocalDateTime dataInserimento;
}
