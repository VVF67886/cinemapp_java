package it.vvf.cinemapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "films")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titolo;
    
    @Column(columnDefinition = "TEXT")
    private String trama;
    
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String immagine;
    
    @Column(nullable = false)
    private LocalDate dataUscita;
    
    @Column(nullable = false)
    private LocalDateTime dataInserimento;
}
