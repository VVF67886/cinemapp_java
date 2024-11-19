package it.vvf.cinemapp.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdateRequest implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4333322758277236176L;

	@NotBlank(message = "L'email è obbligatoria")
    @Email(message = "Formato email non valido")
    private String email;
    
    @NotBlank(message = "Il nome completo è obbligatorio")
    private String fullName;
    
    private String password; // Opzionale per l'aggiornamento
}