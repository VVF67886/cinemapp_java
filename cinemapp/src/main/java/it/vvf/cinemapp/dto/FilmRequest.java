package it.vvf.cinemapp.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmRequest {
    @NotBlank(message = "Il titolo è obbligatorio")
    private String titolo;
    
    @NotBlank(message = "La trama è obbligatoria")
    private String trama;
    
    private String immagine;  // Base64
    
    @NotNull(message = "La data di uscita è obbligatoria")
    private LocalDate dataUscita;
}